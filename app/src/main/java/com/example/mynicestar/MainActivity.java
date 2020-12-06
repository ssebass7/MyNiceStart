package com.example.mynicestar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
/**
 * Crea una Activity simulando un usuario registrado (Foto de perfil y boton de iniciar)
 * @author Sebastian Huete
 * @see MainActivity
 */
public class MainActivity extends AppCompatActivity {
    /**
     *Declaracion tipo Boton para iniciar con el usuario registrado
     */
    protected Button botonGo;
    /**
     * Declaracion de tipo Imagen para foto de perfil de usuario
     */
    protected ImageView imgViewAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ejecuta el archivo activity_main.xml
        setContentView(R.layout.activity_main);

        //Inicializacion de "botonGo"
        botonGo = (Button) findViewById(R.id.buttomConfirmar);
        //Inicializacion de "avatar"
        imgViewAvatar = findViewById(R.id.imageViewAvatar);

        //Recolector de imagen en "imgViewAvatar" mediante url
        //Centra y recorta la imagen
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1606248174040-df0429d73afa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80\n")
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.light_purple_button)))
                .circleCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imgViewAvatar);

        //Metodo de "botonGo" para realizar transicion de "MainActivity" a "MainActivity2"
        botonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);


            }
        });
    }
}