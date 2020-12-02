package com.example.mynicestar;



import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Crea una Activity con una animacion y arranca el login
 * @author Sebastian Huete
 * @see LoginActivity
 */
public class LoginActivity extends Activity {
    protected Button mLoginButton;
    protected TextView SignUpTextview;
    protected ImageView iconoMitadEmo;
    protected ImageView iconoMitadDog;
    protected VideoView videofondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iconoMitadEmo = (ImageView) findViewById(R.id.imageViewEmo);
        Animation animationIconoEmo = AnimationUtils.loadAnimation(this,R.anim.translate_desde_abajo);
        iconoMitadEmo.startAnimation(animationIconoEmo);

        iconoMitadDog = (ImageView) findViewById(R.id.imageViewDog);
        Animation animationIconoDog = AnimationUtils.loadAnimation(this,R.anim.translate_desde_arriba);
        iconoMitadDog.startAnimation(animationIconoDog);

        videofondo = (VideoView) findViewById(R.id.back_login);

        videofondo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videofondo.start();
            }
        });

        Uri path = Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.dog_playa);
        videofondo.setVideoURI(path);
        videofondo.start();



//        ImageView fondo = findViewById(R.id.back_login);
//        String url = "https://images.unsplash.com/photo-1549442138-308bc33e56d9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80";
//        Glide.with(this)
//                .load(url)
//                .centerCrop()
//                .transition(DrawableTransitionOptions.withCrossFade(500))
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorAccent)))
//                .into(fondo);







        mLoginButton = (Button) findViewById(R.id.bottomLogin);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);


            }
        });


        SignUpTextview = (TextView) findViewById(R.id.textRegistro);
        SignUpTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);


            }
        });

    }
}
