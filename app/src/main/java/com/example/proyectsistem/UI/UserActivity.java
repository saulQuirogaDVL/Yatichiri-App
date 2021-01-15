package com.example.proyectsistem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectsistem.Models.Usuarios;
import com.example.proyectsistem.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserActivity extends AppCompatActivity {

    EditText etNombre, etApellido,etNomUser,etCorreo,etPassword,etConfirmar;
    Button btnRegister,btnhab;
    String usuarior;
    int cont=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        usuarior=getIntent().getStringExtra("usuario");;
        IniciarUI();
        Bloqueo();
        Asignar();
        btnhab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Habilitar();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=etPassword.getText().toString();
                String conf=etConfirmar.getText().toString();
                Usuarios antiguoUser=Usuarios.find(usuarior);

                if(pass.equals(conf)){
                    String nombreN=etNombre.getText().toString();
                    String apellidosN=etApellido.getText().toString();
                    String usuariosN=etNomUser.getText().toString();
                    String correoN=etCorreo.getText().toString();
                    antiguoUser.nombre=nombreN;
                    antiguoUser.apellidos=apellidosN;
                    antiguoUser.usuario=usuariosN;
                    antiguoUser.correo=correoN;
                    antiguoUser.save();
                    Intent intent= new Intent(getBaseContext(),LogueoActivity.class);
                    startActivity(intent);
                    Toast.makeText(UserActivity.this, "datos actualizados", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(UserActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Asignar() {
        Usuarios usuarios=Usuarios.find(usuarior);
        etNombre.setText(usuarios.nombre);
        etApellido.setText(usuarios.apellidos);
        etNomUser.setText(usuarios.usuario);
        etCorreo.setText(usuarios.correo);
        etPassword.setText(usuarios.password);
        etConfirmar.setText("");
    }

    private void Habilitar() {
        etNombre.setEnabled(true);
        etApellido.setEnabled(true);
        etNomUser.setEnabled(true);
        etCorreo.setEnabled(true);
        etPassword.setEnabled(true);
        etConfirmar.setEnabled(true);
        btnRegister.setEnabled(true);
    }

    private void Bloqueo() {
        etNombre.setEnabled(false);
        etApellido.setEnabled(false);
        etNomUser.setEnabled(false);
        etCorreo.setEnabled(false);
        etPassword.setEnabled(false);
        etConfirmar.setEnabled(false);
        btnRegister.setEnabled(false);
    }

    private void IniciarUI() {
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnhab=(Button)findViewById(R.id.btnMod);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etNomUser = (EditText) findViewById(R.id.etUser);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmar = (EditText) findViewById(R.id.etConfirmar);
        //Anio=C.get(Calendar.YEAR);
        //Mes=C.get(Calendar.MONTH);
        //Dia=C.get(Calendar.DAY_OF_MONTH);
    }
}
