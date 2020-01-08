package com.android.example.loginactivity.EditUserProfile;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.android.example.loginactivity.Data.DAO.UserDAO;
import com.android.example.loginactivity.Data.Database.FunAllTimeDatabase;
import com.android.example.loginactivity.Data.Entity.User;

import java.util.List;

public class EditUserProfileRepository {
    private LiveData<List<User>> allUsers;
    private UserDAO userDao;

    EditUserProfileRepository(Context context){
        FunAllTimeDatabase funAllTimeDatabase = FunAllTimeDatabase.getDatabase(context.getApplicationContext());
        userDao = funAllTimeDatabase.getUserDao();
        allUsers = userDao.getAllUsers();
    }
}
