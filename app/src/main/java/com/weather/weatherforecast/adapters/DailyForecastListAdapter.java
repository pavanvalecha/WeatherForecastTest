package com.weather.weatherforecast.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.weather.weatherforecast.R;
import com.weather.weatherforecast.models.ForecastDailyDataModel;
import com.weather.weatherforecast.viewholders.DailyForecastViewHolder;

import java.util.ArrayList;

/**
 * Created by Pawan on 26-11-2016.
 */

public class DailyForecastListAdapter extends BaseAdapter {

    ArrayList<ForecastDailyDataModel> forecastDataModelArrayList;
    Context context;

    public DailyForecastListAdapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return forecastDataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return forecastDataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.daily_forecast_list_item, null, false);

        DailyForecastViewHolder dailyForecastViewHolder = new DailyForecastViewHolder(view);
        ForecastDailyDataModel forecastDailyData = forecastDataModelArrayList.get(position);
        dailyForecastViewHolder.dailyHumidityTextView.setText(forecastDailyData.getHumidity() + " Humidity");
        dailyForecastViewHolder.dailyTempratureTextView.setText(forecastDailyData.getTemperatureMin() + "\u00B0 F");
        dailyForecastViewHolder.dailySummaryTextView.setText(forecastDailyData.getSummary());
        return view;
    }

    public void setForecastDataModelArrayList(ArrayList<ForecastDailyDataModel> forecastDataModelArrayList) {
        this.forecastDataModelArrayList = forecastDataModelArrayList;
    }



}
