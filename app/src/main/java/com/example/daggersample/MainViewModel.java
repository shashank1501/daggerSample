package com.example.daggersample;

import com.example.daggersample.UserManger;

import javax.inject.Inject;

public class MainViewModel {

    private UserManger userManger;
    @Inject
    MainViewModel(UserManger userManger){
        this.userManger=userManger;
    }

    String getUserName(){
       return userManger.userName();
    }

   void logout(){
        userManger.logout();
    }


}
