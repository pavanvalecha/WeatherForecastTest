package com.weather.weatherforecast.asyncconnectors;

/**
 * Created by Pawan on 26-11-2016.
 */

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.os.AsyncTask;
import android.util.Log;

import com.weather.weatherforecast.Constants;
import com.weather.weatherforecast.services.ForecastControllerService;

public class ApiService extends AsyncTask<String, Integer, String > {


    ForecastControllerService controllerService;
    public ApiService(ForecastControllerService controllerService) {
        this.controllerService = controllerService;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        controllerService.setResponseAndConvertToModel(result);
    }


    @Override
    protected String doInBackground(String... params) {
        String str = "";
        HttpClient httpclient = new DefaultHttpClient();
        //HttpGet httpget = new HttpGet(params[0]);
        HttpGet httpget = new HttpGet(Constants.HOST_NAME_PATH+Constants.API_KEY+"/"+params[0]);
        try {
            httpget.setHeader("Content-Type", "application/json");
            HttpResponse response = httpclient.execute(httpget);
            byte[] result = EntityUtils.toByteArray(response.getEntity());
            str = new String(result, "UTF-8");
            Log.d(getClass().getName(), "String Response" + str);
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
        }

        return str;
    }
}
