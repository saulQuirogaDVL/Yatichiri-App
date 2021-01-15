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

public class PronombresActivity extends AppCompatActivity {

    ImageButton btnyo,btntu,btnella,btnnos1,btnnos2,btnustedes,btnellos,btnnos3;
    ImageButton btnpronom1, btnpronom2, btnpronom3;
    public MediaPlayer yo, tu, ella, nos1, nos2, ustedes, ellos, nos3;
    public int verificador_aud=0;
    TextView califica_aud1,califica_aud2,califica_aud3;
    EditText califica_txt1,califica_txt2,califica_txt3,califica_txt4,califica_txt5,califica_txt6;
    String usuarior;
    Button Calificar;
    private static final int REQ_CODE_SPEECH_INPUT=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronombres);

        //Titulo
        this.setTitle("Pronombres Personales");
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        usuarior=getIntent().getStringExtra("usuario");;
        setupview();
    }

    private void setupview() {
        //----------------YO
        btnyo=findViewById(R.id.btn_yo);
        yo=MediaPlayer.create(this,R.raw.yo);
        btnyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yo.start();
            }
        });
        //----------------TU
        btntu=findViewById(R.id.btn_tu);
        tu=MediaPlayer.create(this,R.raw.tu);
        btntu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tu.start();
            }
        });
        //-------------EL ELLA
        btnella=findViewById(R.id.btn_el);
        ella=MediaPlayer.create(this,R.raw.elella);
        btnella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ella.start();
            }
        });
        //-------------NOSOTROS 1
        btnnos1=findViewById(R.id.btn_nosotros1);
        nos1=MediaPlayer.create(this,R.raw.nosuno);
        btnnos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nos1.start();
            }
        });
        //--------------NOSOTROS2
        btnnos2=findViewById(R.id.btn_nosotros2);
        nos2=MediaPlayer.create(this,R.raw.yo);
        btnnos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nos2.start();
            }
        });
        //--------------USTEDES
        btnustedes=findViewById(R.id.btn_ustedes);
        ustedes=MediaPlayer.create(this,R.raw.ustedes);
        btnustedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ustedes.start();
            }
        });
        //-----------ELLOS ELLAS
        btnellos=findViewById(R.id.btn_ellos);
        ellos=MediaPlayer.create(this,R.raw.ellos);
        btnellos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ellos.start();
            }
        });


        btnnos3=findViewById(R.id.btn_nosotros3);
        nos3=MediaPlayer.create(this,R.raw.yo);
        btnnos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nos3.start();
            }
        });
        //--------------------------------------------------------------------
        btnpronom1=findViewById(R.id.btn_pronom1);
        btnpronom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=0;
                iniciarEntradaVoz();
            }
        });
        btnpronom2=findViewById(R.id.btn_pronom2);
        btnpronom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=1;
                iniciarEntradaVoz();
            }
        });
        btnpronom3=findViewById(R.id.btn_pronom3);
        btnpronom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=2;
                iniciarEntradaVoz();
            }
        });

        //Editext
        califica_txt1=findViewById(R.id.califica_txt1);
        califica_txt2=findViewById(R.id.califica_txt2);
        califica_txt3=findViewById(R.id.califica_txt3);
        califica_txt4=findViewById(R.id.califica_txt4);

        //audscalificar
        califica_aud1=findViewById(R.id.calificar_aud1_pr);
        califica_aud2=findViewById(R.id.calificar_aud2_pr);
        califica_aud3=findViewById(R.id.calificar_aud3_pr);

        //Calificacion del capitulo
        Calificar=findViewById(R.id.calificar);
        Calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CalificarVocales()){
                    Toast.makeText(PronombresActivity.this, "Tema concluido con exito, Nuevo Tema desbloqueado", Toast.LENGTH_SHORT).show();
                    PuntajeBasico puntajeBasico= PuntajeBasico.findxUser(usuarior,4);
                    puntajeBasico.Puntaje=100;
                    puntajeBasico.save();
                }else {
                    Toast.makeText(PronombresActivity.this, "revise las pruebas puede que algunas esten incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean CalificarVocales() {
        if(califica_aud1.getText().toString().equals("Correcto")){
            if (califica_aud2.getText().toString().equals("Correcto")){
                if(califica_aud3.getText().toString().equals("Correcto")){
                    if(califica_txt1.getText().toString().equals("juma")){
                        if(califica_txt2.getText().toString().equals("jupanaka")){
                            if(califica_txt3.getText().toString().equals("nanaka")){
                                if(califica_txt4.getText().toString().equals("jupa")){
                                            return true;
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
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"arsuña-hablar!");
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
                            if(palabra.equals("naya")){
                                califica_aud1.setText("Correcto");
                            }
                            else {califica_aud1.setText("Incorrecto");}
                            break;
                        case 1:
                            if(palabra.equals("human acá")||palabra.equals("homan acá")){
                                califica_aud2.setText("Correcto");
                            }
                            else {califica_aud2.setText("Incorrecto");}
                            break;
                        case 2:
                            if(palabra.equals("jupa")){
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
