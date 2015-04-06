package com.newboston.bluetoothtesting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.Random;


public class LineChartActivity extends ActionBarActivity
{
    SharedPreferences prefs;
    List<String> data1;
    Set<String> set1;

    public static final String Type = "type";
    public static final String Chart = "chart";
    String intentType;
    String intentChart;

    Random mRand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        Intent i = getIntent();
        intentType = i.getStringExtra(DashboardHome.Type);
        intentChart = i.getStringExtra(DashboardHome.Chart);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        if(intentType != null)
        {
            if (intentType.equals("sys"))
            {
                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setMinY(80);
                graph.getViewport().setMaxY(140);
            }
            else if (intentType.equals("dia"))
            {
                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setMinY(40);
                graph.getViewport().setMaxY(100);
            }
            else if (intentType.equals("pulse"))
            {
                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setMinY(60);
                graph.getViewport().setMaxY(120);
            }
        }

        if(intentChart != null)
        {
            if (intentChart.equals("line"))
            {
                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(generateTrueData(intentType));
                graph.addSeries(series);
                series.setColor(Color.RED);
                series.setDrawDataPoints(true);
                series.setDataPointsRadius(5);
                series.setThickness(2);
            }
            else if (intentChart.equals("point"))
            {
                PointsGraphSeries<DataPoint> series = new PointsGraphSeries<DataPoint>(generateTrueData(intentType));
                graph.addSeries(series);
                series.setShape(PointsGraphSeries.Shape.TRIANGLE);
                series.setSize(10f);
                series.setColor(Color.RED);
            }
            else if (intentChart.equals("bar"))
            {
                BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(generateTrueData(intentType));
                graph.addSeries(series);
                series.setSpacing(30);
                series.setDrawValuesOnTop(true);
                series.setValuesOnTopColor(Color.RED);
                series.setValuesOnTopSize(16);
            }
        }
    }

    private DataPoint[] generateTrueData(String t)
    {
        double sys,di,pr;
        String dataSet = "";

        prefs = getSharedPreferences("bpData", Context.MODE_PRIVATE);
        set1 = prefs.getStringSet("myKey", null);
        data1 = new ArrayList<String>(set1);

        int count = data1.size();
        DataPoint[] values = new DataPoint[count];
        for (int i=0; i<count; i++)
        {
            if(data1.get(i).length()==13)
            {
                dataSet = data1.get(i).substring(1, 3);
            }
            if(data1.get(i).length()==14)
            {
                dataSet = data1.get(i).substring(1, 4);
            }
            sys = Double.parseDouble(dataSet);

            if(data1.get(i).length()==13)
            {
                dataSet = data1.get(i).substring(5, 7);
            }
            if(data1.get(i).length()==14)
            {
                dataSet = data1.get(i).substring(6, 8);
            }
            di = Double.parseDouble(dataSet);

            if(data1.get(i).length()==13)
            {
                dataSet = data1.get(i).substring(9, 11);
            }
            if(data1.get(i).length()==14)
            {
                dataSet = data1.get(i).substring(10, 12);
            }
            pr = Double.parseDouble(dataSet);

            double x = i;
            double y = 0;
            if(t.equals("sys")==true)
            {
                y = sys;
            }
            if(t.equals("dia")==true)
            {
                y = di;
            }
            if(t.equals("pulse")==true)
            {
                y = pr;
            }
            DataPoint v = new DataPoint(x, y);
            values[i] = v;
        }
        return values;
    }

    public void viewSystolic(View view)
    {
        Intent intent = new Intent(this, LineChartActivity.class);
        intent.putExtra(Type , "sys");
        if(intentChart.equals("line"))
        {
            intent.putExtra(Chart, "line");
        }
        else if(intentChart.equals("point"))
        {
            intent.putExtra(Chart, "point");
        }
        else if(intentChart.equals("bar"))
        {
            intent.putExtra(Chart, "bar");
        }
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
        finish();
    }

    public void viewDiastolic(View view)
    {
        Intent intent = new Intent(this, LineChartActivity.class);
        intent.putExtra(Type , "dia");
        if(intentChart.equals("line"))
        {
            intent.putExtra(Chart, "line");
        }
        else if(intentChart.equals("point"))
        {
            intent.putExtra(Chart, "point");
        }
        else if(intentChart.equals("bar"))
        {
            intent.putExtra(Chart, "bar");
        }
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
        finish();
    }

    public void viewPulse(View view)
    {
        Intent intent = new Intent(this, LineChartActivity.class);
        intent.putExtra(Type , "pulse");
        if(intentChart.equals("line"))
        {
            intent.putExtra(Chart, "line");
        }
        else if(intentChart.equals("point"))
        {
            intent.putExtra(Chart, "point");
        }
        else if(intentChart.equals("bar"))
        {
            intent.putExtra(Chart, "bar");
        }
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
        finish();
    }


}
