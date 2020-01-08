package com.android.example.loginactivity.ForgetPassword;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.android.example.loginactivity.Data.Entity.User;

public class ForgetPasswordViewModel extends AndroidViewModel {

        private ForgetPasswordRepository forgetPasswordRepository;

        public ForgetPasswordViewModel(@NonNull Application application){
            super(application);
            forgetPasswordRepository = new ForgetPasswordRepository(application);
        }

        User findUser(String id) { return forgetPasswordRepository.findUser(id); }
}
