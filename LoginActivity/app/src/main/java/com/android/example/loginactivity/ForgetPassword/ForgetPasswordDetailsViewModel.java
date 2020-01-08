package com.android.example.loginactivity.ForgetPassword;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.example.loginactivity.Data.Entity.User;

public class ForgetPasswordDetailsViewModel extends AndroidViewModel {

    private ForgetPasswordDetailsRepository forgetPasswordDetailsRepository;

    public ForgetPasswordDetailsViewModel(@NonNull Application application){
        super(application);
        forgetPasswordDetailsRepository = new ForgetPasswordDetailsRepository(application);
    }

    void updateUser(User user) {
        forgetPasswordDetailsRepository.updateUser(user);
    }

    User findUser(String id) { return forgetPasswordDetailsRepository.findUser(id); }
}
