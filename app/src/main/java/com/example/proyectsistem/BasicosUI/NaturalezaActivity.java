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

public class NaturalezaActivity extends AppCompatActivity {

    ImageButton btnnat1,btnnat2,btnnat3;
    private static final int REQ_CODE_SPEECH_INPUT=100;
    TextView califica_aud1,califica_aud2,califica_aud3;
    EditText califica_txt1,califica_txt2,califica_txt3;
    public int verificador_aud=0;
    Button Calificar;
    String usuarior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naturaleza);
        //Titulo
        this.setTitle("Naturaleza");
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        usuarior=getIntent().getStringExtra("usuario");;
        setupview();
    }

    private void setupview() {
        //anu_aud
        btnnat1=findViewById(R.id.btn_nat1);
        btnnat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=0;
                iniciarEntradaVoz();
            }
        });
        //anu_califica
        califica_aud1=findViewById(R.id.calificar_aud_nat1);
        //ispi_aud
        btnnat2=findViewById(R.id.btn_nat2);
        btnnat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=1;
                iniciarEntradaVoz();
            }
        });
        //ispi_califica
        califica_aud2=findViewById(R.id.calificar_aud_nat2);

        //ispi_aud
        btnnat3=findViewById(R.id.btn_nat3);
        btnnat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=2;
                iniciarEntradaVoz();
            }
        });

        //ispi
        califica_aud3=findViewById(R.id.calificar_aud_na3);

        //Editext
        califica_txt1=findViewById(R.id.califica_txt_nat1);
        califica_txt2=findViewById(R.id.califica_txt_nat2);
        califica_txt3=findViewById(R.id.califica_txt_nat3);

        //Calificacion del capitulo
        Calificar=findViewById(R.id.calificar);
        Calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CalificarVocales()){
                    Toast.makeText(NaturalezaActivity.this, "Tema concluido con exito, Nuevo Tema desbloqueado", Toast.LENGTH_SHORT).show();
                    PuntajeBasico puntajeBasico= PuntajeBasico.findxUser(usuarior,14);
                    puntajeBasico.Puntaje=100;
                    puntajeBasico.save();
                }else {
                    Toast.makeText(NaturalezaActivity.this, "revise las pruebas puede que algunas esten incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean CalificarVocales() {
        if(califica_aud1.getText().toString().equals("Correcto")){
            if (califica_aud2.getText().toString().equals("Correcto")){
                if(califica_aud3.getText().toString().equals("Correcto")){
                    if(califica_txt1.getText().toString().equals("jaqikankaña")){
                        if(califica_txt2.getText().toString().equals("khunu")){
                            if(califica_txt3.getText().toString().equals("qhana")){
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
                            if(palabra.equals("nena")||palabra.equals("nina")){
                                califica_aud1.setText("Correcto");
                            }
                            else {califica_aud1.setText("Incorrecto");}
                            break;
                        case 1:
                            if(palabra.equals("cheeky")){
                                califica_aud2.setText("Correcto");
                            }
                            else {califica_aud2.setText("Incorrecto");}
                            break;
                        case 2:
                            if(palabra.equals("cata chila")||palabra.equals("tapachula")||palabra.equals("catzilla")||palabra.equals("cata china")){
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
