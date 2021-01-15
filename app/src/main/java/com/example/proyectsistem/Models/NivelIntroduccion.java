package com.example.proyectsistem.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

@Table(name="Nivel_Introduccion")
public class NivelIntroduccion extends Model {

    @Column(name = "Titulo")
    public String Titulo;
    @Column(name = "Descripcion")
    public String Descripcion;
    @Column(name = "Imagen")
    public int Imagen;

    public NivelIntroduccion(){super();}

    public NivelIntroduccion(String Titulo, String Descripcion, int Imagen){
        super();
        this.Titulo=Titulo;
        this.Descripcion=Descripcion;
        this.Imagen=Imagen;
    }

    public static List<NivelIntroduccion> getAllNivelesIntroduccion(){
        List<NivelIntroduccion> nivelIntroduccionList = new ArrayList<NivelIntroduccion>();
        NivelIntroduccion nivel1=new NivelIntroduccion("Historia","aqui va la historia",1);
        nivelIntroduccionList.add(nivel1);
        NivelIntroduccion nivel2=new NivelIntroduccion("Tipologia","aqui van las tipologias",2);
        nivelIntroduccionList.add(nivel2);
        NivelIntroduccion nivel3=new NivelIntroduccion("Generalidades","aqui van las Generalidades",3);
        nivelIntroduccionList.add(nivel3);
        NivelIntroduccion nivel4=new NivelIntroduccion("Cuadro Fonetico","aqui va el cuadro fonetico",4);
        nivelIntroduccionList.add(nivel4);


        return  nivelIntroduccionList;
    }

    public static NivelIntroduccion find(String Titulo){
        return new Select()
                .from(NivelIntroduccion.class)
                .where("Titulo=?",Titulo)
                .executeSingle();
    }
}
