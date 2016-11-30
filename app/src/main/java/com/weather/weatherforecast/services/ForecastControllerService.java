package com.weather.weatherforecast.services;

import android.app.Activity;
import android.util.Log;

import com.weather.weatherforecast.activities.MainActivity;
import com.weather.weatherforecast.asyncconnectors.ApiService;
import com.weather.weatherforecast.models.WeatherForecastModel;

import org.json.JSONException;

/**
 * Created by Pawan on 26-11-2016.
 */

public class ForecastControllerService {

    private WeatherForecastModel weatherForecast;
    private ApiService apiService;
    Activity activityReference;

    public ForecastControllerService(Activity callingActivityReference, String latLonStr){
        Log.d(getClass().getName(), "ForecastControllerService");
        activityReference = callingActivityReference;
        apiService = new ApiService(this);
        apiService.execute(latLonStr);
    }

    public WeatherForecastModel setResponseAndConvertToModel(String responseString){
        Log.d(getClass().getName(), "setResponseAndConvertToModel");
        try {
            return WeatherForecastModel.fromJSON(responseString);
        } catch (JSONException e) {
            return null;
        }
    }

    public WeatherForecastModel getWeatherForecast() {
        Log.d(getClass().getName(), "getWeatherForecast");
        return weatherForecast;
    }

    public void setWeatherForecast(WeatherForecastModel weatherForecast) {
        Log.d(getClass().getName(), "setWeatherForecast");
        this.weatherForecast = weatherForecast;
    }

    public void setDataObjectAndSendTOUI(WeatherForecastModel weatherForecast){
        Log.d(getClass().getName(), "sendDataTOUI");
        this.weatherForecast = weatherForecast;
        if(activityReference instanceof MainActivity){
            ((MainActivity)activityReference).setDataOnUI( getWeatherForecast() );
        }
    }

}
