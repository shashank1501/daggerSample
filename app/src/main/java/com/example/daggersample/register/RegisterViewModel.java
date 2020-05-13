package com.example.daggersample.register;

import com.example.daggersample.UserManger;

import javax.inject.Inject;

public class RegisterViewModel {

    private UserManger userManger;

    @Inject
    public RegisterViewModel(UserManger userManger) {
        this.userManger = userManger;
    }


 public void registerUser(String name,String password){
        userManger.registerUser(name,password);
}
}
