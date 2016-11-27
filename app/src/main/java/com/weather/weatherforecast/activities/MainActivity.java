package com.weather.weatherforecast.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.weather.weatherforecast.R;
import com.weather.weatherforecast.adapters.DailyForecastListAdapter;
import com.weather.weatherforecast.models.WeatherForecastModel;
import com.weather.weatherforecast.services.ForecastControllerService;
import com.weather.weatherforecast.util.CommonUtilities;
import com.weather.weatherforecast.util.GPSUtility;

public class MainActivity extends AppCompatActivity {

    TextView currentSummaryTextView, currentTempratureTextView,  currentFeelsTempratureTextView, currentHumidityTextView;
    ListView dailyForecastListView;
    DailyForecastListAdapter dailyForecastListAdapter;
    ForecastControllerService forecastControllerService;

    private String locationPermissions[] = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getClass().getName(), "onCreate");
        setContentView(R.layout.activity_main);
        initUIViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getClass().getName(), "onStart");
        if(CommonUtilities.isOnline(MainActivity.this)) {
            requestLocationPermissions();
        } else {
            showOfflineAlert("No Connection available.. Please try again when connected!");
        }
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

    public void requestLocationPermissions(){
        Log.d(getClass().getName(), "requestLocationPermissions");
        if (Build.VERSION.SDK_INT >= 23) {
            if( MainActivity.this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    MainActivity.this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    ) {
                requestPermissions( locationPermissions, 100);
            } else {
                getLatLongAndStartForecastControllerService();
            }
        } else {
            getLatLongAndStartForecastControllerService();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(getClass().getName(), "onRequestPermissionsResult");
        for(int i = 0; i < permissions.length; i++) {
            Log.d("Request Permission ", permissions[i]);
            Log.d("Permission Results", ""+grantResults[i]);
        }
        if (grantResults.length >= 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.d("PermissionsResult","Permission Granted");
            getLatLongAndStartForecastControllerService();
        } else if(grantResults.length >= 1 && grantResults[0] == PackageManager.PERMISSION_DENIED){
            Log.d("PermissionsResult","Permission Denied");
            Toast.makeText(MainActivity.this, "Location Permission Denied!", Toast.LENGTH_LONG).show();
        }
    }

    private void getLatLongAndStartForecastControllerService(){
        Log.d(getClass().getName(), "getLatLongAndStartForecastControllerService");
        GPSUtility gpsUtility = new GPSUtility(MainActivity.this);
        if(gpsUtility.canGetLocation()){
            String latlongString = gpsUtility.getLatitude() + "," + gpsUtility.getLongitude();
            Log.d(getClass().getName(), latlongString);
            forecastControllerService = new ForecastControllerService(this, latlongString);
        } else{
            gpsUtility.showSettingsAlert();
        }
    }

    public void showOfflineAlert(String message){
        final AlertDialog alertDialog = new AlertDialog.Builder(
                MainActivity.this).create();
        alertDialog.setTitle("Error!");
        alertDialog.setMessage(message);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                finish();
            }
        });
        alertDialog.show();
    }

}
