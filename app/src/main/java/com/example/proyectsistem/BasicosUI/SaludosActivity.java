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

public class SaludosActivity extends AppCompatActivity {

    ImageButton btns1,btns2,btnsal1,btnsal2;
    public MediaPlayer s1_aud,s2_aud;
    private static final int REQ_CODE_SPEECH_INPUT=100;
    TextView califica_aud1,califica_aud2;
    EditText califica_txt1,califica_txt2,califica_txt3,califica_txt4;
    public int verificador_aud=0;
    Button Calificar;
    String usuarior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludos);
        //Titulo
        this.setTitle("Saludos y Despedidas");
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        usuarior=getIntent().getStringExtra("usuario");;
        setupview();
    }

    private void setupview() {
        //saludo 1
        btns1=findViewById(R.id.btn_saludos1);
        s1_aud=MediaPlayer.create(this,R.raw.saludo1);
        btns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1_aud.start();
            }
        });
        //saludo 2
        btns2=findViewById(R.id.btn_saludos2);
        s2_aud=MediaPlayer.create(this,R.raw.saludo2);
        btns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2_aud.start();
            }
        });
        //audioin
        btnsal1=findViewById(R.id.btn_sal1);
        btnsal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=0;
                iniciarEntradaVoz();
            }
        });
        btnsal2=findViewById(R.id.btn_sal2);
        btnsal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=1;
                iniciarEntradaVoz();
            }
        });

        califica_aud1=findViewById(R.id.califica_aud1_sal);
        califica_aud2=findViewById(R.id.califica_aud2_sal);

        //Editext
        califica_txt1=findViewById(R.id.califica_txt1_sal);
        califica_txt2=findViewById(R.id.califica_txt2_sal);
        califica_txt3=findViewById(R.id.califica_txt3_sal);
        califica_txt4=findViewById(R.id.califica_txt4_sal);

        //Calificacion del capitulo
        Calificar=findViewById(R.id.calificar);
        Calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CalificarVocales()){
                    Toast.makeText(SaludosActivity.this, "Tema concluido con exito, Nuevo Tema desbloqueado", Toast.LENGTH_SHORT).show();
                    PuntajeBasico puntajeBasico= PuntajeBasico.findxUser(usuarior,6);
                    puntajeBasico.Puntaje=100;
                    puntajeBasico.save();
                }else {
                    Toast.makeText(SaludosActivity.this, "revise las pruebas puede que algunas esten incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean CalificarVocales() {
        if(califica_aud1.getText().toString().equals("Correcto")){
            if (califica_aud2.getText().toString().equals("Correcto")){
                    if(califica_txt1.getText().toString().equals("waliki")){
                        if(califica_txt2.getText().toString().equals("aski jaypukipanaya")){
                            if(califica_txt3.getText().toString().equals("aski arumakipanaya")){
                                if(califica_txt4.getText().toString().equals("aski urukipanaya")){
                                            return true;
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
                            if(palabra.equals("casquivana")||palabra.equals("as quiero que pana")||palabra.equals("aspiro que pana")||palabra.equals("casquero kitana")||palabra.equals("haz quiero tu pana")){
                                califica_aud1.setText("Correcto");
                            }
                            else {califica_aud1.setText("Incorrecto");}
                            break;
                        case 1:
                            if(palabra.equals("arturo maquipan")||palabra.equals("aquí aroma chipana")||palabra.equals("aski aroma chipana")||palabra.equals("askey aromaki pana")){
                                califica_aud2.setText("Correcto");
                            }
                            else {califica_aud2.setText("Incorrecto");}
                            break;
                    }
                }
                break;
            }
        }
    }

}
