package com.matt.mvparchitecturem.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.matt.mvparchitecturem.R;
import com.matt.mvparchitecturem.databinding.ActivityLoginBinding;
import com.matt.mvparchitecturem.databinding.ActivityMainBinding;
import com.matt.mvparchitecturem.ui.base.BaseActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginMvpView, View.OnClickListener {

    private ActivityLoginBinding binding;
    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getActivityComponent().inject(this);
        mPresenter.onAttach(LoginActivity.this);

        binding.etEmail.setText("matt@gmail.com");
        binding.etPassword.setText("123456");
        binding.btnServerLogin.setOnClickListener(this);
        binding.ibGoogleLogin.setOnClickListener(this);
        binding.ibFacebookLogin.setOnClickListener(this);
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_server_login) {
            mPresenter.onServerLoginClick(binding.etEmail.getText().toString(), binding.etPassword.getText().toString());
        } else if (v.getId() == R.id.ib_google_login) {
            mPresenter.onGoogleLoginClick();
        } else if (v.getId() == R.id.ib_facebook_login) {
            mPresenter.onFacebookLoginClick();
        }
    }

    @Override
    public void openMainActivity() {

    }
}