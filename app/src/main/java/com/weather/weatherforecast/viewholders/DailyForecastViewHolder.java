package com.weather.weatherforecast.viewholders;

import android.view.View;
import android.widget.TextView;

import com.weather.weatherforecast.R;

/**
 * Created by Pawan on 26-11-2016.
 */

public class DailyForecastViewHolder {

    public TextView dailySummaryTextView, dailyHumidityTextView, dailyTempratureTextView;

    public DailyForecastViewHolder(View view) {
        dailySummaryTextView = (TextView) view.findViewById(R.id.listItem_textView_daily_summary_value);
        dailyHumidityTextView= (TextView) view.findViewById(R.id.listItem_textView_daily_humidity_value);
        dailyTempratureTextView= (TextView) view.findViewById(R.id.listItem_textView_daily_temprature_value);
    }

}
