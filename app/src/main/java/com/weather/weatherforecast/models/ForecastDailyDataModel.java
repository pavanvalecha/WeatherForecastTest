package com.weather.weatherforecast.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pawan on 26-11-2016.
 */

public class ForecastDailyDataModel {

    private static final String FIELD_TIME = "time";
    private static final String FIELD_SUMMARY = "summary";
    private static final String FIELD_ICON = "icon";
    private static final String FIELD_SUNRISETIME = "sunriseTime";
    private static final String FIELD_SUNSETTIME = "sunsetTime";
    private static final String FIELD_MOONPHASE = "moonPhase";
    private static final String FIELD_PRECIPINTENSITY = "precipIntensity";
    private static final String FIELD_PRECIPINTENSITYMAX = "precipIntensityMax";
    private static final String FIELD_PRECIPPROBABILITY = "precipProbability";
    private static final String FIELD_TEMPRATUREMIN = "temperatureMin";
    private static final String FIELD_TEMPRATUREMINTIME = "temperatureMinTime";
    private static final String FIELD_TEMPRATUREMAX = "temperatureMax";
    private static final String FIELD_TEMPRATUREMAXTIME = "temperatureMaxTime";
    private static final String FIELD_APPARENTTEMPRATUREMIN = "apparentTemperatureMin";
    private static final String FIELD_APPARENTTEMPRATUREMINTIME = "apparentTemperatureMinTime";
    private static final String FIELD_APPARENTTEMPRATUREMAX = "apparentTemperatureMax";
    private static final String FIELD_APPARENTTEMPRATUREMAXTIME = "apparentTemperatureMaxTime";
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
    private long sunriseTime;
    private long sunsetTime;
    private double moonPhase;
    private int precipIntensity;
    private int precipIntensityMax;
    private int precipProbability;
    private double temperatureMin;
    private long temperatureMinTime;
    private double temperatureMax;
    private long temperatureMaxTime;
    private double apparentTemperatureMin;
    private long apparentTemperatureMinTime;
    private double apparentTemperatureMax;
    private long apparentTemperatureMaxTime;
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

    public long getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public long getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public double getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public int getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(int precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public int getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(int precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public int getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(int precipProbability) {
        this.precipProbability = precipProbability;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(long temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public long getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(long apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public long getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(long apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
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

    public static ForecastDailyDataModel fromJSON(String dailyDataStr) throws JSONException {
        ForecastDailyDataModel forecastDailyData = new ForecastDailyDataModel();

        JSONObject dailyForecastJsonObj = new JSONObject(dailyDataStr);
        forecastDailyData.setIcon(dailyForecastJsonObj.getString(FIELD_ICON));
        forecastDailyData.setSummary(dailyForecastJsonObj.getString(FIELD_SUMMARY));
        forecastDailyData.setWindBearing(dailyForecastJsonObj.getInt(FIELD_WINDBEARING));
        forecastDailyData.setHumidity(dailyForecastJsonObj.getDouble(FIELD_HUMIDITY));
        forecastDailyData.setApparentTemperatureMax( dailyForecastJsonObj.getDouble(FIELD_APPARENTTEMPRATUREMAX) );
        forecastDailyData.setApparentTemperatureMin( dailyForecastJsonObj.getDouble(FIELD_APPARENTTEMPRATUREMIN) );
        forecastDailyData.setApparentTemperatureMaxTime( dailyForecastJsonObj.getLong(FIELD_APPARENTTEMPRATUREMAXTIME) );
        forecastDailyData.setApparentTemperatureMinTime( dailyForecastJsonObj.getLong(FIELD_APPARENTTEMPRATUREMINTIME) );
        forecastDailyData.setSunriseTime(dailyForecastJsonObj.getLong(FIELD_SUNRISETIME));
        forecastDailyData.setSunsetTime( dailyForecastJsonObj.getLong(FIELD_SUNSETTIME));
        forecastDailyData.setDewPoint( dailyForecastJsonObj.getDouble(FIELD_DEWPOINT) );
        forecastDailyData.setMoonPhase( dailyForecastJsonObj.getDouble(FIELD_MOONPHASE) );
        forecastDailyData.setPressure( dailyForecastJsonObj.getDouble(FIELD_PRESSURE) );
        forecastDailyData.setPrecipIntensity(dailyForecastJsonObj.getInt(FIELD_PRECIPINTENSITY));
        forecastDailyData.setCloudCover( dailyForecastJsonObj.getInt(FIELD_CLOUDCOVER));
        forecastDailyData.setWindSpeed(dailyForecastJsonObj.getDouble(FIELD_WINDSPEED) );
        forecastDailyData.setApparentTemperatureMinTime(dailyForecastJsonObj.getLong(FIELD_APPARENTTEMPRATUREMINTIME));
        forecastDailyData.setTemperatureMax(dailyForecastJsonObj.getDouble(FIELD_TEMPRATUREMAX));
        forecastDailyData.setTemperatureMin(dailyForecastJsonObj.getDouble(FIELD_TEMPRATUREMIN));
        forecastDailyData.setTemperatureMaxTime(dailyForecastJsonObj.getLong(FIELD_TEMPRATUREMAXTIME));
        forecastDailyData.setTemperatureMinTime(dailyForecastJsonObj.getLong(FIELD_TEMPRATUREMINTIME));
        forecastDailyData.setPrecipIntensityMax(dailyForecastJsonObj.getInt(FIELD_PRECIPINTENSITYMAX));
        forecastDailyData.setPrecipProbability( dailyForecastJsonObj.getInt(FIELD_PRECIPPROBABILITY) );
        forecastDailyData.setOzone( dailyForecastJsonObj.getDouble(FIELD_OZONE) );
        forecastDailyData.setTime( dailyForecastJsonObj.getLong(FIELD_TIME) );

        return forecastDailyData;
    }
}
