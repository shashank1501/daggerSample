package com.example.daggersample.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggersample.MainActivity;
import com.example.daggersample.MainApplication;
import com.example.daggersample.R;
import com.example.daggersample.register.RegisterActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginViewModel loginViewModel;
    TextView loginName,loginPass;
    Button loginBtn,unregBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MainApplication)getApplication()).component().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginName=findViewById(R.id.login_name);
        loginPass=findViewById(R.id.login_pass);
        loginBtn=findViewById(R.id.login_btn);
        unregBtn=findViewById(R.id.unregisterBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=loginName.getText().toString();
                String pass=loginPass.getText().toString();
                if (loginViewModel.login(name,pass)){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Please try again...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        unregBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.unregister();
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
