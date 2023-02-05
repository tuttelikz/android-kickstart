package com.example.iptea.realmdbtest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button insertbt;
    Button viewbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        insertbt = (Button)findViewById(R.id.bt_insert);
        viewbt = (Button)findViewById(R.id.bt_view);



/*        insertbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertData.class);
                startActivity(intent);
            }
        });

        viewbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, DisplayData.class);
                startActivity(intent2);
            }
        });*/

    }

    public void insertPage(View v) {

        Intent intent = new Intent(MainActivity.this, InsertData.class);
        startActivity(intent);
    }

    public void viewPage(View v) {

        Intent intent2 = new Intent(MainActivity.this, DisplayData.class);
        startActivity(intent2);
    }

/*        Intent initi = new Intent(MainActivity.this, ResultActivity.class);

        startActivity(initi);*/

}
