package com.example.mynicestar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView logo = (ImageView) findViewById(R.id.logoApp);
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        logo.startAnimation(myAnimation);

        ImageView fondo = findViewById(R.id.back_dog_Food);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1582798358481-d199fb7347bb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80")
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
                .into(fondo);

        openApp(true);



    }
    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}

