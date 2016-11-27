package com.weather.weatherforecast.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pawan on 26-11-2016.
 */

public class DailyForecastModel {

    private static final String FIELD_SUMMARY = "summary";
    private static final String FIELD_ICON = "icon";
    private static final String FIELD_DATA = "data";

    private String summary;
    private String icon;
    ArrayList<ForecastDailyDataModel> forecastDataModelArrayList;

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

    public ArrayList<ForecastDailyDataModel> getForecastDataModelArrayList() {
        return forecastDataModelArrayList;
    }

    public void setForecastDataModelArrayList(ArrayList<ForecastDailyDataModel> forecastDataModelArrayList) {
        this.forecastDataModelArrayList = forecastDataModelArrayList;
    }

    public static DailyForecastModel fromJSON(String dailyDataStr) throws JSONException {
        DailyForecastModel dailyForecast= new DailyForecastModel();
        ArrayList<ForecastDailyDataModel> forecastDataModelArrayList = new ArrayList<ForecastDailyDataModel>();;
        JSONObject dailyForecastJsonObj = new JSONObject(dailyDataStr);
        dailyForecast.setIcon( dailyForecastJsonObj.getString(FIELD_ICON) );
        dailyForecast.setSummary( dailyForecastJsonObj.getString(FIELD_SUMMARY) );
        JSONArray dailyForecastJsonObjJSONArray = dailyForecastJsonObj.getJSONArray(FIELD_DATA);
        for(int i = 0; i < dailyForecastJsonObjJSONArray.length(); i++){
            forecastDataModelArrayList.add( ForecastDailyDataModel.fromJSON(dailyForecastJsonObjJSONArray.get(i).toString()) );
        }
        dailyForecast.setForecastDataModelArrayList(forecastDataModelArrayList);
        return dailyForecast;
    }

}
