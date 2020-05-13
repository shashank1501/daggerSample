package com.example.daggersample.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.daggersample.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM USERTABLE")
    User getUser();

    @Query("DELETE FROM USERTABLE")
    void delete();


}
