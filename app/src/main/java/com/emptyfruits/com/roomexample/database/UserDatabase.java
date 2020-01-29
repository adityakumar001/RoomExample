package com.emptyfruits.com.roomexample.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public static UserDatabase getUserDatabase(Context context) {
        return Room.databaseBuilder(context, UserDatabase.class, "userdb")
                .allowMainThreadQueries().build();
    }

    public abstract UserDao getUserDao();
}
