package com.example.proyectsistem.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

@Table(name="Nivel_Basico")
public class NivelBasico extends Model {

    @Column(name = "Titulo")
    public String Titulo;
    @Column(name = "NumeroTema")
    public int NumeroTema;
    @Column(name = "Descripcion")
    public String Descripcion;
    @Column(name = "Imagen")
    public int Imagen;

    public NivelBasico(){super();}

    public NivelBasico(String Titulo,int NumeroTema,String Descripcion,int Imagen){
        super();
        this.Titulo=Titulo;
        this.NumeroTema=NumeroTema;
        this.Descripcion=Descripcion;
        this.Imagen=Imagen;
    }

    public static List<NivelBasico> getAllNivelesBasico(){
        List<NivelBasico> nivelBasicoList = new ArrayList<NivelBasico>();
        NivelBasico nivel1=new NivelBasico("Vocales",1,"En este modulo el usuario aprendera las vocales en el idioma Aymara",1);
        nivelBasicoList.add(nivel1);
        NivelBasico nivel2=new NivelBasico("Consonantes",2,"En este modulo el usuario aprendera las consonantes en el idioma aymara ",2);
        nivelBasicoList.add(nivel2);
        NivelBasico nivel3=new NivelBasico("Pronombres Personales",3,"aqui van los pronombres personales",3);
        nivelBasicoList.add(nivel3);
        NivelBasico nivel4=new NivelBasico("Conjugacion de los verbos",4,"aqui van las conjugaciones",4);
        nivelBasicoList.add(nivel4);
        NivelBasico nivel5=new NivelBasico("Saludos y Despedidas",5,"aqui van los saludos ",5);
        nivelBasicoList.add(nivel5);
        NivelBasico nivel6=new NivelBasico("Numeros Cardinales",6,"aqui van los numeros cardinales",6);
        nivelBasicoList.add(nivel6);
        NivelBasico nivel7=new NivelBasico("Numeros Ordinales",7,"aqui van los numeros ordinales",7);
        nivelBasicoList.add(nivel7);
        NivelBasico nivel8=new NivelBasico("Familia",8,"aqui van la familia",8);
        nivelBasicoList.add(nivel8);
        NivelBasico nivel9=new NivelBasico("Profecion u Ocupacion",9,"aqui van los pronombres personales",9);
        nivelBasicoList.add(nivel9);
        NivelBasico nivel10=new NivelBasico("Presentaciones",10,"aqui van los pronombres personales",10);
        nivelBasicoList.add(nivel10);
        NivelBasico nivel11=new NivelBasico("Tiempo",11,"aqui van los pronombres personales",11);
        nivelBasicoList.add(nivel11);
        NivelBasico nivel12=new NivelBasico("Lugares y Artificiales",12,"aqui van los pronombres personales",12);
        nivelBasicoList.add(nivel12);
        NivelBasico nivel13=new NivelBasico("Elementos de la Naturaleza",13,"aqui van los pronombres personales",13);
        nivelBasicoList.add(nivel13);
        NivelBasico nivel14=new NivelBasico("Fauna",14,"aqui van los pronombres personales",14);
        nivelBasicoList.add(nivel14);
        NivelBasico nivel15=new NivelBasico("Flora",15,"aqui van los pronombres personales",15);
        nivelBasicoList.add(nivel15);
        NivelBasico nivel16=new NivelBasico("Colores",16,"aqui van los pronombres personales",16);
        nivelBasicoList.add(nivel16);
        NivelBasico nivel17=new NivelBasico("alimentos",17,"aqui van los pronombres personales",17);
        nivelBasicoList.add(nivel17);
        NivelBasico nivel18=new NivelBasico("Cuerpo Humano",18,"aqui van los pronombres personales",18);
        nivelBasicoList.add(nivel18);
        NivelBasico nivel19=new NivelBasico("Ropa",19,"aqui van los pronombres personales",19);
        nivelBasicoList.add(nivel19);
        NivelBasico nivelprueba=new NivelBasico("Prueba de habilidades-Nivel Basico",20,"aqui van los pronombres personales",20);
        nivelBasicoList.add(nivelprueba);
        return  nivelBasicoList;
    }

    public static NivelBasico find(String Titulo){
        return new Select()
                .from(NivelBasico.class)
                .where("Titulo=?",Titulo)
                .executeSingle();
    }
}
