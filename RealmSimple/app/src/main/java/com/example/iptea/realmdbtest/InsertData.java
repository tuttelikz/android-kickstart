package com.example.iptea.realmdbtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import io.realm.Realm;

/**
 * Created by iptea on 11/23/2017.
 */

public class InsertData extends AppCompatActivity {

    EditText _Name, _Email;
    Realm realm;
    Button insertButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertview);


        insertButton = (Button)findViewById(R.id.bt_insert);
        _Name = (EditText)findViewById(R.id.et_name);
        _Email = (EditText)findViewById(R.id.et_email);

        Realm.init(this);
        realm = Realm.getDefaultInstance();




/*        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                //DB Operation

                Person obj = realm.createObject(Person.class);
                obj.setId(new Date().toString());
                obj.setName(_Name.getText().toString());
                obj.setEmail(_Email.getText().toString());

                realm.commitTransaction();
            }
        });*/


    }

    public void insertStaff(View v) {

        realm.beginTransaction();
        //DB Operation

        Person obj = realm.createObject(Person.class);
        obj.setId(new Date().toString());
        obj.setName(_Name.getText().toString());
        obj.setEmail(_Email.getText().toString());

        realm.commitTransaction();
    }

}
