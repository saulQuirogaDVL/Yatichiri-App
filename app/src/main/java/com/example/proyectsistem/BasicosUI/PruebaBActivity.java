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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectsistem.Models.PruebasBasico;
import com.example.proyectsistem.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class PruebaBActivity extends AppCompatActivity {

    ImageButton btn_pruebason1,btn_pruebason2,btn_pruebason3,btn_pruebaaud1,btn_pruebaaud2,btn_pruebaaud3;
    EditText respuesta_son1, respuesta_son2,respuesta_son3,respuesta_esc1,respuesta_esc2,respuesta_esc3,respuesta_esc4;
    ImageView imagen_aud1,imagen_aud2,imagen_aud3;
    TextView respuesta_aud1,respuesta_aud2,respuesta_aud3,ayuda_aud1,ayuda_aud2,ayuda_aud3,pregunta_esc1,pregunta_esc2,pregunta_esc3,pregunta_esc4;
    Button finalizar;
    List<PruebasBasico> pruebasBasicoList;
    public PruebasBasico basico,Define;
    public MediaPlayer primer_aud,segundo_aud,tercer_aud;
    public int verificador_aud=0;
    private static final int REQ_CODE_SPEECH_INPUT=100;
    public List<String> respuesta_escrita_aud1,respuesta_escrita_aud2,respuesta_escrita_aud3;
    String SonidoRespuesta1="",SonidoRespuesta2="",SonidoRespuesta3="";
    String EscritoRespuesta1,EscritoRespuesta2,EscritoRespuesta3,EscritoRespuesta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_b);
        pruebasBasicoList=PruebasBasico.Crear_Pruebas();
        setUpView();
    }

    private void setUpView() {
        //ImageButton
        //salida audio
        Define=Seleccion_random();
        SonidoRespuesta1=Define.respuestaSonido;
        primer_aud=Elejir_Sonido(Define.imagenAudio);
        btn_pruebason1=findViewById(R.id.btn_prueba_son1);
        btn_pruebason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primer_aud.start();
            }
        });

        Define=Seleccion_random();
        SonidoRespuesta2=Define.respuestaSonido;
        segundo_aud=Elejir_Sonido(Define.imagenAudio);
        btn_pruebason2=findViewById(R.id.btn_prueba_son2);
        btn_pruebason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segundo_aud.start();
            }
        });


        Define=Seleccion_random();
        SonidoRespuesta3=Define.respuestaSonido;
        tercer_aud=Elejir_Sonido(Define.imagenAudio);
        btn_pruebason3=findViewById(R.id.btn_prueba_son3);
        btn_pruebason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tercer_aud.start();
            }
        });


        //salida de audio
        btn_pruebaaud1=findViewById(R.id.btn_prueba_aud1);
        btn_pruebaaud1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=0;
                iniciarEntradaVoz();
            }
        });

        btn_pruebaaud2=findViewById(R.id.btn_prueba_aud2);
        btn_pruebaaud2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=1;
                iniciarEntradaVoz();
            }
        });

        btn_pruebaaud3=findViewById(R.id.btn_prueba_aud3);
        btn_pruebaaud3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificador_aud=2;
                iniciarEntradaVoz();
            }
        });

        //EditText
        respuesta_son1= findViewById(R.id.btn_respuesta_son1);

        respuesta_son2= findViewById(R.id.btn_respuesta_son2);

        respuesta_son3= findViewById(R.id.btn_respuesta_son3);

        respuesta_esc1= findViewById(R.id.prueba_respuesta_1);

        respuesta_esc2= findViewById(R.id.prueba_respuesta_2);

        respuesta_esc3= findViewById(R.id.prueba_respuesta_3);

        respuesta_esc4= findViewById(R.id.prueba_respuesta_4);

        //ImageView
        //colocar imagenes
        //colocar ayudas
        imagen_aud1=findViewById(R.id.btn_imagen_aud1);
        ayuda_aud1=findViewById(R.id.ayuda_aud1);
        Define=Seleccion_random();
        Elejir_Imagen(Define.imagenAudio,imagen_aud1);
        ayuda_aud1.setText(Define.ayudaAudio.toString());

        imagen_aud2=findViewById(R.id.btn_imagen_aud2);
        ayuda_aud2=findViewById(R.id.ayuda_aud2);
        Define=Seleccion_random();
        Elejir_Imagen(Define.imagenAudio,imagen_aud2);
        ayuda_aud2.setText(Define.ayudaAudio.toString());

        imagen_aud3=findViewById(R.id.btn_imagen_aud3);
        ayuda_aud3=findViewById(R.id.ayuda_aud3);
        Define=Seleccion_random();
        Elejir_Imagen(Define.imagenAudio,imagen_aud3);
        ayuda_aud3.setText(Define.ayudaAudio.toString());

        //TextView
        //Respuesta si es correcto o no
        respuesta_aud1=findViewById(R.id.respuesta_aud1);
        Define=Seleccion_random();
        respuesta_escrita_aud1=Define.respuestaAudio;

        respuesta_aud2=findViewById(R.id.respuesta_aud_2);
        Define=Seleccion_random();
        respuesta_escrita_aud2=Define.respuestaAudio;

        respuesta_aud3=findViewById(R.id.respuesta_aud_3);
        Define=Seleccion_random();
        respuesta_escrita_aud3=Define.respuestaAudio;

        //colocar a las pregunta sus valores
        pregunta_esc1=findViewById(R.id.prueba_escribir_1);
        Define=Seleccion_random();
        pregunta_esc1.setText(Define.Escritura.toString());
        EscritoRespuesta1=Define.respuestaEscritura;

        pregunta_esc2=findViewById(R.id.prueba_escribir_2);
        Define=Seleccion_random();
        pregunta_esc2.setText(Define.Escritura.toString());
        EscritoRespuesta2=Define.respuestaEscritura;

        pregunta_esc3=findViewById(R.id.prueba_escribir_3);
        Define=Seleccion_random();
        pregunta_esc3.setText(Define.Escritura.toString());
        EscritoRespuesta3=Define.respuestaEscritura;

        pregunta_esc4=findViewById(R.id.prueba_escribir_4);
        Define=Seleccion_random();
        pregunta_esc4.setText(Define.Escritura.toString());
        EscritoRespuesta4=Define.respuestaEscritura;

        //Button
        finalizar=findViewById(R.id.finalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calificar_Prueba();
            }
        });
    }

    private PruebasBasico Seleccion_random(){
        try{
            int max=pruebasBasicoList.size();
            int min=0;
            int randomNum = (int)(Math.random()*(max-min+1)+min);
            basico=pruebasBasicoList.get(randomNum);
            //Toast.makeText(this,basico.Audio+" cantidad:"+max, Toast.LENGTH_SHORT).show();
            pruebasBasicoList.remove(randomNum);
            return basico;
        }
        catch (Exception e){
            Seleccion_random();
            return basico;
        }
    }

    private void Elejir_Imagen(int indice, ImageView imagen){
        switch (indice){
            case 0:
                    imagen.setImageResource(R.drawable.imagen2_vocales);
                break;
            case 1:
                    imagen.setImageResource(R.drawable.consonante8);
                break;
            case 2:
                    imagen.setImageResource(R.drawable.nosotros);
                break;
            case 3:
                    imagen.setImageResource(R.drawable.nosotros);
                break;
            case 4:
                imagen.setImageResource(R.drawable.saludos5);
                break;
            case 5:
                imagen.setImageResource(R.drawable.numero11);
                break;
            case 6:
                imagen.setImageResource(R.drawable.numero11);
                break;
            case 7:
                imagen.setImageResource(R.drawable.familia8);
                break;
            case 8:
                imagen.setImageResource(R.drawable.ocupaciones4);
                break;
            case 9:
                imagen.setImageResource(R.drawable.ocupaciones4);
                break;
            case 10:
                imagen.setImageResource(R.drawable.estacion4);
                break;
            case 11:
                imagen.setImageResource(R.drawable.lugares2);
                break;
            case 12:
                imagen.setImageResource(R.drawable.lugares5);
                break;
            case 13:
                imagen.setImageResource(R.drawable.domes10);
                break;
            case 14:
                imagen.setImageResource(R.drawable.color5);
                break;
            case 15:
                imagen.setImageResource(R.drawable.color5);
                break;
            case 16:
                imagen.setImageResource(R.drawable.color5);
                break;
            case 17:
                imagen.setImageResource(R.drawable.cuerpo2);
                break;
            case 18:
                imagen.setImageResource(R.drawable.prenda7);
                break;
        }
    }

    private MediaPlayer Elejir_Sonido(int indice){
        MediaPlayer sonido=MediaPlayer.create(getBaseContext(),R.raw.uta);;
        switch (indice){
            case 0:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.uta);
                break;
            case 1:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.cielo);
                break;
            case 2:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.phisi);
                break;
            case 3:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.saludo1);
                break;
            case 4:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.apachita);
                break;
            case 5:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.phuyu);
                break;
            case 6:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.profesor);
                break;
            case 7:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.saludo2);
                break;
            case 8:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.oracion_nega_s);
                break;
            case 9:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.oracion_posi_s);
                break;
            case 10:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.presentaciones2);
                break;
            case 11:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.elella);
                break;
            case 12:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.ellos);
                break;
            case 13:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.pie);
                break;
            case 14:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.cielo);
                break;
            case 15:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.nosuno);
                break;
            case 16:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.cantante);
                break;
            case 17:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.tixi);
                break;
            case 18:
                sonido=MediaPlayer.create(getBaseContext(),R.raw.uta);
                break;
        }
        return sonido;
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
                    int contcorre=0;
                    switch (verificador_aud){
                        case 0:
                            for(int i=0;i<respuesta_escrita_aud1.size();i++){
                                if(palabra.equals(respuesta_escrita_aud1.get(i))){
                                    contcorre=0;
                                }
                                else {contcorre=1;}
                            }
                            if(contcorre==0){ respuesta_aud1.setText("Correcto");}
                            else {respuesta_aud1.setText("Incorrecto");}
                            break;
                        case 1:
                            for(int i=0;i<respuesta_escrita_aud2.size();i++){
                                if(palabra.equals(respuesta_escrita_aud2.get(i))){
                                    contcorre=0;
                                }
                                else {contcorre=1;}
                            }
                            if(contcorre==0){ respuesta_aud2.setText("Correcto");}
                            else {respuesta_aud2.setText("Incorrecto");}
                            break;
                        case 2:
                            for(int i=0;i<respuesta_escrita_aud3.size();i++){
                                if(palabra.equals(respuesta_escrita_aud3.get(i))){
                                    contcorre=0;
                                }
                                else {contcorre=1;}
                            }
                            if(contcorre==0){ respuesta_aud3.setText("Correcto");}
                            else {respuesta_aud3.setText("Incorrecto");}
                            break;
                    }
                }
                break;
            }
        }
    }

    @Override
    public void onBackPressed (){
        Toast.makeText(this, "Esta en un examen el botton esta bloqueado", Toast.LENGTH_SHORT).show();
    }

    private  void Calificar_Prueba(){
        int NotaFinal=0;
        if(SonidoRespuesta1.equals(respuesta_son1.getText().toString().toLowerCase())){
            NotaFinal+=10;
        }
        if(SonidoRespuesta2.equals(respuesta_son2.getText().toString().toLowerCase())){
            NotaFinal+=10;
        }
        if(SonidoRespuesta3.equals(respuesta_son3.getText().toString().toLowerCase())){
            NotaFinal+=10;
        }
        if(respuesta_aud1.getText()=="Correcto"){
            NotaFinal+=10;
        }
        if(respuesta_aud2.getText()=="Correcto"){
            NotaFinal+=10;
        }
        if(respuesta_aud3.getText()=="Correcto"){
            NotaFinal+=10;
        }
        if(EscritoRespuesta1.equals(respuesta_esc1.getText().toString().toLowerCase())){
            NotaFinal+=10;
        }
        if(EscritoRespuesta2.equals(respuesta_esc2.getText().toString().toLowerCase())){
            NotaFinal+=10;
        }
        if(EscritoRespuesta3.equals(respuesta_esc3.getText().toString().toLowerCase())){
            NotaFinal+=10;
        }
        if(EscritoRespuesta4.equals(respuesta_esc4.getText().toString().toLowerCase())){
            NotaFinal+=10;
        }
        Toast.makeText(this, "nota final: "+NotaFinal, Toast.LENGTH_SHORT).show();
    }
}
