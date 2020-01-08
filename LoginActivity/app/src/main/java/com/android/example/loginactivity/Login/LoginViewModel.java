package com.android.example.loginactivity.Login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.android.example.loginactivity.Data.Entity.User;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private LoginRepository loginRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }

    LiveData<List<User>> getAllUsers() {
        return loginRepository.getAllUsers();
    }

    User findUser(String id) { return loginRepository.findUser(id); }
}
