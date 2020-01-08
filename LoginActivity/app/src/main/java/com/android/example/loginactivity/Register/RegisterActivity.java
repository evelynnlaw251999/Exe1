package com.android.example.loginactivity.Register;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.example.loginactivity.R;


public class RegisterActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterFragment fragment = new RegisterFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.secondLayout,fragment).commit();



    }

}
