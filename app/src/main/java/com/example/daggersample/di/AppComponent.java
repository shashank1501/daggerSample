package com.example.daggersample.di;

import android.content.Context;

import androidx.room.Database;

import com.example.daggersample.Login.LoginActivity;
import com.example.daggersample.MainActivity;
import com.example.daggersample.UserManger;
import com.example.daggersample.register.RegisterActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules ={DatabaseModule.class,UserModule.class,AppSubCompoennts.class})
public interface AppComponent {

    @Component.Factory
    interface Factory{
        AppComponent create(@BindsInstance Context context);
    }

    UserManger getUserManger();
    void inject(RegisterActivity activity);
    void inject(LoginActivity activity);

}
