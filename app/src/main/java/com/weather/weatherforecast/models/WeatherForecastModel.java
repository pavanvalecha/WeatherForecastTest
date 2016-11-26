package com.weather.weatherforecast.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pawan on 26-11-2016.
 */

public class WeatherForecastModel {

    private static final String FIELD_LATITUDE = "latitude";
    private static final String FIELD_LONGITUDE = "longitude";
    private static final String FIELD_TIMEZONE = "timezone";
    private static final String FIELD_OFFSET = "offset";
    private static final String FIELD_CURRENT_FORECAST = "currently";
    private static final String FIELD_HOURLY_FORECAST = "hourly";
    private static final String FIELD_DAILY_FORECAST = "daily";


    private double latitude;
    private double longitude;
    private String timezone;
    private double offset;
    private ForecastDataModel currentForecast;
    private HourlyForecastModel hourlyForecast;
    private DailyForecastModel dailyForecast;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public ForecastDataModel getCurrentForecast() {
        return currentForecast;
    }

    public void setCurrentForecast(ForecastDataModel currentForecast) {
        this.currentForecast = currentForecast;
    }

    public HourlyForecastModel getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(HourlyForecastModel hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    public DailyForecastModel getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(DailyForecastModel dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public static WeatherForecastModel fromJSON(String responseStr) throws JSONException {
        WeatherForecastModel forecast = new WeatherForecastModel();

        JSONObject forecastJsonObj = new JSONObject(responseStr);
        forecast.setLatitude( forecastJsonObj.getDouble(FIELD_LATITUDE) );
        forecast.setLongitude( forecastJsonObj.getDouble(FIELD_LONGITUDE) );
        forecast.setTimezone(forecastJsonObj.getString(FIELD_TIMEZONE));
        forecast.setOffset(forecastJsonObj.getDouble(FIELD_OFFSET));
        forecast.setCurrentForecast( ForecastDataModel.fromJSON( forecastJsonObj.getString(FIELD_CURRENT_FORECAST ) ) );
        forecast.setHourlyForecast( HourlyForecastModel.fromJSON( forecastJsonObj.getString(FIELD_HOURLY_FORECAST ) ) );
        forecast.setDailyForecast( DailyForecastModel.fromJSON( forecastJsonObj.getString(FIELD_DAILY_FORECAST ) ) );

        return forecast;
    }


}
