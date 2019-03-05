package com.inducesmile.logintemplate;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.textfield.TextInputEditText;
import com.inducesmile.logintemplate.utils.DisplayUtils;

import java.util.Objects;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import spencerstudios.com.bungeelib.Bungee;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = SignupActivity.class.getSimpleName();

    @BindView(R.id.first_name)
    TextInputEditText firstnameBox;

    @BindView(R.id.last_name)
    TextInputEditText lastnameBox;

    @BindView(R.id.username)
    TextInputEditText usernameBox;

    @BindView(R.id.email)
    TextInputEditText emailBox;

    @BindView(R.id.password)
    TextInputEditText passwordBox;

    @BindView(R.id.signup_btn)
    AppCompatButton signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar){
            actionBar.hide();
        }
    }

    @OnClick(R.id.signup_btn)
    public void onSignUpNewUser(View view){
        String firstname = Objects.requireNonNull(firstnameBox.getText()).toString();
        String lastname = Objects.requireNonNull(lastnameBox.getText()).toString();
        String username = Objects.requireNonNull(usernameBox.getText()).toString();
        String email = Objects.requireNonNull(emailBox.getText()).toString();
        String password = Objects.requireNonNull(passwordBox.getText()).toString();

        if(TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname) || TextUtils.isEmpty(username)
                || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            DisplayUtils.showToast(SignupActivity.this, "All fields must be filled");
        }else if(!email.contains("@")){
            DisplayUtils.showToast(SignupActivity.this, "Invalid email address");
        }else if(password.length() < 6){
            DisplayUtils.showToast(SignupActivity.this, "Password length must be greater 6");
        }else{
            //post to server
            DisplayUtils.showToast(SignupActivity.this, "Add sign up logic here");
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideRight(SignupActivity.this);
    }

}
