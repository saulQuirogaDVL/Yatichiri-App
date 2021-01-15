package com.example.proyectsistem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.activeandroid.ActiveAndroid;
import com.example.proyectsistem.Adapters.nivelesIntrodAdapter;
import com.example.proyectsistem.InterUI.AdjetivosActvity;
import com.example.proyectsistem.InterUI.CompuestasActvity;
import com.example.proyectsistem.InterUI.DemostrativosActvity;
import com.example.proyectsistem.InterUI.InterrogativosActvity;
import com.example.proyectsistem.InterUI.SufijosActivity;
import com.example.proyectsistem.Models.NivelIntroduccion;
import com.example.proyectsistem.R;

import java.util.List;

public class List_Nivel_Introduccion extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView lvNivelesIntro;
    List<NivelIntroduccion>nivelIntroduccionList;
    private nivelesIntrodAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nivel_introduccion);
        this.setTitle("Introduccion");
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActiveAndroid.initialize(this);
        IniciarUI();
        showNivelesIntrodList();
    }

    private void showNivelesIntrodList() {
        nivelIntroduccionList=NivelIntroduccion.getAllNivelesIntroduccion();
        adapter=new nivelesIntrodAdapter(this,nivelIntroduccionList,R.layout.list_item_introduccion);
        lvNivelesIntro.setAdapter(adapter);
        updateNivelesIntrodList();
    }
    private void  updateNivelesIntrodList() {
        adapter.notifyDataSetChanged();
    }

    private void IniciarUI() {
        lvNivelesIntro=(ListView)findViewById(R.id.lv_NivelesIntro);
        lvNivelesIntro.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent;
        switch (position){
            case 0:
                intent = new Intent(this, DemostrativosActvity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, InterrogativosActvity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SufijosActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, CompuestasActvity.class);
                startActivity(intent);
                break;
        }
    }
}