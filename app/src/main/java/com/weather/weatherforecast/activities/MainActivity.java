package com.weather.weatherforecast.activities;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.weather.weatherforecast.R;
import com.weather.weatherforecast.adapters.DailyForecastListAdapter;
import com.weather.weatherforecast.models.WeatherForecastModel;
import com.weather.weatherforecast.services.ForecastControllerService;

public class MainActivity extends AppCompatActivity {

    TextView currentSummaryTextView, currentTempratureTextView,  currentFeelsTempratureTextView, currentHumidityTextView;
    ListView dailyForecastListView;
    DailyForecastListAdapter dailyForecastListAdapter;
    ForecastControllerService forecastControllerService;
    private static final long MIN_TIME_BW_UPDATES = 1;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getClass().getName(), "onCreate");
        setContentView(R.layout.activity_main);
        initUIViews();
        forecastControllerService = new ForecastControllerService(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getClass().getName(), "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getClass().getName(), "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getClass().getName(), "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getClass().getName(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getClass().getName(), "onDestroy");
    }

    private void initUIViews(){
        Log.d(getClass().getName(), "initUIViews");
        currentSummaryTextView = (TextView)findViewById(R.id.textView_current_summary_value);
        currentTempratureTextView = (TextView)findViewById(R.id.textView_current_temprature_value);
        currentFeelsTempratureTextView = (TextView)findViewById(R.id.textView_current_tempraturefeels_value);
        currentHumidityTextView = (TextView)findViewById(R.id.textView_current_humidity_value);
        dailyForecastListAdapter = new DailyForecastListAdapter(this);
        dailyForecastListView = (ListView)findViewById(R.id.listView_daily);

    }

    public void setDataOnUI(WeatherForecastModel weatherForecast){
        Log.d(getClass().getName(), "setDataOnUI");
        currentSummaryTextView.setText( weatherForecast.getCurrentForecast().getSummary() );
        currentTempratureTextView.setText( weatherForecast.getCurrentForecast().getTemperature() + "\u00B0 F" );
        currentFeelsTempratureTextView.setText( weatherForecast.getCurrentForecast().getApparentTemperature() + "\u00B0 F" );
        currentHumidityTextView.setText( weatherForecast.getCurrentForecast().getHumidity() + "" );
        dailyForecastListAdapter.setForecastDataModelArrayList( weatherForecast.getDailyForecast().getForecastDataModelArrayList() );
        dailyForecastListView.setAdapter(dailyForecastListAdapter);
        dailyForecastListAdapter.notifyDataSetChanged();
    }

    public void getLocationValues(){
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES,
                MIN_DISTANCE_CHANGE_FOR_UPDATES, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                });
    }

}
