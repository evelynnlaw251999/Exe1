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

import com.android.example.loginactivity.Data.Entity.User;
import com.android.example.loginactivity.Login.LoginFragment;
import com.android.example.loginactivity.R;

public class ForgetPasswordDetailsFragment extends Fragment {
    Button buttonChangePW;
    EditText newPassword;
    TextView welcomeUser;
    ForgetPasswordDetailsViewModel forgetPasswordDetailsViewModel;

    private String userName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_forget_password_details, container, false);

        if(getArguments() != null){
            userName = getArguments().getString("userId");
        }

        forgetPasswordDetailsViewModel = ViewModelProviders.of(this).get(ForgetPasswordDetailsViewModel.class);

        buttonChangePW = view.findViewById(R.id.button_change_password);
        newPassword = view.findViewById(R.id.edittext_newpassword);
        welcomeUser = view.findViewById(R.id.welcomeUser);
        welcomeUser.setText("Hello, " + userName +" !");

        buttonChangePW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = forgetPasswordDetailsViewModel.findUser(userName);

                user.setUsername(userName);
                user.setPassword(newPassword.getText().toString());

                forgetPasswordDetailsViewModel.updateUser(user);

                LoginFragment loginFragment = new LoginFragment();
                getFragmentManager().beginTransaction().replace(getId(), loginFragment).commit();

                Toast.makeText(getActivity(), "Successfully update password", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
