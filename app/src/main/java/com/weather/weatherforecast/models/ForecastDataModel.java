package com.weather.weatherforecast.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pawan on 26-11-2016.
 */

public class ForecastDataModel {

    private static final String FIELD_TIME = "time";
    private static final String FIELD_SUMMARY = "summary";
    private static final String FIELD_ICON = "icon";
    private static final String FIELD_PRECIPINTENSITY = "precipIntensity";
    private static final String FIELD_PRECIPPROBABILITY = "precipProbability";
    private static final String FIELD_TEMPRATURE = "temperature";
    private static final String FIELD_APPARENTTEMPRATURE = "apparentTemperature";
    private static final String FIELD_DEWPOINT = "dewPoint";
    private static final String FIELD_HUMIDITY = "humidity";
    private static final String FIELD_WINDSPEED = "windSpeed";
    private static final String FIELD_WINDBEARING = "windBearing";
    private static final String FIELD_CLOUDCOVER = "cloudCover";
    private static final String FIELD_PRESSURE = "pressure";
    private static final String FIELD_OZONE = "ozone";

    private long time;
    private String summary;
    private String icon;
    private int precipIntensity;
    private int precipProbability;
    private double temperature;
    private double apparentTemperature;
    private double dewPoint;
    private double humidity;
    private double windSpeed;
    private int windBearing;
    private int cloudCover;
    private double pressure;
    private double ozone;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

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

    public int getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(int precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public int getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(int precipProbability) {
        this.precipProbability = precipProbability;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(int windBearing) {
        this.windBearing = windBearing;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    public static ForecastDataModel fromJSON(String currentDataStr) throws JSONException {
        ForecastDataModel currentForecast = new ForecastDataModel();

        JSONObject currentforecastJsonObj = new JSONObject(currentDataStr);
        currentForecast.setSummary( currentforecastJsonObj.getString(FIELD_SUMMARY) );
        currentForecast.setCloudCover( currentforecastJsonObj.getInt(FIELD_CLOUDCOVER) );
        currentForecast.setPrecipIntensity( currentforecastJsonObj.getInt(FIELD_PRECIPINTENSITY) );
        currentForecast.setPressure( currentforecastJsonObj.getDouble(FIELD_PRESSURE) );
        currentForecast.setTemperature( currentforecastJsonObj.getDouble(FIELD_TEMPRATURE) );
        currentForecast.setApparentTemperature( currentforecastJsonObj.getDouble(FIELD_APPARENTTEMPRATURE) );
        currentForecast.setOzone( currentforecastJsonObj.getDouble(FIELD_OZONE) );
        currentForecast.setTime( currentforecastJsonObj.getLong(FIELD_TIME) );
        currentForecast.setDewPoint( currentforecastJsonObj.getDouble(FIELD_DEWPOINT) );
        currentForecast.setWindSpeed( currentforecastJsonObj.getDouble(FIELD_WINDSPEED) );
        currentForecast.setHumidity( currentforecastJsonObj.getDouble(FIELD_HUMIDITY) );
        currentForecast.setWindBearing( currentforecastJsonObj.getInt(FIELD_WINDBEARING));

        return currentForecast;
    }

}
