package com.astzz.statussaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.astzz.statussaver.Animation.FebAnimation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FebAnimationActivity extends AppCompatActivity {


    FloatingActionButton feb1 ,feb2 ,feb3;
    Animation anim_open , anim_close , rotateForword , rotateBackword;
    boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feb_animation);

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
            feb3.startAnimation(anim_close);
            feb2.setClickable(true);
            feb3.setClickable(true);
            isopen = true;
        }
    }
}