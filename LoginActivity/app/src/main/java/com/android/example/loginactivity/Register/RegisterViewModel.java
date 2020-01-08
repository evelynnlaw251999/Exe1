package com.android.example.loginactivity.Register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.example.loginactivity.Data.Entity.User;

public class RegisterViewModel extends AndroidViewModel {

     private RegisterRepository registerRepository;

    public RegisterViewModel(@NonNull Application application){
        super(application);
        registerRepository = new RegisterRepository(application);
    }
    void insertUser(User user) {
        registerRepository.insertUser(user);
    }
}
