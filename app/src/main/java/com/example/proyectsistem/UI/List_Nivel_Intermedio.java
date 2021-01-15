package com.example.proyectsistem.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.activeandroid.ActiveAndroid;
import com.example.proyectsistem.Adapters.nivelesIntAdapter;
import com.example.proyectsistem.Adapters.nivelesbAdapter;
import com.example.proyectsistem.InterUI.AdjetivosActvity;
import com.example.proyectsistem.InterUI.CompuestasActvity;
import com.example.proyectsistem.InterUI.DemostrativosActvity;
import com.example.proyectsistem.InterUI.DialogosActvity;
import com.example.proyectsistem.InterUI.InfinitivosActvity;
import com.example.proyectsistem.InterUI.InterrogativosActvity;
import com.example.proyectsistem.InterUI.PosesivosActvity;
import com.example.proyectsistem.InterUI.PruebaIActivity;
import com.example.proyectsistem.InterUI.SufijosActivity;
import com.example.proyectsistem.InterUI.VerbalesActvity;
import com.example.proyectsistem.Models.NivelIntermedio;
import com.example.proyectsistem.R;

import java.util.List;

public class List_Nivel_Intermedio extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView lvNivelesI;
    List<NivelIntermedio>nivelIntermedioList;
    private nivelesIntAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__nivel__intermedio);
        this.setTitle("Intermedio");
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActiveAndroid.initialize(this);
        IniciarUI();
        showNivelesIntList();
    }

    private void showNivelesIntList() {
        nivelIntermedioList=NivelIntermedio.getAllNivelesIntermedio();
        adapter=new nivelesIntAdapter(this,nivelIntermedioList,R.layout.list_item_intermedio);
        lvNivelesI.setAdapter(adapter);
        updateNivelesIntList();
    }
    private void  updateNivelesIntList() {
        adapter.notifyDataSetChanged();
    }

    private void IniciarUI() {
        lvNivelesI=(ListView)findViewById(R.id.lv_NivelesI);
        lvNivelesI.setOnItemClickListener(this);
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
            case 4:
                intent = new Intent(this, AdjetivosActvity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, PosesivosActvity.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, InfinitivosActvity.class);
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, VerbalesActvity.class);
                startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, DialogosActvity.class);
                startActivity(intent);
                break;
            case 9:
                intent = new Intent(this, PruebaIActivity.class);
                startActivity(intent);
                break;
        }

    }
}
