package com.astzz.statussaver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.astzz.statussaver.helper.AppPerferencesManager;

public class MiscellancouesActivity extends AppCompatActivity {

    AppPerferencesManager appPerferencesManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        appPerferencesManager = new AppPerferencesManager(this);
        if (appPerferencesManager.getdarkModeState()) {
            setTheme(R.style.AppThemeDark_NoActionBar);
        } else {
            setTheme(R.style.AppTheme_NoActionBar);
        }
        setContentView(R.layout.miscellancous);
        CheckBox mode_dark = findViewById(R.id.dark_mode);
        mode_dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (appPerferencesManager.getdarkModeState()) {
                    darkMode(false);
                } else {
                    darkMode(true);
                }
            }
        });

//        SharedPreferences sharedPreferences = getSharedPreferences("isDarkMode", MODE_PRIVATE);
//        final SharedPreferences.Editor meditor = sharedPreferences.edit();
//        final boolean isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);
//
//        if (isDarkMode) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }
//
//        mode_dark.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isDarkMode) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    meditor.putBoolean("isDarkMode", false);
//                    meditor.apply();
//                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    meditor.putBoolean("isDarkMode", true);
//                    meditor.apply();
//                }
//            }
//        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void darkMode(boolean b) {
        appPerferencesManager.setDarkModestate(b);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
