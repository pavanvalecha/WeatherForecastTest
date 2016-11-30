package com.weather.weatherforecast;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.weather.weatherforecast.activities.MainActivity;
import com.weather.weatherforecast.models.ForecastDataModel;
import com.weather.weatherforecast.models.WeatherForecastModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityUIInstrumentedTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    TextView currentSummaryTextView, currentTempratureTextView,  currentFeelsTempratureTextView, currentHumidityTextView;
    WeatherForecastModel weatherForecast;
    ForecastDataModel forecastDataModel;

    public ActivityUIInstrumentedTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();

        weatherForecast = new WeatherForecastModel();
        forecastDataModel = new ForecastDataModel();
        forecastDataModel.setSummary("Test Summary");
        forecastDataModel.setTemperature(28);
        forecastDataModel.setApparentTemperature(32);
        forecastDataModel.setHumidity(0.62);
        weatherForecast.setCurrentForecast(forecastDataModel);
    }

    @Test
    public void testSetText() throws Exception {
        currentSummaryTextView = (TextView) activity.findViewById(R.id.textView_current_summary_value);
        currentTempratureTextView = (TextView) activity.findViewById(R.id.textView_current_temprature_value);
        currentFeelsTempratureTextView = (TextView) activity.findViewById(R.id.textView_current_tempraturefeels_value);
        currentHumidityTextView = (TextView) activity.findViewById(R.id.textView_current_humidity_value);

        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                currentSummaryTextView.setText(weatherForecast.getCurrentForecast().getSummary());
                currentTempratureTextView.setText(weatherForecast.getCurrentForecast().getTemperature() + "\u00B0 F");
                currentFeelsTempratureTextView.setText(weatherForecast.getCurrentForecast().getApparentTemperature() + "\u00B0 F");
                currentHumidityTextView.setText(weatherForecast.getCurrentForecast().getHumidity() + "Humid");
            }
        });

        getInstrumentation().waitForIdleSync();
        assertNotNull("Summary should not be null", currentSummaryTextView);
        assertNotNull("Temprature should not be null", currentTempratureTextView);
        assertNotNull("Apparent Temprature should not be null", currentFeelsTempratureTextView);
        assertNotNull("Humidity should not be null", currentHumidityTextView);

    }

}
