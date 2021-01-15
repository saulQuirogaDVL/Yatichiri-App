package com.example.proyectsistem.BasicosUI;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectsistem.Models.PuntajeBasico;
import com.example.proyectsistem.R;

import java.util.ArrayList;
import java.util.Locale;

public class VocalesActivity extends AppCompatActivity {

    ImageButton btnapachita,btnisi,btnuta,btnanu,btnispi,btnmaki;
    public MediaPlayer apachita_aud,isi_aud,uta_aud;
    private static final int REQ_CODE_SPEECH_INPUT=100;
    TextView califica_aud1,califica_aud2,califica_aud3;
    EditText califica_txt1,califica_txt2,califica_txt3,califica_txt4,califica_txt5,califica_txt6;
    public int verificador_aud=0;
    Button Calificar;
    String usuarior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocales);
        //Titulo
        this.setTitle("Vocales");
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        usuarior=getIntent().getStringExtra("usuario");;
        setupview();
    }



    private void setupview() {
        //apachita
        btnapachita=findViewById(R.id.btn_oracion_posi_p);
        apachita_aud=MediaPlayer.create(this,R.raw.apachita);
        btnapachita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apachita_aud.start();
            }
        });
        //isi
        btnisi=findViewById(R.id.btn_isi);
        isi_aud=MediaPlayer.create(this,R.raw.isi);
        btnisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isi_aud.start();
            }
        });
        //uta
        btnuta=findViewById(R.id.btn_uta);
        uta_aud=MediaPlayer.create(this,R.raw.uta);
        btnuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uta_aud.start();
            }
        });
        //anu_aud
        btnanu=findViewById(R.id.btn_anu);
        btnanu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=0;
                iniciarEntradaVoz();
            }
        });
        //anu_califica
        califica_aud1=findViewById(R.id.califica_aud1);
        //ispi_aud
        btnispi=findViewById(R.id.btn_ispi);
        btnispi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=1;
                iniciarEntradaVoz();
            }
        });
        //ispi_califica
        califica_aud2=findViewById(R.id.califica_aud2);
        //maki_aud
        btnmaki=findViewById(R.id.btn_maki);
        btnmaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=2;
                iniciarEntradaVoz();
            }
        });
        //maki_califica
        califica_aud3=findViewById(R.id.califica_aud3);

        //Editext
        califica_txt1=findViewById(R.id.califica_txt1);
        califica_txt2=findViewById(R.id.califica_txt2);
        califica_txt3=findViewById(R.id.califica_txt3);
        califica_txt4=findViewById(R.id.califica_txt4);
        califica_txt5=findViewById(R.id.califica_txt5);
        califica_txt6=findViewById(R.id.califica_txt6);

        //Calificacion del capitulo
        Calificar=findViewById(R.id.calificar);
        Calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CalificarVocales()){
                    Toast.makeText(VocalesActivity.this, "Tema concluido con exito, Nuevo Tema desbloqueado", Toast.LENGTH_SHORT).show();
                    PuntajeBasico puntajeBasico= PuntajeBasico.findxUser(usuarior,1);
                    puntajeBasico.Puntaje=100;
                    puntajeBasico.save();
                }else {
                    Toast.makeText(VocalesActivity.this, "revise las pruebas puede que algunas esten incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean CalificarVocales() {
        if(califica_aud1.getText().toString().equals("Correcto")){
            if (califica_aud2.getText().toString().equals("Correcto")){
                if(califica_aud3.getText().toString().equals("Correcto")){
                    if(califica_txt1.getText().toString().equals("ana")){
                        if(califica_txt2.getText().toString().equals("alaya")){
                            if(califica_txt3.getText().toString().equals("sapa")){
                                if(califica_txt4.getText().toString().equals("iki")){
                                    if(califica_txt5.getText().toString().equals("jiwiri")){
                                        if(califica_txt6.getText().toString().equals("titi")){
                                            return true;
                                        }else {return false;}
                                    }else {return false;}
                                }else {return false;}
                            }else {return false;}
                        }else {return false;}
                    }else {return false;}
                }else {return false;}
            }else {return false;}
        }else {return false;}
    }
    private void iniciarEntradaVoz() {
        Intent intent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"arsuña-hablar");
        try {
            startActivityForResult(intent,REQ_CODE_SPEECH_INPUT);
        }catch (ActivityNotFoundException e){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQ_CODE_SPEECH_INPUT:{
                if(resultCode==RESULT_OK&&null!=data){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String palabra=result.get(0).toLowerCase();
                    switch (verificador_aud){
                        case 0:
                            if(palabra.equals("ah no")||palabra.equals("aló")){
                                califica_aud1.setText("Correcto");
                            }
                            else {califica_aud1.setText("Incorrecto");}
                            break;
                        case 1:
                            if(palabra.equals("este")||palabra.equals("espe")||palabra.equals("sp")){
                                califica_aud2.setText("Correcto");
                            }
                            else {califica_aud2.setText("Incorrecto");}
                            break;
                        case 2:
                            if(palabra.equals("nada aqui")||palabra.equals("maggie")||palabra.equals("max")||palabra.equals("maki")){
                                califica_aud3.setText("Correcto");
                            }
                            else {califica_aud3.setText("Incorrecto");}
                            break;
                    }
                }
                break;
            }
        }
    }

}
