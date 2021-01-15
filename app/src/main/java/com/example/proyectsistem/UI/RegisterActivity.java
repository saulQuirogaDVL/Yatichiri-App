package com.example.proyectsistem.UI;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectsistem.Models.PuntajeBasico;
import com.example.proyectsistem.Models.Usuarios;
import com.example.proyectsistem.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends Activity {

    Date convertido;
    static final  int DATE_ID=0;
    int Anio,Mes,Dia;
    Button btnRegistrarse;
    EditText etNombre,etApellido,etNomUser,etCorreo,etFN,etPassword,etConfirmar;
    Calendar C=Calendar.getInstance();
    Usuarios usuarios;
    PuntajeBasico puntajeBasico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        IniciarUI();
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=etPassword.getText().toString();
                String conf=etConfirmar.getText().toString();
                if(pass.equals(conf)){
                    DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                         convertido = fecha.parse(etFN.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    usuarios=new Usuarios(etNombre.getText().toString(),etApellido.getText().toString(),etNomUser.getText().toString()
                            ,etCorreo.getText().toString(),convertido,etPassword.getText().toString());
                    usuarios.save();
                    for(int i=1;i<22;i++){
                        puntajeBasico= new PuntajeBasico(i,etNomUser.getText().toString(),0);
                        puntajeBasico.save();
                    }
                    Toast.makeText(RegisterActivity.this, "Registrado Correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getBaseContext(),LogueoActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });

        etFN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        showDialog(DATE_ID);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener=
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Anio=year;
                    Mes=month;
                    Dia=dayOfMonth;
                    etFN.setText((Mes+1)+"-"+Dia+"-"+Anio);
                }
            };
    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_ID:
                return new DatePickerDialog(this,onDateSetListener,Anio,Mes,Dia);
        }
        return  null;
    }

    private void IniciarUI() {
        btnRegistrarse=(Button)findViewById(R.id.btnRegister);
        etNombre=(EditText)findViewById(R.id.etNombre);
        etApellido=(EditText)findViewById(R.id.etApellido);
        etNomUser=(EditText)findViewById(R.id.etUser);
        etCorreo=(EditText)findViewById(R.id.etCorreo);
        etFN=(EditText)findViewById(R.id.etFechaNac);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etConfirmar=(EditText)findViewById(R.id.etConfirmar);
        Anio=C.get(Calendar.YEAR);
        Mes=C.get(Calendar.MONTH);
        Dia=C.get(Calendar.DAY_OF_MONTH);
    }
}
