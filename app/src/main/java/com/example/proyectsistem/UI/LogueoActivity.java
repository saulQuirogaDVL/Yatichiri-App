package com.example.proyectsistem.UI;

//import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectsistem.Models.PuntajeBasico;
import com.example.proyectsistem.Models.Usuarios;
import com.example.proyectsistem.R;

public class LogueoActivity extends Activity {

    Button btnIniciar;
    EditText etPass,etUser;
    TextView etRegistro;
    Boolean bolValidador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);
        //solo Vertical
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        iniciarUI();
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bolValidador=Usuarios.Validar_Usuarios(etUser.getText().toString(),etPass.getText().toString());
                if(bolValidador)
                {
                    Intent intent= new Intent(getBaseContext(),MainActivity.class);
                    intent.putExtra("usuario",etUser.getText().toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LogueoActivity.this, "no logeado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        etRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarUI() {
        btnIniciar=(Button)findViewById(R.id.btnIniciar);
        etPass=(EditText)findViewById(R.id.etPassword);
        etUser=(EditText)findViewById(R.id.etNombre);
        etRegistro=(TextView) findViewById(R.id.txtRegistro);
    }
}