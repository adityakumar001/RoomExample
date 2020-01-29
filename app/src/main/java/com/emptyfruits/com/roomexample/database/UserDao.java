package com.emptyfruits.com.roomexample.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER")
    LiveData<List<User>> getUsers();

    @Insert
    void saveUser(User user);

    @Query("DELETE FROM USER WHERE _ID > 0")
    int clearRecords();
}
