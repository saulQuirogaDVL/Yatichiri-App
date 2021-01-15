package com.example.proyectsistem.BasicosUI;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectsistem.Models.PuntajeBasico;
import com.example.proyectsistem.R;

public class ConjugacionActivity extends AppCompatActivity {

    ImageButton btnops,btnopp,btnons,btnonp;
    public MediaPlayer ops_aud,opp_aud,ons_aud,onp_aud;
    EditText califica_txt1,califica_txt2,califica_txt3,califica_txt4;
    public int verificador_aud=0;
    Button Calificar;
    String usuarior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjugacion);
        //Titulo
        this.setTitle("Conjugacion de los verbos");
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        usuarior=getIntent().getStringExtra("usuario");;
        setupview();
    }

    private void setupview() {

        //oracion positiva singular
        btnops=findViewById(R.id.btn_oracion_posi_s);
        ops_aud=MediaPlayer.create(this,R.raw.oracion_posi_s);
        btnops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ops_aud.start();
            }
        });
        //oracion positiva plural
        btnopp=findViewById(R.id.btn_oracion_posi_p);
        opp_aud=MediaPlayer.create(this,R.raw.oracion_posi_p);
        btnopp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opp_aud.start();
            }
        });
        //oracion negativa singular
        btnons=findViewById(R.id.btn_oracion_nega_s);
        ons_aud=MediaPlayer.create(this,R.raw.oracion_nega_s);
        btnons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ons_aud.start();
            }
        });
        //oracion negativa plural
        btnonp=findViewById(R.id.btn_oracion_nega_p);
        onp_aud=MediaPlayer.create(this,R.raw.oracion_nega_p);
        btnonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onp_aud.start();
            }
        });
        //Editext
        califica_txt1=findViewById(R.id.califica_txt1_con);
        califica_txt2=findViewById(R.id.califica_txt2_con);
        califica_txt3=findViewById(R.id.califica_txt3_con);
        califica_txt4=findViewById(R.id.califica_txt4_con);

        //Calificacion del capitulo
        Calificar=findViewById(R.id.calificar);
        Calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CalificarVocales()){
                    Toast.makeText(ConjugacionActivity.this, "Tema concluido con exito, Nuevo Tema desbloqueado", Toast.LENGTH_SHORT).show();
                    PuntajeBasico puntajeBasico= PuntajeBasico.findxUser(usuarior,5);
                    puntajeBasico.Puntaje=100;
                    puntajeBasico.save();
                }else {
                    Toast.makeText(ConjugacionActivity.this, "revise las pruebas puede que algunas esten incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean CalificarVocales() {
        if (califica_txt1.getText().toString().equals("nayax um umta")) {
            if (califica_txt2.getText().toString().equals("nanakax um umapxta")) {
                if (califica_txt3.getText().toString().equals("nayax janiw um umktti")) {
                    if (califica_txt4.getText().toString().equals("nanakax janiw um umpktti")) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

