package com.example.proyectsistem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectsistem.Models.NivelBasico;
import com.example.proyectsistem.R;

import java.util.List;

public class nivelesbAdapter extends BaseAdapter {

    private Context context;
    private List<NivelBasico> list;
    private int layout;

    public nivelesbAdapter(Context context,List<NivelBasico>list, int layout){
        this.context=context;
        this.list=list;
        this.layout=layout;
    }

    @Override
    public int getCount() { return list.size(); }

    @Override
    public Object getItem(int position) { return list.get(position); }

    @Override
    public long getItemId(int id) { return id; }

    public class ViewHolder{
        ImageView imagen;
        TextView tema;
        TextView numero;
        TextView descripcion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(layout,null);
            vh=new ViewHolder();
            vh.imagen=(ImageView)convertView.findViewById(R.id.imageView5);
            vh.tema=(TextView)convertView.findViewById(R.id.txt_Titulo);
            vh.numero=(TextView)convertView.findViewById(R.id.txt_numero);
            vh.descripcion=(TextView)convertView.findViewById(R.id.txt_Des);
            convertView.setTag(vh);
        }else {
            vh=(ViewHolder)convertView.getTag();
        }
        NivelBasico nivelBasico=list.get(position);
        int id=nivelBasico.Imagen;
        switch (id){
            case 1:
                vh.imagen.setImageResource(R.drawable.vocales);
                break;
            case 2:
                vh.imagen.setImageResource(R.drawable.consoantes);
                break;
            case 3:
                vh.imagen.setImageResource(R.drawable.pronpersonal);
                break;
            case 4:
                vh.imagen.setImageResource(R.drawable.conjugacion);
                break;
            case 5:
                vh.imagen.setImageResource(R.drawable.saludos);
                break;
            case 6:
                vh.imagen.setImageResource(R.drawable.numeros);
                break;
            case 7:
                vh.imagen.setImageResource(R.drawable.ordinales);
                break;
            case 8:
                vh.imagen.setImageResource(R.drawable.familia);
                break;
            case 9:
                vh.imagen.setImageResource(R.drawable.profesion);
                break;
            case 10:
                vh.imagen.setImageResource(R.drawable.presentaciones);
                break;
            case 11:
                vh.imagen.setImageResource(R.drawable.tiempo);
                break;
            case 12:
                vh.imagen.setImageResource(R.drawable.lugares);
                break;
            case 13:
                vh.imagen.setImageResource(R.drawable.naturaleza);
                break;
            case 14:
                vh.imagen.setImageResource(R.drawable.animales);
                break;
            case 15:
                vh.imagen.setImageResource(R.drawable.flora);
                break;
            case 16:
                vh.imagen.setImageResource(R.drawable.colores);
                break;
            case 17:
                vh.imagen.setImageResource(R.drawable.alimentos);
                break;
            case 18:
                vh.imagen.setImageResource(R.drawable.cuerpo);
                break;
            case 19:
                vh.imagen.setImageResource(R.drawable.ropa);
                break;
            case 20:
                vh.imagen.setImageResource(R.drawable.facil);
                break;
        }

        vh.numero.setText(Integer.toString(nivelBasico.NumeroTema));
        vh.tema.setText(nivelBasico.Titulo);
        vh.descripcion.setText(nivelBasico.Descripcion);
        return convertView;
    }
}
