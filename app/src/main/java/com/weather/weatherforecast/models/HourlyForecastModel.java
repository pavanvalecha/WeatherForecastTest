package com.weather.weatherforecast.models;

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

    public static HourlyForecastModel fromJSON(String hourlyDataStr){
        HourlyForecastModel hourlyForecast = new HourlyForecastModel();
        return hourlyForecast;
    }


}
