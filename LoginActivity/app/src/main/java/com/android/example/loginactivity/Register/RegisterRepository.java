package com.android.example.loginactivity.Register;

import android.content.Context;
import android.os.AsyncTask;

import com.android.example.loginactivity.Data.DAO.UserDAO;
import com.android.example.loginactivity.Data.Database.FunAllTimeDatabase;
import com.android.example.loginactivity.Data.Entity.User;

public class RegisterRepository {
    private UserDAO userDAO;

    RegisterRepository(Context context){
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDAO = funAllTimeDatabase.getUserDao();

    }
    void insertUser(User user) {
        new InsertAsyncTask(userDAO).execute(user);
    }

    static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        InsertAsyncTask(UserDAO userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insertUser(users[0]);
            return null;
        }
    }
}
