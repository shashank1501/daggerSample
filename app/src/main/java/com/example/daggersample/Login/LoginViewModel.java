package com.example.daggersample.Login;

import com.example.daggersample.UserManger;

import javax.inject.Inject;

public class LoginViewModel {
    UserManger userManger;

    @Inject
    LoginViewModel(UserManger userManger){
        this.userManger=userManger;
    }

  boolean login(String name,String password){
if (userManger.loginUser(name, password)){
return true;
}else {
    return false;
}
  }

  void unregister(){
userManger.unregister();
  }

}
