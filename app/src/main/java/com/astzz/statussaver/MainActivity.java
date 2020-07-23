package com.astzz.statussaver;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.astzz.statussaver.helper.AppPerferencesManager;
import com.astzz.statussaver.model.Typcastregular;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.core.widget.ImageViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private LinearLayout status;
    private ImageView status_image;
    private TextView status_text;
    private ImageView business_image;
    private TextView business_text;
    private LinearLayout Business;
    private TextView setting;
    private LinearLayout rate_us;
    private TextView share;
    SharedPreferences msharedPreferences;
    SharedPreferences.Editor editor;


    FloatingActionButton feb1 ,feb2 ,feb3;
    Animation anim_open , anim_close , rotateForword , rotateBackword;
    boolean isopen = false;

    AppPerferencesManager appPerferencesManager;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appPerferencesManager = new AppPerferencesManager(this);
        if (appPerferencesManager.getdarkModeState()) {
            setTheme(R.style.AppThemeDark_NoActionBar);
        } else {
            setTheme(R.style.AppTheme_NoActionBar);
        }
        Typcastregular.Typcastregular(getApplicationContext(), "serif", "Sitka Small Bold.ttf");
        setContentView(R.layout.activity_main);


        status = findViewById(R.id.status);
        status.setOnClickListener(this);

        Business = findViewById(R.id.business_statuses);
        Business.setOnClickListener(this);

        setting = findViewById(R.id.settings);
        setting.setOnClickListener(this);

        rate_us = findViewById(R.id.Rate_us);
        rate_us.setOnClickListener(this);

        status_text = findViewById(R.id.status_tx);

        status_image = findViewById(R.id.ws_image);

        business_text = findViewById(R.id.business_tx);

        business_image = findViewById(R.id.image_business);

        share = findViewById(R.id.Share);
        share.setOnClickListener(this);

        feb1 = findViewById(R.id.fab1);
        feb2 = findViewById(R.id.fab2);
        feb3 = findViewById(R.id.fab3);

        anim_open = AnimationUtils.loadAnimation(this , R.anim.anim_open);
        anim_close = AnimationUtils.loadAnimation(this , R.anim.anim_close);

        rotateForword = AnimationUtils.loadAnimation(this , R.anim.rotate_forword);
        rotateBackword = AnimationUtils.loadAnimation(this , R.anim.rotate_backword);

        feb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationFeb();
                Toast.makeText(getApplicationContext() , "Add is clicked" ,Toast.LENGTH_LONG).show();
            }
        });


         msharedPreferences = getSharedPreferences("chkx", MODE_PRIVATE);
         editor = msharedPreferences.edit();

         Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
        chk();

    }


    private void ExitAlert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Alert");
        dialog.setIcon(R.drawable.ic_baseline_camera_alt_24);
        dialog.setCancelable(false);
        dialog.setMessage("Are you sure you want to exit?");

        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.status) {
            getSharedPreferences("usama", MODE_PRIVATE).edit().putString("chk", "wa").apply();
            onWa();
        }
        else if (id == R.id.business_statuses) {
            getSharedPreferences("usama", MODE_PRIVATE).edit().putString("chk", "wb").apply();
            onBa();
        } else if (id == R.id.settings) {
            Intent settingPage = new Intent(this, miscellancouesActivituy.class);
            startActivity(settingPage);

        } else if (id == R.id.Rate_us) {

            Intent rate_us = new Intent(this, RatingStarActivity.class);
            startActivity(rate_us);

        } else if (id == R.id.Share) {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Status Saver");
                String shareMessage = "Status saver app";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Open With"));
            } catch (Exception e) {
                e.toString();
            }

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void animationFeb(){
        if(isopen){
            feb1.startAnimation(rotateForword);
            feb2.startAnimation(anim_close);
            feb3.startAnimation(anim_close);
            feb2.setClickable(false);
            feb3.setClickable(false);
            isopen = false;
        }else{
            feb1.startAnimation(rotateBackword);
            feb2.startAnimation(anim_open);
            feb3.startAnimation(anim_open);
            feb2.setClickable(true);
            feb3.setClickable(true);
            isopen = true;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            ExitAlert();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    //    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.statuses) {
//            // Handle the camera action
//        } else if (id == R.id.business_statuses) {
//
//        } else if (id == R.id.settings) {
//
//        } else if (id == R.id.Rate_us) {
//
//        } else if (id == R.id.Share) {
//
//        }
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    @SuppressLint("ResourceType")
    private void onWa() {
        editor.putString("chk","WA").apply();

        status.setBackgroundResource(R.drawable.btn_style);
        Business.setBackgroundResource(0);
        status_text.setTextColor(Color.WHITE);

        ImageViewCompat.setImageTintList(status_image, ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.white)));


        business_text.setTextColor(Color.BLACK);
        ImageViewCompat.setImageTintList(business_image, ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.black)));

    }

    private void onBa() {
        editor.putString("chk","BA").apply();

        Business.setBackgroundResource(R.drawable.btn_style);
        status.setBackgroundResource(0);

        business_text.setTextColor(Color.WHITE);
        ImageViewCompat.setImageTintList(business_image, ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.white)));

        status_text.setTextColor(Color.BLACK);
        ImageViewCompat.setImageTintList(status_image, ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.black)));
    }


    private void chk() {
       String x= msharedPreferences.getString("chk","WA");
        if (x.equals("WA")){
            onWa();
        }else {
            onBa();
        }
    }

}
