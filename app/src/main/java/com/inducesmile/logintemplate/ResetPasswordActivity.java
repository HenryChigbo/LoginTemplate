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

public class ResetPasswordActivity extends AppCompatActivity {

    private static final String TAG = ResetPasswordActivity.class.getSimpleName();


    @BindView(R.id.email)
    TextInputEditText emailBox;


    @BindView(R.id.reset_btn)
    AppCompatButton resetBtn;


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

        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar){
            actionBar.hide();
        }
    }
    

    @OnClick(R.id.reset_btn)
    public void onPasswordReset(View view){
        String email = Objects.requireNonNull(emailBox.getText()).toString();
        if(TextUtils.isEmpty(email) || !email.contains("@")){
            DisplayUtils.showToast(this, "Invalid email address");
        }else{
            DisplayUtils.showToast(this, "Add code for password reset");
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideRight(this);
    }
}
