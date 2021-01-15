package com.example.proyectsistem.BasicosUI;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proyectsistem.Models.PuntajeBasico;
import com.example.proyectsistem.R;

public class ConsonantesActivity extends AppCompatActivity {

    ImageButton btntixi,btnphisi,btnjupuquc,btnjupuqui,btnpuyu,btnphuyu,btnp_uyu,btntanta,btnthantha,btnt_ant_a;
    ImageButton btnchuru,btnchhuru,btnch_uru,btnkanka,btnkhankha,btnk_ank_a,btnqawa,btnqhawa,btnq_awa;
    public MediaPlayer tixi_aud,phisi_aud,jupuquc_aud,jupuqui_aud,puyu_aud,phuyu_aud,p_uyu_aud,tanta_aud,thantha_aud,t_ant_a_aud;
    public MediaPlayer churu_aud,chhuru_aud,ch_uru_aud,kanka_aud,khankha_aud,k_ank_a_aud,qawa_aud,qhawa_aud,q_awa_aud;
    Button calificar;
    String usuarior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consonantes);

        //Titulo
        this.setTitle("Consonantes");
        //Imagen Icono
        getSupportActionBar().setIcon(R.mipmap.icono);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        usuarior=getIntent().getStringExtra("usuario");;
        setupview();
    }

    private void setupview() {
        //tixi
        btntixi=findViewById(R.id.btn_oracion_posi_s);
        tixi_aud=MediaPlayer.create(this,R.raw.tixi);
        btntixi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tixi_aud.start();
            }
        });
        //phisi
        btnphisi=findViewById(R.id.btn_phisi);
        phisi_aud=MediaPlayer.create(this,R.raw.phisi);
        btnphisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phisi_aud.start();
            }
        });
        //jupuqu correcto
        btnjupuquc=findViewById(R.id.btn_jupuqu_c);
        jupuquc_aud=MediaPlayer.create(this,R.raw.jupuqu_c);
        btnjupuquc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jupuquc_aud.start();
            }
        });
        //jupuqu incorrecto
        btnjupuqui=findViewById(R.id.btn_jupuqu_i);
        jupuqui_aud=MediaPlayer.create(this,R.raw.jupuqu_i);
        btnjupuqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jupuqui_aud.start();
            }
        });
        //puyu
        btnpuyu=findViewById(R.id.btn_puyu);
        puyu_aud=MediaPlayer.create(this,R.raw.puyu);
        btnpuyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puyu_aud.start();
            }
        });
        //phuyu
        btnphuyu=findViewById(R.id.btn_phuyu);
        phuyu_aud=MediaPlayer.create(this,R.raw.phuyu);
        btnphuyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phuyu_aud.start();
            }
        });
        //p'uyu
        btnp_uyu=findViewById(R.id.btn_p_uyu);
        p_uyu_aud=MediaPlayer.create(this,R.raw.p_uyu);
        btnp_uyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_uyu_aud.start();
            }
        });
        //tanta
        btntanta=findViewById(R.id.btn_tanta);
        tanta_aud=MediaPlayer.create(this,R.raw.tanta);
        btntanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tanta_aud.start();
            }
        });
        //thantha
        btnthantha=findViewById(R.id.btn_thantha);
        thantha_aud=MediaPlayer.create(this,R.raw.thantha);
        btnthantha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thantha_aud.start();
            }
        });
        //t'ant'a
        btnt_ant_a=findViewById(R.id.btn_t_ant_a);
        t_ant_a_aud=MediaPlayer.create(this,R.raw.t_ant_a);
        btnt_ant_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_ant_a_aud.start();
            }
        });
        //churu
        btnchuru=findViewById(R.id.btn_churu);
        churu_aud=MediaPlayer.create(this,R.raw.churu);
        btnchuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                churu_aud.start();
            }
        });
        //chhuru
        btnchhuru=findViewById(R.id.btn_chhuru);
        chhuru_aud=MediaPlayer.create(this,R.raw.chhuru);
        btnchhuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chhuru_aud.start();
            }
        });
        //ch'uru
        btnch_uru=findViewById(R.id.btn_ch_uru);
        ch_uru_aud=MediaPlayer.create(this,R.raw.ch_uru);
        btnch_uru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch_uru_aud.start();
            }
        });
        //kanka
        btnkanka=findViewById(R.id.btn_kanka);
        kanka_aud=MediaPlayer.create(this,R.raw.kanka);
        btnkanka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kanka_aud.start();
            }
        });
        //khankha
        btnkhankha=findViewById(R.id.btn_khankha);
        khankha_aud=MediaPlayer.create(this,R.raw.khankha);
        btnkhankha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khankha_aud.start();
            }
        });
        //k'ank'a
        btnk_ank_a=findViewById(R.id.btn_k_ank_a);
        k_ank_a_aud=MediaPlayer.create(this,R.raw.k_ank_a);
        btnk_ank_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k_ank_a_aud.start();
            }
        });
        //qawa
        btnqawa=findViewById(R.id.btn_qawa);
        qawa_aud=MediaPlayer.create(this,R.raw.qawa);
        btnqawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qawa_aud.start();
            }
        });
        //qhawa
        btnqhawa=findViewById(R.id.btn_qhawa);
        qhawa_aud=MediaPlayer.create(this,R.raw.qhawa);
        btnqhawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qhawa_aud.start();
            }
        });
        //q'awa
        btnq_awa=findViewById(R.id.btn_q_awa);
        q_awa_aud=MediaPlayer.create(this,R.raw.q_awa);
        btnq_awa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q_awa_aud.start();
            }
        });
        //calificacion Consonantes
        calificar=findViewById(R.id.calificar);
        calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConsonantesActivity.this, "Tema concluido con exito, Nuevo Tema desbloqueado", Toast.LENGTH_SHORT).show();
                PuntajeBasico puntajeBasico= PuntajeBasico.findxUser(usuarior,3);
                puntajeBasico.Puntaje=100;
                puntajeBasico.save();
            }
        });
    }
}
