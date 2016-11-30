package com.weather.weatherforecast;

import com.weather.weatherforecast.models.ForecastDataModel;
import com.weather.weatherforecast.models.WeatherForecastModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DataInitializeUnitTest {

    WeatherForecastModel weatherForecast;
    ForecastDataModel forecastDataModel;

    @Before
    public void setUp() {
        weatherForecast = new WeatherForecastModel();
        forecastDataModel = new ForecastDataModel();
        forecastDataModel.setSummary("Test Summary");
        forecastDataModel.setTemperature(28);
        forecastDataModel.setApparentTemperature(32);
        forecastDataModel.setHumidity(0.62);
        weatherForecast.setCurrentForecast(forecastDataModel);

    }

    @Test
    public void currentForecastDataIsNotNull() {
        assertNotNull(forecastDataModel);
    }

    @Test
    public void weatherForecastIsNotNull() {
        assertNotNull(weatherForecast);
    }

}