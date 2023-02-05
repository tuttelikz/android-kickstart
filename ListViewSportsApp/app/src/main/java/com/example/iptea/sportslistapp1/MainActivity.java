package com.example.iptea.sportslistapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    String[] sportNames = {"archery","skating","volleyball","diving","gymnastics","waterpolo","skiing","boxing","baseball","batminton","tabletennis","surfing","canoe","swimming",
            "basketball","cycling"};

    int[] sportIcons = {R.drawable.archery,
            R.drawable.skating,
            R.drawable.volleyball,
            R.drawable.diving,
            R.drawable.gymnastics,
            R.drawable.waterpolo,
            R.drawable.skiing,
            R.drawable.boxing,
            R.drawable.baseball,
            R.drawable.batminton,
            R.drawable.tabletennis,
            R.drawable.surfing,
            R.drawable.canoe,
            R.drawable.swimming,
            R.drawable.basketball,
            R.drawable.cycling};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.listview);

        Adapter adapter = new Adapter(MainActivity.this,sportNames,sportIcons);

        listview.setAdapter(adapter);
    }
}
