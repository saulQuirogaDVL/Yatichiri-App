package com.example.proyectsistem.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "PuntajeBasico")
public class PuntajeBasico  extends Model{
    @Column(name = "Nivel")
    public int Nivel;
    @Column(name = "Usuarios")
    public String Usuarios;
    @Column(name = "Puntaje")
    public int Puntaje;

    public PuntajeBasico(){super();}

    public PuntajeBasico(int Nivel, String Usuarios, int Puntaje) {
        super();
        this.Nivel = Nivel;
        this.Usuarios = Usuarios;
        this.Puntaje = Puntaje;
    }

    public static  PuntajeBasico findxUser(String usuarios, int nivel){
        return new Select()
                .from(PuntajeBasico.class)
                .where("Usuarios=?",usuarios)
                .where("Nivel=?",nivel)
                .executeSingle();
    }

}
