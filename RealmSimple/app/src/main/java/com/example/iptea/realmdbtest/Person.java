package com.example.iptea.realmdbtest;

import io.realm.RealmObject;

/**
 * Created by iptea on 11/23/2017.
 */

public class Person extends RealmObject {

    String id;
    String Name;
    String Email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
