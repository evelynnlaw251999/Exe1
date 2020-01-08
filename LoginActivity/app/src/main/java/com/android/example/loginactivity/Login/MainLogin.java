package com.android.example.loginactivity.Login;

import android.content.Intent;
        import android.os.Bundle;
        import android.text.method.HideReturnsTransformationMethod;
        import android.text.method.PasswordTransformationMethod;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

import com.android.example.loginactivity.Register.RegisterActivity;
import com.android.example.loginactivity.R;


public class MainLogin extends AppCompatActivity {

    LoginViewModel loginViewModel;
    EditText aTextUsername;
    EditText aTextPassword;
    Button aButtonLogin;
    TextView aTextViewSignUp;
    CheckBox showpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);



        aTextUsername = findViewById(R.id.edittext_username);
        aTextPassword = findViewById(R.id.edittext_password);
        showpassword = findViewById(R.id.showpassword);
        aButtonLogin = findViewById(R.id.button_login);

        aTextViewSignUp = findViewById(R.id.textview_sign_up);
        aTextViewSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent signupIntent = new Intent(MainLogin.this, RegisterActivity.class);
                startActivity(signupIntent);
            }
        });

        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (b) {
                    aTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    aTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });





    }
}