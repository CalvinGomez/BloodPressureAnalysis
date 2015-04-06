package com.newboston.bluetoothtesting;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Dashboard extends ActionBarActivity
{
    SharedPreferences prefs;
    List<String> data1;
    Set<String> set1;
    TextView tv;
    List<Integer> sysValues;
    List<Integer> diValues;
    List<Integer> prValues;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tv = (TextView) findViewById(R.id.dashboardText);

        prefs = getSharedPreferences("bpData", Context.MODE_PRIVATE);
        set1 = prefs.getStringSet("myKey", null);
        data1 = new ArrayList<String>(set1);

        String dataSet = "";
        String dashboardPrint = "";
        int l = data1.size();

        sysValues = new ArrayList<>();
        diValues = new ArrayList<>();
        prValues = new ArrayList<>();


        for(int i=0;i<l;i++)
        {
            if(data1.get(i).length()==13)
            {
                dataSet = data1.get(i).substring(1, 3);
            }
            if(data1.get(i).length()==14)
            {
                dataSet = data1.get(i).substring(1, 4);
            }
              sysValues.add(Integer.parseInt(dataSet));

            if(data1.get(i).length()==13)
            {
                dataSet = data1.get(i).substring(5, 7);
            }
            if(data1.get(i).length()==14)
            {
                dataSet = data1.get(i).substring(6, 8);
            }
              diValues.add(Integer.parseInt(dataSet));

            if(data1.get(i).length()==13)
            {
                dataSet = data1.get(i).substring(9, 11);
            }
            if(data1.get(i).length()==14)
            {
                dataSet = data1.get(i).substring(10, 12);
            }
              prValues.add(Integer.parseInt(dataSet));

            dashboardPrint = dashboardPrint + sysValues.get(i) + " , " + diValues.get(i) + " , " + prValues.get(i) + "\n";
        }

        tv.setText(dashboardPrint);
    }

}
