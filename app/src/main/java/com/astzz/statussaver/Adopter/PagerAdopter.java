package com.astzz.statussaver.Adopter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.astzz.statussaver.ImageFragement;
import com.astzz.statussaver.VideoFragment;

public class PagerAdopter extends FragmentPagerAdapter {

    private ImageFragement imageFragement;
    private VideoFragment videoFragment;

    public PagerAdopter(@NonNull FragmentManager fm) {
        super(fm);
        imageFragement = new ImageFragement();
        videoFragment = new VideoFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return imageFragement;

        }else{
            return videoFragment;
        }
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "images";

        }else{
            return "videos";
        }
    }


    @Override
    public int getCount() {
        return 2;
    }


}

