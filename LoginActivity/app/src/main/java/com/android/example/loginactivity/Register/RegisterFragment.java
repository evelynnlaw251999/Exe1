package com.android.example.loginactivity.Register;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.example.loginactivity.Data.Entity.User;
import com.android.example.loginactivity.Login.LoginFragment;
import com.android.example.loginactivity.R;

public class RegisterFragment extends Fragment implements View.OnClickListener {


    RegisterViewModel registerViewModel;
    EditText aFirstName;
    EditText aLastName;
    EditText aEmail;
    EditText aTextUsername;
    EditText aTextPassword;
    Button aButtonRegister;
    TextView aLoginNow;
    CheckBox showPassword;


    public RegisterFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register, container, false);


        aFirstName = view.findViewById(R.id.edittext_firstname);
        aLastName = view.findViewById(R.id.edittext_lastname);
        aEmail = view.findViewById(R.id.edittext_email);
        aTextUsername = view.findViewById(R.id.edittext_username);
        aTextPassword = view.findViewById(R.id.edittext_password);


        aButtonRegister = view.findViewById(R.id.button_register);

        aLoginNow = view.findViewById(R.id.login_now);
        aLoginNow.setOnClickListener(this);

               // LoginFragment loginFragment = new LoginFragment();
                //getFragmentManager().beginTransaction().replace(getId(), loginFragment).commit();




        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);

       // loginViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
         // @Override
         // public void onChanged(List<User> users) {
          //      StringBuilder text = new StringBuilder();
          //     for(int i = 0; i < users.size(); i++) {
          //          User user = users.get(i);
          //      }
           // }

       aButtonRegister.setOnClickListener(this);
        return view;
    }
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button_register:
                User user = new User(aTextUsername.getText().toString(), aTextPassword.getText().toString(),
                        aFirstName.getText().toString(), aLastName.getText().toString(), aEmail.getText().toString());
                registerViewModel.insertUser(user);
                Toast.makeText(getActivity(), "Register successfully", Toast.LENGTH_LONG).show();
                LoginFragment loginFragment2 = new LoginFragment();
                getFragmentManager().beginTransaction().replace(getId(), loginFragment2).commit();
                break;
            case R.id.login_now:
                LoginFragment loginFragment = new LoginFragment();
                getFragmentManager().beginTransaction().replace(getId(), loginFragment).commit();
                break;

        }
    }


    }