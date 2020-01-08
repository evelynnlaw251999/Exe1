package com.android.example.loginactivity.ForgetPassword;

import android.content.Context;
import android.os.AsyncTask;

import com.android.example.loginactivity.Data.DAO.UserDAO;
import com.android.example.loginactivity.Data.Database.FunAllTimeDatabase;
import com.android.example.loginactivity.Data.Entity.User;

public class ForgetPasswordDetailsRepository {

    private UserDAO userDAO;

    ForgetPasswordDetailsRepository(Context context) {
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDAO = funAllTimeDatabase.getUserDao();
    }

    void updateUser(User user) {
        new updateUserAsyncTask(userDAO).execute(user);
    }

    User findUser(String id){ return userDAO.findUser(id); }

    static class updateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        updateUserAsyncTask(UserDAO userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.updateUser(users[0]);
            return null;
        }
    }
}
