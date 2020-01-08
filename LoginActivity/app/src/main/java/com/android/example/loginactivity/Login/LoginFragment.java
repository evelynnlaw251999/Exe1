package com.android.example.loginactivity.Login;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.example.loginactivity.EditUserProfile.EditUserProfileFragment;
import com.android.example.loginactivity.ForgetPassword.ForgotPasswordFragment;
import com.android.example.loginactivity.R;
import com.android.example.loginactivity.Register.RegisterFragment;


public class LoginFragment extends Fragment implements android.widget.CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    LoginViewModel loginViewModel;
    EditText aTextUsername;
    EditText aTextPassword;
    Button aButtonLogin;
    TextView aTextViewSignUp;
    CheckBox showpassword;
    TextView aForgotPassword;


    public LoginFragment() {

    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_login, container, false);

        aTextUsername = view.findViewById(R.id.edittext_username);
        aTextPassword = view.findViewById(R.id.edittext_password);
        aButtonLogin = view.findViewById(R.id.button_login);
        aForgotPassword = view.findViewById(R.id.textview_forgot_password);


        aTextViewSignUp = view.findViewById(R.id.textview_sign_up);
        aTextViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment registerFragment = new RegisterFragment();
                getFragmentManager().beginTransaction().addToBackStack(null).replace(getId(), registerFragment).commit();

            }
        });


        aForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgotPasswordFragment forgotPasswordFragment = new ForgotPasswordFragment();
                getFragmentManager().beginTransaction().addToBackStack(null).replace(getId(), forgotPasswordFragment).commit();
            }
        });


        showpassword = (CheckBox)view.findViewById(R.id.showpassword);
        showpassword.setOnCheckedChangeListener(LoginFragment.this);

        aButtonLogin.setOnClickListener(LoginFragment.this);
        return view;

    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_login:
                try {
                    loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
                    if(aTextUsername != null && aTextPassword != null){
                        if (loginViewModel.findUser(aTextUsername.getText().toString()).getPassword().equals(aTextPassword.getText().toString())) {
                            EditUserProfileFragment editUserProfileFragment = new EditUserProfileFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("userId", aTextUsername.getText().toString());
                            editUserProfileFragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(getId(), editUserProfileFragment).commit();
                        }else{
                            Toast.makeText(getActivity(), "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                            aTextUsername.setText("");
                            aTextPassword.setText("");
                        }
                    }
                    }
                catch (Exception ex) {
                    Toast.makeText(getActivity(), "Enter username and password", Toast.LENGTH_LONG).show();
                    aTextUsername.setText("");
                    aTextPassword.setText("");
                }
                break;
        }

    }

    public void onCheckedChanged(CompoundButton buttonView, boolean b) {

        if (b) {
            aTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            aTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }


}

