package com.matt.mvparchitecturem.ui.base;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.matt.mvparchitecturem.MvpApp;
import com.matt.mvparchitecturem.R;
import com.matt.mvparchitecturem.di.component.ActivityComponent;
import com.matt.mvparchitecturem.di.component.DaggerActivityComponent;
import com.matt.mvparchitecturem.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp)getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(com.google.android.material.R.id.content), message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }
}
