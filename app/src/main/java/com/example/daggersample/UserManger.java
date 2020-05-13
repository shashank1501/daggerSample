package com.example.daggersample;

import com.example.daggersample.database.UserDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserManger {

    private UserDao dao;
    UserComponent.Factory userComponentFactory;
    UserComponent userComponent;

    @Inject
    UserManger(UserDao dao,UserComponent.Factory userComponentFactory){
        this.dao=dao;
        this.userComponentFactory=userComponentFactory;
    }


    String userName(){
        return dao.getUser().getUserName();
    }

boolean isUserLoggedIn(){

        return userComponent!=null;
}

boolean isUserRegisterd(){
        if ( dao.getUser()==null){
            return false;
       }
return true ;
}

public void registerUser(String name,String password){
        dao.delete();
dao.insert(new User(name,password));
userJustLoggdIn();
}

public boolean loginUser(String username,String password){
    String registredName=dao.getUser().userName;
if (!username.equals(registredName))return false;
 String registerdPassword=dao.getUser().getPassword();
 if (!password.equals(registerdPassword)) return false;
userJustLoggdIn();
 return true;
}

 public void unregister(){
  dao.delete();
  logout();
}

public void  logout(){
userComponent=null;
}


void userJustLoggdIn(){
userComponent=userComponentFactory.create();
}

}
