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

public class OcupacionActivity extends AppCompatActivity {

    ImageButton btnprofesor,btncantante,btnoc1,btnoc2;
    public MediaPlayer profesor_aud,cantante_aud;
    private static final int REQ_CODE_SPEECH_INPUT=100;
    TextView califica_aud1,califica_aud2;
    EditText califica_txt1,califica_txt2,califica_txt3;
    public int verificador_aud=0;
    Button Calificar;
    String usuarior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocupacion);
        //Titulo
        this.setTitle("Profesion u Ocupacion");
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        usuarior=getIntent().getStringExtra("usuario");;
        setupview();
    }

    private void setupview() {
        //profesor
        btnprofesor = findViewById(R.id.btn_profesor);
        profesor_aud = MediaPlayer.create(this, R.raw.profesor);
        btnprofesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesor_aud.start();
            }
        });
        //cantante
        btncantante = findViewById(R.id.btn_cantante);
        cantante_aud = MediaPlayer.create(this, R.raw.cantante);
        btncantante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantante_aud.start();
            }
        });

        //anu_aud
        btnoc1 = findViewById(R.id.btn_oc1);
        btnoc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud = 0;
                iniciarEntradaVoz();
            }
        });
        //anu_califica
        califica_aud1 = findViewById(R.id.califica_aud_oc1);
        //ispi_aud
        btnoc2 = findViewById(R.id.btn_oc2);
        btnoc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud = 1;
                iniciarEntradaVoz();
            }
        });
        //ispi_califica
        califica_aud2 = findViewById(R.id.califica_aud_oc2);

        //Editext
        califica_txt1 = findViewById(R.id.califica_txt_oc1);
        califica_txt2 = findViewById(R.id.califica_txt_oc2);
        califica_txt3 = findViewById(R.id.califica_txt_oc3);

        //Calificacion del capitulo
        Calificar = findViewById(R.id.calificar);
        Calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CalificarVocales()) {
                    Toast.makeText(OcupacionActivity.this, "Tema concluido con exito, Nuevo Tema desbloqueado", Toast.LENGTH_SHORT).show();
                    PuntajeBasico puntajeBasico = PuntajeBasico.findxUser(usuarior, 10);
                    puntajeBasico.Puntaje = 100;
                    puntajeBasico.save();
                } else {
                    Toast.makeText(OcupacionActivity.this, "revise las pruebas puede que algunas esten incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        private boolean CalificarVocales(){
            if(califica_aud1.getText().toString().equals("Correcto")){
                if (califica_aud2.getText().toString().equals("Correcto")){
                    if(califica_txt1.getText().toString().equals("anatiri")){
                        if(califica_txt2.getText().toString().equals("qhuyan irnaqiri")){
                            if(califica_txt3.getText().toString().equals("phayiri")){
                                return true;
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
                            if(palabra.equals("colibrí")||palabra.equals("oliri")||palabra.equals("collares")){
                                califica_aud1.setText("Correcto");
                            }
                            else {califica_aud1.setText("Incorrecto");}
                            break;
                        case 1:
                            if(palabra.equals("aratirí")||palabra.equals("arhatic")||palabra.equals("are happy")){
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
