package com.example.daggersample.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.daggersample.User;

@Database(entities = User.class,version = 1)
public abstract class UserDatabase extends RoomDatabase {
   public abstract UserDao userDao();
}
