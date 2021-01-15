package com.example.proyectsistem.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

@Table(name="Nivel_Intermedio")
public class NivelIntermedio extends Model {

    @Column(name = "Titulo")
    public String Titulo;
    @Column(name = "NumeroTema")
    public int NumeroTema;
    @Column(name = "Descripcion")
    public String Descripcion;
    @Column(name = "Imagen")
    public int Imagen;

    public NivelIntermedio(){super();}

    public NivelIntermedio(String Titulo, int NumeroTema, String Descripcion, int Imagen){
        super();
        this.Titulo=Titulo;
        this.NumeroTema=NumeroTema;
        this.Descripcion=Descripcion;
        this.Imagen=Imagen;
    }

    public static List<NivelIntermedio> getAllNivelesIntermedio(){
        List<NivelIntermedio> nivelIntermedioList = new ArrayList<NivelIntermedio>();
        NivelIntermedio nivel1=new NivelIntermedio("Pronombres Demostrativos",1,"aqui van los pronombres demostrativos",1);
        nivelIntermedioList.add(nivel1);
        NivelIntermedio nivel2=new NivelIntermedio("Pronombres Interrogativos",2,"aqui van las Pronombres Interrogativos",2);
        nivelIntermedioList.add(nivel2);
        NivelIntermedio nivel3=new NivelIntermedio("Sufijos",3,"aqui van los sufijos ",3);
        nivelIntermedioList.add(nivel3);
        NivelIntermedio nivel4=new NivelIntermedio("Palabras Compuestas",4,"aqui van las Palabras Compuestas",4);
        nivelIntermedioList.add(nivel4);
        NivelIntermedio nivel5=new NivelIntermedio("Adjetivos",5,"aqui van los adjetivos",5);
        nivelIntermedioList.add(nivel5);
        NivelIntermedio nivel6=new NivelIntermedio("Sufijos Posesivos",6,"aqui van los Sufijos Posesivos",6);
        nivelIntermedioList.add(nivel6);
        NivelIntermedio nivel7=new NivelIntermedio("Verbos Infinitivos",7,"aqui van los verbos Infinitivos",7);
        nivelIntermedioList.add(nivel7);
        NivelIntermedio nivel8=new NivelIntermedio("Desinencias o Sufijos Verbales",8,"aqui van las desinencias",8);
        nivelIntermedioList.add(nivel8);
        NivelIntermedio nivel9=new NivelIntermedio("Dialogos",9,"aqui van los dialogos",9);
        nivelIntermedioList.add(nivel9);
        NivelIntermedio nivel10=new NivelIntermedio("Prueba de Conocimiento-Nivel Intermedio",10,"aqui van los dialogos",10);
        nivelIntermedioList.add(nivel10);

        return  nivelIntermedioList;
    }

    public static NivelIntermedio find(String Titulo){
        return new Select()
                .from(NivelIntermedio.class)
                .where("Titulo=?",Titulo)
                .executeSingle();
    }
}
