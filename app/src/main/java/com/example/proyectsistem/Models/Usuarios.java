package com.example.proyectsistem.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.Date;

@Table(name="Users")
public class Usuarios extends Model {
    @Column(name = "nombre")
    public String nombre;
    @Column(name = "apellidos")
    public String apellidos;
    @Column(name = "usuario")
    public String usuario;
    @Column(name = "correo")
    public String correo;
    @Column(name = "fecha_nac")
    public Date fecha_nac;
    @Column (name = "password")
    public String password;

    public Usuarios(){super();}

    public Usuarios(String nombre, String apellidos, String usuario, String correo,Date fecha_nac, String password) {
        super();
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.usuario = usuario;
        this.correo=correo;
        this.fecha_nac=fecha_nac;
        this.password = password;
    }

    public static Usuarios find(String usuario){
        return new Select()
                .from(Usuarios.class)
                .where("usuario=?",usuario)
                .executeSingle();
    }


    public static boolean Validar_Usuarios(String usuario,String password){
        Usuarios usuarios =new Select()
                .from(Usuarios.class)
                .where("usuario=?",usuario)
                .where("password=?",password)
                .executeSingle();
        if(usuarios!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
