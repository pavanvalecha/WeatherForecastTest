package com.weather.weatherforecast.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pawan on 26-11-2016.
 */

public class HourlyForecastModel {

    private static final String FIELD_SUMMARY = "summary";
    private static final String FIELD_ICON = "icon";
    private static final String FIELD_DATA = "data";

    private String summary;
    private String icon;
    ArrayList<ForecastDataModel> forecastDataModelArrayList;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<ForecastDataModel> getForecastDataModelArrayList() {
        return forecastDataModelArrayList;
    }

    public void setForecastDataModelArrayList(ArrayList<ForecastDataModel> forecastDataModelArrayList) {
        this.forecastDataModelArrayList = forecastDataModelArrayList;
    }

    public static HourlyForecastModel fromJSON(String hourlyDataStr) throws JSONException {
        HourlyForecastModel hourlyForecast = new HourlyForecastModel();

        ArrayList<ForecastDataModel> hourlyForecastDataModelArrayList = new ArrayList<ForecastDataModel>();;
        JSONObject hourlyForecastJsonObj = new JSONObject(hourlyDataStr);
        hourlyForecast.setIcon( hourlyForecastJsonObj.getString(FIELD_ICON) );
        hourlyForecast.setSummary( hourlyForecastJsonObj.getString(FIELD_SUMMARY) );
        JSONArray dailyForecastJsonObjJSONArray = hourlyForecastJsonObj.getJSONArray(FIELD_DATA);
        for(int i = 0; i < dailyForecastJsonObjJSONArray.length(); i++){
            hourlyForecastDataModelArrayList.add( ForecastDataModel.fromJSON(dailyForecastJsonObjJSONArray.get(i).toString()) );
        }
        hourlyForecast.setForecastDataModelArrayList(hourlyForecastDataModelArrayList);

        return hourlyForecast;
    }


}
