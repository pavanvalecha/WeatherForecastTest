package com.weather.weatherforecast.util;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by Pawan on 13/07/2016.
 */
public class GPSUtility extends Service implements LocationListener {

    private final Context mContext;

    // flag for GPS status
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    // flag for GPS status
    boolean canGetLocation = false;

    Location location; // location
    double latitude; // latitude
    double longitude; // longitude

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;

    public GPSUtility(Context context) {
        Log.d(getClass().getName(), "GPSUtility");
        this.mContext = context;
        getLocation();
    }

    public Location getLocation() {
        Log.d(getClass().getName(), "getLocation");
        try {
            locationManager = (LocationManager) mContext
                    .getSystemService(LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
                    try {
                        //((StartConfigureActivity) mContext).requestLocationPermissions();
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("Network", "Network");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }catch (SecurityException ex){
                        ex.printStackTrace();
                        //Toast.makeText(mContext, "Location permission denied!", Toast.LENGTH_LONG);
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        try{
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                        }catch (SecurityException ex){
                            ex.printStackTrace();
                            //Toast.makeText(mContext, "Location permission denied!", Toast.LENGTH_LONG);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }

    /**
     * Stop using GPS listener
     * Calling this function will stop using GPS in your app
     * */
    public void stopUsingGPS() {
        Log.d(getClass().getName(), "stopUsingGPS");
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            locationManager.removeUpdates(GPSUtility.this);
            }
        }

        /**
         * Function to get latitude
         * */
        public double getLatitude(){
            Log.d(getClass().getName(), "getLatitude");
            if(location != null){
                latitude = location.getLatitude();
            }
            return latitude;
        }

        /**
         * Function to get longitude
         * */
        public double getLongitude(){
            Log.d(getClass().getName(), "getLongitude");
            if(location != null){
                longitude = location.getLongitude();
            }
            return longitude;
        }

        /**
         * Function to check GPS/wifi enabled
         * @return boolean
         * */
        public boolean canGetLocation() {
            Log.d(getClass().getName(), "canGetLocation");
            return this.canGetLocation;
        }

        /**
         * Function to show settings alert dialog
         * On pressing Settings button will lauch Settings Options
         * */
        public void showSettingsAlert(){
            Log.d(getClass().getName(), "showSettingsAlert");
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

            // Setting Dialog Title
            alertDialog.setTitle("GPS is settings");

            // Setting Dialog Message
            alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

            // On pressing Settings button
            alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    mContext.startActivity(intent);
                    dialog.cancel();
                }
            });

            // on pressing cancel button
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

        public void enableGPS(){
            Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(i);
        }

        @Override
        public void onLocationChanged(Location location) {
            Log.d(getClass().getName(), "onLocationChanged");
            Log.d("GPSUtility Latitude", ""+location.getLatitude());
            Log.d("GPSUtility Longitude", ""+location.getLongitude());
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.d(getClass().getName(), "onProviderDisabled");
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.d(getClass().getName(), "onProviderEnabled");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d(getClass().getName(), "onStatusChanged");
        }

        @Override
        public IBinder onBind(Intent arg0) {
            Log.d(getClass().getName(), "onBind");
            return null;
        }

        /*private String latLonStringConvertor(double latlong){
            String temp = latlong+"";
            if(temp.contains(".")) {
                String[] temparr = temp.split("\\.");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(temparr[0]+".");
                if(temparr[1].length() > 2){
                    stringBuffer.append(temparr[1].substring(0, 2));
                }
                return stringBuffer.toString();
            } else {
                return "";
            }
        }*/

    }

