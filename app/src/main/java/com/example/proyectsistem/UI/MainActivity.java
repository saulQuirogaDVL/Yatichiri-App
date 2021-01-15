package com.example.proyectsistem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proyectsistem.Models.Usuarios;
import com.example.proyectsistem.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Titulo
        this.setTitle(R.string.menu);
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //recuperar usuario
        final String usuario=getIntent().getStringExtra("usuario");;
        //Intent a Instrucciones

        ImageButton btnIns=(ImageButton)findViewById(R.id.btn_Intrucciones);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIns=new Intent(getBaseContext(),IndiceActivity.class);
                startActivity(intentIns);
            }
        });

        //intent a Nivel Basico
        ImageButton btnBas=(ImageButton)findViewById(R.id.btn_Basico);
        btnBas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBas=new Intent(getBaseContext(),List_Nivel_Basico.class);
                intentBas.putExtra("usuario",usuario);
                startActivity(intentBas);
            }
        });

        //intent a Nivel Intermedio
        ImageButton btnInt=(ImageButton)findViewById(R.id.btn_Intermedio);
        btnInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInt=new Intent(getBaseContext(),List_Nivel_Intermedio.class);
                startActivity(intentInt);
            }
        });
        //intent a Nivel Introduccion
        ImageButton btnIntro=(ImageButton)findViewById(R.id.btn_Intro);
        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIntro=new Intent(getBaseContext(),List_Nivel_Introduccion.class);
                startActivity(intentIntro);
            }
        });

        //intent a usuario
        ImageButton btnUs=(ImageButton)findViewById(R.id.btn_Usuario);
        btnUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInt=new Intent(getBaseContext(),UserActivity.class);
                intentInt.putExtra("usuario",usuario);
                startActivity(intentInt);
            }
        });
    }
}
