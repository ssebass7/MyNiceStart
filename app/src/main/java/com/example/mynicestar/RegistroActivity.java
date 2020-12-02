package com.example.mynicestar;

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

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**Crea un Activity con animacion y arranca el Sign Up
 *El cambio de imagen del icono simula el añadido de foto de perfil
 * @author Sebastian Huete
 * @see RegistroActivity
 */
public class RegistroActivity extends AppCompatActivity {
    protected TextView loginText;
    protected Button mSignUpButton;
    protected ImageView iconoDog;
    protected VideoView videofondoR;
    protected RegistroActivity  ra = this;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registro);

            iconoDog = (ImageView)findViewById(R.id.imageViewDogRegistro);
            Animation myAnimDog = AnimationUtils.loadAnimation(this,R.anim.alpha);
            iconoDog.startAnimation(myAnimDog);

            videofondoR = (VideoView) findViewById(R.id.back_registro);
            videofondoR.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    videofondoR.start();
                }
            });

            Uri path = Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.dog_parque);
            videofondoR.setVideoURI(path);
            videofondoR.start();

            String pathIconReg =  "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80";
            iconoDog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView avatar = findViewById(R.id.imageViewDogRegistro);

                    Glide.with(ra)
                            .load(pathIconReg)
                            .centerCrop()
                            .transition(DrawableTransitionOptions.withCrossFade(500))
//             .placeholder(new ColorDrawable(ra.getResources().getColor(R.color.grey)))
                            .circleCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(avatar);
                }
            });

            loginText = (TextView)findViewById(R.id.textIniciaSesion);
            loginText.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                    startActivity(intent);


                }
            });

            mSignUpButton = findViewById(R.id.bottomSignUp);
            mSignUpButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(RegistroActivity.this, SplashScreen.class);
                    startActivity(intent);


                }
            });
        }

}
