package com.example.mynicestar;

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

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**Crea un Activity con animacion y arranca el Sign Up.
 *El cambio de imagen del icono simula el añadido de foto de perfil
 * @author Sebastian Huete
 * @see RegistroActivity
 */
public class RegistroActivity extends AppCompatActivity {
    /**
     * Declaracion tipo Texto que lleva a la interfaz de "Log In" (LoginActivity)
     *
     */
    protected TextView loginText;
    /**
     * Declaracion tipo Boton "Sign Up" que lleva a la interfaz "MainActivity"
     */
    protected Button signUpButton;
    /**
     * Declaracion tipo Imagen para icono de registro En un futuro, al ser pulsado,
     * debe abrir un menu de seleccion de foto de perfil
     */
    protected ImageView iconoDog;
    /**
     * Declaracion tipo Video establecido como fondo de interfaz
     */
    protected VideoView videofondoReg;
    /**
     * Declaracion e inicializacion para objeto de clase "RegistroActivity"
     */
    protected RegistroActivity regAct = this;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Ejecuta el archivo activity_registro.xml
            setContentView(R.layout.activity_registro);

            //Inicializacion de "iconoDog"
            iconoDog = (ImageView)findViewById(R.id.imageViewDogRegistro);
            //Incializacion de la animacion "alpha" de "iconoDog"
            Animation myAnimDog = AnimationUtils.loadAnimation(this,R.anim.alpha);
            iconoDog.startAnimation(myAnimDog);

            //Incializacion del video establecido como fondo "videofondoReg" de interfaz "RegistroActivity"
            videofondoReg = (VideoView) findViewById(R.id.back_registro);

            //Metodo de "videofondoReg" para volver a reproducirlo cada vez que finalice
            videofondoReg.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    videofondoReg.start();
                }
            });

            //Incializacion de "videofondoReg"
            Uri path = Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.dog_parque);
            videofondoReg.setVideoURI(path);
            videofondoReg.start();

            //Url para foto de perfil despues de pulsar icono "iconoDog"
            String pathIconReg =  "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80";
            //Metodo de "iconoDog" para realizar cambio de foto en el icono de la interfaz "RegistroActivity"
            //para simular la seleccion de foto de perfil de usuario al ser pulsado
            //Centra y recorta la imagen
            iconoDog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView avatar = findViewById(R.id.imageViewDogRegistro);

                    Glide.with(regAct)
                            .load(pathIconReg)
                            .centerCrop()
                            .transition(DrawableTransitionOptions.withCrossFade(500))
//             .placeholder(new ColorDrawable(ra.getResources().getColor(R.color.grey)))
                            .circleCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(avatar);
                }
            });
            //Inicializacion de "loginText"
            loginText = (TextView)findViewById(R.id.textIniciaSesion);
            //Metodo de "loginText" para realizar transicion de "RegistroActivity" a "LoginActivity"
            loginText.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                    startActivity(intent);


                }
            });
            //Inicializacion de "signUpButton"
            signUpButton = findViewById(R.id.bottomSignUp);
            //Metodo de "signUpButton" para realizar transicion de "RegistroActivity" a "SplashScreen"
            signUpButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(RegistroActivity.this, SplashScreen.class);
                    startActivity(intent);


                }
            });
        }

}
