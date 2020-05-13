package com.example.daggersample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.daggersample.Login.LoginActivity;
import com.example.daggersample.register.RegisterActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    Button logout;
    @Inject
    MainViewModel mainViewModel;
    TextView useNameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    UserManger userManger=((MainApplication) getApplication()).component().getUserManger();
        setContentView(R.layout.activity_main);
        logout=findViewById(R.id.logout_btn);
        useNameTv=findViewById(R.id.userTv);


      if (!userManger.isUserLoggedIn()){
        if (!userManger.isUserRegisterd()){
            Intent intent =new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }else {
        startActivity(new Intent(this, LoginActivity.class));
        }
      }else {
          userManger.userComponent.inject(this);
          useNameTv.setText("Hello "+userManger.userName()+" !");
      }

      logout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mainViewModel.logout();
Intent intent=new Intent(MainActivity.this,LoginActivity.class);
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
startActivity(intent);
          }
      });

    }
}
