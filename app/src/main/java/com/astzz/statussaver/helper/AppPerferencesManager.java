package com.astzz.statussaver.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPerferencesManager
{
    Context context;
    SharedPreferences sharedPreferences;

    public AppPerferencesManager (Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("App_perference", Context.MODE_PRIVATE);
    }

    public void setDarkModestate(boolean enable){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("DarkMode", enable);
        editor.apply();
    }

    public boolean getdarkModeState(){
        return sharedPreferences.getBoolean("DarkMode" , false);
    }
}
