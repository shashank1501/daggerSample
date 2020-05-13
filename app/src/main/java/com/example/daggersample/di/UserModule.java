package com.example.daggersample.di;

import com.example.daggersample.database.UserDao;
import com.example.daggersample.database.UserDatabase;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public  class UserModule {

    @Singleton
    @Provides
     UserDao provideUser(UserDatabase database){
      return database.userDao();
    }

}
