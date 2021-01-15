package com.example.proyectsistem.Models;

import java.util.ArrayList;
import java.util.List;

public class PruebasBasico {

    public int Sonido;
    public String respuestaSonido;
    public int Audio;
    public String ayudaAudio;
    public int imagenAudio;
    public List<String> respuestaAudio;
    public String Escritura;
    public String respuestaEscritura;

    public PruebasBasico(){super();}

    public PruebasBasico(int sonido, String respuestaSonido, int audio, String ayudaAudio, int imagenAudio, List<String> respuestaAudio, String escritura, String respuestaEscritura) {
        this.Sonido = sonido;
        this.respuestaSonido = respuestaSonido;
        this.Audio = audio;
        this.ayudaAudio = ayudaAudio;
        this.imagenAudio = imagenAudio;
        this.respuestaAudio = respuestaAudio;
        this.Escritura = escritura;
        this.respuestaEscritura = respuestaEscritura;
    }

    public static List<PruebasBasico> Crear_Pruebas(){
        List<PruebasBasico> pruebasBasicoList=new ArrayList<PruebasBasico>();
        //vocales
        List<String> vocaleslist= new ArrayList<String>();
        vocaleslist.add("pendiente");
        PruebasBasico vocales=new PruebasBasico(0,"uyu",0,"gato montes",0,vocaleslist,"uru","dia");
        pruebasBasicoList.add(vocales);
        //Consonantes
        List<String> consolist= new ArrayList<String>();
        consolist.add("pendiente");
        PruebasBasico Consonantes=new PruebasBasico(1,"k'uchu",1,"dios de la abundancia ",1,consolist,"kanka","asado");
        pruebasBasicoList.add(Consonantes);
        //Pronombres
        List<String> prolist= new ArrayList<String>();
        prolist.add("pendiente");
        PruebasBasico Pronombres=new PruebasBasico(2,"jumanaka",2,"yo",2,prolist,"nanaka","nosotros");
        pruebasBasicoList.add(Pronombres);
        //Conjugacion
        List<String> conlist= new ArrayList<String>();
        conlist.add("pendiente");
        PruebasBasico Conjugacion=new PruebasBasico(3,"jupax um umi",3,"pluma",3,conlist,"jumanakax janiw t'ant' lurapktanti","ustedes no han hecho pan");
        pruebasBasicoList.add(vocales);
        //saludos
        List<String> salist= new ArrayList<String>();
        salist.add("pendiente");
        PruebasBasico saludos=new PruebasBasico(4,"waliki",4,"asado",4,salist,"aski arukipana","buenos dias");
        pruebasBasicoList.add(saludos);
        //cardinales
        List<String> carlist= new ArrayList<String>();
        carlist.add("pendiente");
        PruebasBasico cardinales=new PruebasBasico(5,"paya",5,"seis",5,carlist,"maya","uno");
        pruebasBasicoList.add(cardinales);
        //ordinales
        List<String> ordlist= new ArrayList<String>();
        ordlist.add("pendiente");
        PruebasBasico ordinales=new PruebasBasico(6,"pusiri",6,"uno",6,ordlist,"kimsiri","tercero");
        pruebasBasicoList.add(ordinales);
        //familia
        List<String> famlist= new ArrayList<String>();
        famlist.add("pendiente");
        PruebasBasico familia=new PruebasBasico(7,"sullka",7,"abuela",7,famlist,"phuchha","hija");
        pruebasBasicoList.add(familia);
        //ocupacion
        List<String> oculist= new ArrayList<String>();
        oculist.add("pendiente");
        PruebasBasico ocupacion=new PruebasBasico(8,"qhuyiri",8,"minero",8,oculist,"anatiri","jugador");
        pruebasBasicoList.add(ocupacion);
        //presentacion
        List<String> preslist= new ArrayList<String>();
        preslist.add("pendiente");
        PruebasBasico presentacion=new PruebasBasico(9,"joelathwa",9,"cocinero",9,preslist,"nayax sutinhaxa anäthwa","mi nombre es ana");
        pruebasBasicoList.add(presentacion);
        //tiempo
        List<String> tiemlist= new ArrayList<String>();
        tiemlist.add("pendiente");
        PruebasBasico tiempo=new PruebasBasico(10,"jallupacha",10,"arco iris",10,tiemlist,"chirau mit'a","invierno");
        pruebasBasicoList.add(tiempo);
        //artificiales
        List<String> artlist= new ArrayList<String>();
        artlist.add("pendiente");
        PruebasBasico artificiales=new PruebasBasico(11,"qhirwa",11,"mina",11,artlist,"k'uchu","rincon");
        pruebasBasicoList.add(artificiales);
        //naturaleza
        List<String> natlist= new ArrayList<String>();
        natlist.add("pendiente");
        PruebasBasico naturaleza=new PruebasBasico(12,"nina",12,"humo",12,natlist,"kurmi","arco iris");
        pruebasBasicoList.add(naturaleza);
        //fauna
        List<String> faulist= new ArrayList<String>();
        faulist.add("pendiente");
        PruebasBasico fauna=new PruebasBasico(13,"challwa",13,"oveja",13,faulist,"wari","vicuña");
        pruebasBasicoList.add(fauna);
        //flora
        List<String> flolist= new ArrayList<String>();
        flolist.add("pendiente");
        PruebasBasico flora=new PruebasBasico(14,"panqara",14,"pasto",14,flolist,"llapa","pasto suave");
        pruebasBasicoList.add(flora);
        //colores
        List<String> collist= new ArrayList<String>();
        collist.add("pendiente");
        PruebasBasico colores=new PruebasBasico(15,"sirira",15,"naranja",15,collist,"larama","azul");
        pruebasBasicoList.add(colores);
        //alimentos
        List<String> alilist= new ArrayList<String>();
        alilist.add("pendiente");
        PruebasBasico alimentos=new PruebasBasico(16,"kanksuta",16,"arroz",16,alilist,"k'anwa","huevo");
        pruebasBasicoList.add(alimentos);
        //cuerpo
        List<String> cuerlist= new ArrayList<String>();
        cuerlist.add("pendiente");
        PruebasBasico cuerpo=new PruebasBasico(17,"chara",17,"boca",17,cuerlist,"para","frente");
        pruebasBasicoList.add(cuerpo);
        //ropa
        List<String> roplist= new ArrayList<String>();
        roplist.add("pendiente");
        PruebasBasico ropa=new PruebasBasico(18,"supu",18,"gorro de lana",18,roplist,"sumiru","sombrero");
        pruebasBasicoList.add(ropa);
        return pruebasBasicoList;
    }
}
