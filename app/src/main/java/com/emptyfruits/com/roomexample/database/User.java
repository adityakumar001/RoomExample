package com.emptyfruits.com.roomexample.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    private int _id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "phone")
    private String phone;

    @NonNull
    @Override
    public String toString() {
        return "User(name = " + name + ", phone = " + phone + ")";
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Ignore
    public User(int _id, String name, String phone) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
    }
}