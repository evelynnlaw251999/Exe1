package com.android.example.loginactivity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.example.loginactivity.Login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.firstLayout,fragment).commit();
    }
}
