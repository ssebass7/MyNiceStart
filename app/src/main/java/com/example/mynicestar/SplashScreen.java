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

/**Crea un Activity con animacion como presentacion de la app
 * @author Sebastian Huete
 * @see SplashScreen
 */
public class SplashScreen extends Activity {
    /**
     * Declaracion tipo Imagen de icono de la app
     */
    protected  ImageView logo;
    /**
     * Declaracion tipo Imagen establecido como fondo de interfaz
     */
    protected ImageView fondoSplScr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ejecuta el archivo activity_splash_screen.xml
        setContentView(R.layout.activity_splash_screen);

        //Inicializacion de "logo"
        logo = (ImageView) findViewById(R.id.logoApp);
        //Incializacion de la animacion "rotate" de "logo"
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        logo.startAnimation(myAnimation);

        //Inicializacion de "fondoSplScr"
        fondoSplScr = findViewById(R.id.back_dog_Food);
        String url ="https://images.unsplash.com/photo-1566431756727-c8e9212d0445?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80";
        //Recolector de imagen en "fondoSplScr" mediante url
        Glide.with(this)
                .load(url)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.white)))
                .into(fondoSplScr);
//"https://images.unsplash.com/photo-1582798358481-d199fb7347bb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80"
        openApp(true);



    }


     //Metodo para establecer la transicion a "LoginActivity"
     //y el tiempo de ejecucion
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

