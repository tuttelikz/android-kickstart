package com.example.iptea.realmdbtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by iptea on 11/23/2017.
 */

public class DisplayData extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayview);

        TextView _display = (TextView)findViewById(R.id.mainDisplayLayout);

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Person> result = realm.where(Person.class).findAll();

        for (int i = 0; i<result.size(); i++) {
            _display.append(result.get(i).getName() + " : " + result.get(i).getEmail());
        }

    }
}
