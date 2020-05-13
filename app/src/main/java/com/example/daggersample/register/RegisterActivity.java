package com.example.daggersample.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggersample.MainActivity;
import com.example.daggersample.MainApplication;
import com.example.daggersample.R;

import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity {

    @Inject
    RegisterViewModel registerViewModel;
    TextView userName,password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ((MainApplication)getApplication()).component().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName=findViewById(R.id.register_name);
        password=findViewById(R.id.register_pass);
        button=findViewById(R.id.register_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=userName.getText().toString();
                String pass=password.getText().toString();
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pass)){
                    Toast.makeText(RegisterActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }else {
                    registerViewModel.registerUser(name,pass);
                    Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
