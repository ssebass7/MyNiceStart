package com.example.mynicestar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {
    protected Button botonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonOk = (Button) findViewById(R.id.buttomConfirmar);
        ImageView avatar = findViewById(R.id.imageViewAvatar);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1606248174040-df0429d73afa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80\n")
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.light_purple_button)))
                .circleCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(avatar);


        botonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);


            }
        });

       // https://images.unsplash.com/photo-1606248174040-df0429d73afa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80

    }


}