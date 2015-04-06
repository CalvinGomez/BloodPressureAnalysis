package com.newboston.bluetoothtesting;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class DashboardHome extends ActionBarActivity
{
    public static final String Type = "type";
    public static final String Chart = "chart";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_home);
    }

    public void viewLineChart(View view)
    {
        Intent i = new Intent(this, LineChartActivity.class);
        i.putExtra(Type, "sys");
        i.putExtra(Chart,"line");
        startActivity(i);
    }

    public void viewPointChart(View view)
    {
        Intent i = new Intent(this, LineChartActivity.class);
        i.putExtra(Type, "sys");
        i.putExtra(Chart,"point");
        startActivity(i);
    }

    public void viewBarChart(View view)
    {
        Intent i = new Intent(this, LineChartActivity.class);
        i.putExtra(Type, "sys");
        i.putExtra(Chart,"bar");
        startActivity(i);
    }

}
