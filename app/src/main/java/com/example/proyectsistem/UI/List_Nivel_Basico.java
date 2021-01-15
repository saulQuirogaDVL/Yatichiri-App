package com.example.proyectsistem.UI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.example.proyectsistem.Adapters.nivelesbAdapter;
import com.example.proyectsistem.BasicosUI.AlimentosActivity;
import com.example.proyectsistem.BasicosUI.ArbolActivity;
import com.example.proyectsistem.BasicosUI.ArtificialesActivity;
import com.example.proyectsistem.BasicosUI.CardinalesActivity;
import com.example.proyectsistem.BasicosUI.CarnesActivity;
import com.example.proyectsistem.BasicosUI.ColoresActivity;
import com.example.proyectsistem.BasicosUI.ConjugacionActivity;
import com.example.proyectsistem.BasicosUI.ConsonantesActivity;
import com.example.proyectsistem.BasicosUI.CuerpoActivity;
import com.example.proyectsistem.BasicosUI.DomesticoActivity;
import com.example.proyectsistem.BasicosUI.ElementosActivity;
import com.example.proyectsistem.BasicosUI.EstacionesActivity;
import com.example.proyectsistem.BasicosUI.FamiliaActivity;
import com.example.proyectsistem.BasicosUI.FaunaActivity;
import com.example.proyectsistem.BasicosUI.FloraActivity;
import com.example.proyectsistem.BasicosUI.NaturalezaActivity;
import com.example.proyectsistem.BasicosUI.PruebaBActivity;
import com.example.proyectsistem.BasicosUI.VocalesActivity;
import com.example.proyectsistem.Models.NivelBasico;
import com.example.proyectsistem.BasicosUI.OcupacionActivity;
import com.example.proyectsistem.BasicosUI.OrdinalesActivity;
import com.example.proyectsistem.BasicosUI.PresentacionesActivity;
import com.example.proyectsistem.BasicosUI.PronombresActivity;
import com.example.proyectsistem.Models.PuntajeBasico;
import com.example.proyectsistem.Models.Usuarios;
import com.example.proyectsistem.R;
import com.example.proyectsistem.BasicosUI.RopaActivity;
import com.example.proyectsistem.BasicosUI.SaludosActivity;
import com.example.proyectsistem.BasicosUI.TiempoActivity;

import java.util.List;

public class List_Nivel_Basico extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView lvNivelesB;
    List<NivelBasico>nivelBasicoList;
    private nivelesbAdapter adapter;
    String usuarior;
    PuntajeBasico puntajeBasico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__nivel__basico);
        this.setTitle(R.string.basico);
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActiveAndroid.initialize(this);
        usuarior=getIntent().getStringExtra("usuario");;
        IniciarUI();
        showNivelesBList();
    }

    private void showNivelesBList() {
        nivelBasicoList= NivelBasico.getAllNivelesBasico();
        adapter=new nivelesbAdapter(this,nivelBasicoList,R.layout.list_item_basico);
        lvNivelesB.setAdapter(adapter);
        updateNivelesBList();
    }
    private void  updateNivelesBList() {
        adapter.notifyDataSetChanged();
    }

    private void IniciarUI() {
        lvNivelesB=(ListView)findViewById(R.id.lv_NivelesB);
        lvNivelesB.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(this, VocalesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,1);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                intent = new Intent(this, ConsonantesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,2);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                intent = new Intent(this, PronombresActivity.class);
                 puntajeBasico = PuntajeBasico.findxUser(usuarior,3);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                intent = new Intent(this, ConjugacionActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,4);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                intent = new Intent(this, SaludosActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,5);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                intent = new Intent(this, CardinalesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,6);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 6:
                intent = new Intent(this, OrdinalesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,7);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 7:
                intent = new Intent(this, FamiliaActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,8);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 8:
                intent = new Intent(this, OcupacionActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,9);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 9:
                intent = new Intent(this, PresentacionesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,10);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 10:
                intent = new Intent(this, EstacionesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,11);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 11:
                intent = new Intent(this, ArtificialesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,12);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 12:
                intent = new Intent(this, NaturalezaActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,13);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 13:
                intent = new Intent(this, DomesticoActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,14);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 14:
                intent = new Intent(this, ArbolActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,15);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 15:
                intent = new Intent(this, ColoresActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,16);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 16:
                intent = new Intent(this, CarnesActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,17);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 17:
                intent = new Intent(this, CuerpoActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,18);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 18:
                intent = new Intent(this, RopaActivity.class);
                puntajeBasico = PuntajeBasico.findxUser(usuarior,19);
                if(puntajeBasico.Puntaje==100){
                    intent.putExtra("usuario",usuarior);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 19:
                    mostrarDialogo();
                break;
        }
    }
    private void mostrarDialogo() {
        new AlertDialog.Builder(this)
                .setTitle("Inicio Prueba:")
                .setMessage("Desea Iniciar La Prueba De Nivel Basico?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getBaseContext(), PruebaBActivity.class);
                        puntajeBasico = PuntajeBasico.findxUser(usuarior,20);
                        if(puntajeBasico.Puntaje==100){
                            intent.putExtra("usuario",usuarior);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getBaseContext(),"no cuenta con el puntaje requerido para pasar al siguiente tema!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("mensaje","");
                    }
                })
                .show();
    }
}
