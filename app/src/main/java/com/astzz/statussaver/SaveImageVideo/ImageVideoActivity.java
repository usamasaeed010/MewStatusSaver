package com.astzz.statussaver.SaveImageVideo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.astzz.statussaver.R;
import com.google.android.material.tabs.TabLayout;

public class ImageVideoActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);

        viewPager = findViewById(R.id.viewPAger);
        tabLayout = findViewById(R.id.tabLayoutSlider);
    }




}
