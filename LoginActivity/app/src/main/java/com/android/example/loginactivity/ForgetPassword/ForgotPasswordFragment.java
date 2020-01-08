package com.android.example.loginactivity.ForgetPassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.example.loginactivity.R;
import com.android.example.loginactivity.Register.RegisterFragment;

public class ForgotPasswordFragment extends Fragment implements View.OnClickListener {

    EditText username;
    TextView signUp;
    Button resetPassword;
    ForgetPasswordViewModel forgetPasswordViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_forgot_password, container, false);

        username = view.findViewById(R.id.edittext_username);

        resetPassword = view.findViewById(R.id.button_reset_password);

        resetPassword.setOnClickListener(ForgotPasswordFragment.this);

        signUp = view.findViewById(R.id.textview_sign_up);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFragment registerFragment = new RegisterFragment();
                getFragmentManager().beginTransaction().replace(getId(), registerFragment).commit();

            }
        });
        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_reset_password:
                try {
                    forgetPasswordViewModel = ViewModelProviders.of(this).get(ForgetPasswordViewModel.class);
                    if (username != null) {
                        if (forgetPasswordViewModel.findUser(username.getText().toString()).getUsername().equals(username.getText().toString())) {
                            ForgetPasswordDetailsFragment forgetPasswordDetailsFragment = new ForgetPasswordDetailsFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("userId", username.getText().toString());
                            forgetPasswordDetailsFragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(getId(), forgetPasswordDetailsFragment).commit();
                        }else{
                            Toast.makeText(getActivity(), "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                            username.setText("");
                        }
                    }
                } catch (Exception ex) {
                    Toast.makeText(getActivity(), "Invalid account username", Toast.LENGTH_LONG).show();
                    username.setText("");
                }
                break;
        }

    }
}
