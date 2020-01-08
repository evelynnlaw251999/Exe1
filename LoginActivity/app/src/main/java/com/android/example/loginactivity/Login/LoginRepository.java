package com.android.example.loginactivity.Login;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.android.example.loginactivity.Data.DAO.UserDAO;
import com.android.example.loginactivity.Data.Database.FunAllTimeDatabase;
import com.android.example.loginactivity.Data.Entity.User;


import java.util.List;

public class LoginRepository {
    private LiveData<List<User>> allUsers;
    private UserDAO userDao;


    LoginRepository(Context context) {
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDao = funAllTimeDatabase.getUserDao();
        allUsers = userDao.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    User findUser(String id){ return userDao.findUser(id); }


    static class FindUserAsyncTask extends AsyncTask<String, Void, Void> {
        private UserDAO userDao;

        FindUserAsyncTask(UserDAO userDao){this.userDao = userDao;}

        @Override
        protected Void doInBackground(String... strings) {
            userDao.findUser(strings[0]);
            return null;
        }
    }


}
