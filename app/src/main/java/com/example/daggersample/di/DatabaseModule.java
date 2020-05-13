package com.example.daggersample.di;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.daggersample.database.UserDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule  {

    @Singleton
    @Provides
    UserDatabase provideDatabase(Context context){
       return Room.databaseBuilder(context,UserDatabase.class,"mydb").allowMainThreadQueries().build();
    }

}
