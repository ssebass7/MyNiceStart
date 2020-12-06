package com.example.mynicestar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Crea una Activity vacia
 * @author Sebastian Huete
 * @see MainActivity2
 */
public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ejecuta el archivo activity_main2.xml
        setContentView(R.layout.activity_main2);
    }
}