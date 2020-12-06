package com.example.mynicestar;



import android.app.Activity;
import android.content.Intent;
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

/**
 * Crea una Activity con una animacion y arranca el login
 * @author Sebastian Huete
 * @see LoginActivity
 */
public class LoginActivity extends Activity {
    /**
     * Declaracion tipo Boton "Log In" que lleva a la interfaz "MainActivity"
     */
    protected Button loginButton;
    /**
     * Declaracion tipo Texto que lleva a la interfaz de "Sign Up" (RegistroActivity)
     *
     */
    protected TextView signUpTextview;
    /**
     * Declaracion tipo Imagen de la mitad izquierda del logo
     */
    protected ImageView iconoMitadEmo;
    /**
     * Declaracion tipo Imagen de la mitad derecha del logo
     */
    protected ImageView iconoMitadDog;
    /**
     * Declaracion tipo Video establecido como fondo de interfaz
     */
    protected VideoView videofondoLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Ejecuta el archivo activity_login.xml
        setContentView(R.layout.activity_login);

        //Inicializacion de "iconoMitadEmo"
        iconoMitadEmo = (ImageView) findViewById(R.id.imageViewEmo);

        //Incializacion de la animacion "translate_desde_abajo" de "iconoMitadEmo"
        Animation animationIconoEmo = AnimationUtils.loadAnimation(this,R.anim.translate_desde_abajo);
        iconoMitadEmo.startAnimation(animationIconoEmo);

        //Incializacion de la animacion "translate_desde_arriba" de "iconoMitadDog"
        iconoMitadDog = (ImageView) findViewById(R.id.imageViewDog);
        Animation animationIconoDog = AnimationUtils.loadAnimation(this,R.anim.translate_desde_arriba);
        iconoMitadDog.startAnimation(animationIconoDog);

        //Incializacion del video establecido como fondo "videofondo" de interfaz "LoginActivity"
        videofondoLog = (VideoView) findViewById(R.id.back_login);

        //Metodo de "videofondoLog" para volver a reproducirlo cada vez que finalice
        videofondoLog.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videofondoLog.start();
            }
        });

        //Inicializacion de "videofondoLog"
        Uri path = Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.dog_playa);
        videofondoLog.setVideoURI(path);
        videofondoLog.start();

        //Inicialicion de "mLoginButton"
        loginButton = (Button) findViewById(R.id.bottomLogin);
        //Metodo de "mLoginButton" para realizar transicion de "LoginActivity" a "MainActivity"
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);


            }
        });

        //Inicialicion de "signUpTextview"
        signUpTextview = (TextView) findViewById(R.id.textRegistro);
        //Metodo de "signUpTextview" para realizar transicion de "LoginActivity" a "RegistroActivity"
        signUpTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);


            }
        });

    }
}

//CODIGO INSERVIBLE: IGNORAR
//        ImageView fondo = findViewById(R.id.back_login);
//        String url = "https://images.unsplash.com/photo-1549442138-308bc33e56d9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80";
//        Glide.with(this)
//                .load(url)
//                .centerCrop()
//                .transition(DrawableTransitionOptions.withCrossFade(500))
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorAccent)))
//                .into(fondo);








