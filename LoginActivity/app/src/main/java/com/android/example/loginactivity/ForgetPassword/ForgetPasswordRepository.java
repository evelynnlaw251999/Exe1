package com.android.example.loginactivity.ForgetPassword;

import android.content.Context;

import com.android.example.loginactivity.Data.DAO.UserDAO;
import com.android.example.loginactivity.Data.Database.FunAllTimeDatabase;
import com.android.example.loginactivity.Data.Entity.User;

public class ForgetPasswordRepository {

    private UserDAO userDAO;

    ForgetPasswordRepository(Context context) {
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDAO = funAllTimeDatabase.getUserDao();
    }

    User findUser(String id){ return userDAO.findUser(id); }
}
