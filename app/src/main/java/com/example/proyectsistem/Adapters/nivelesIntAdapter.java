package com.example.proyectsistem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectsistem.Models.NivelIntermedio;
import com.example.proyectsistem.R;

import java.util.List;

public class nivelesIntAdapter extends BaseAdapter {

    private Context context;
    private List<NivelIntermedio> list;
    private int layout;

    public nivelesIntAdapter(Context context, List<NivelIntermedio>list, int layout){
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
            vh.tema=(TextView)convertView.findViewById(R.id.txt_Nom);
            vh.numero=(TextView)convertView.findViewById(R.id.txt_Unidad);
            vh.descripcion=(TextView)convertView.findViewById(R.id.txt_Des);
            convertView.setTag(vh);
        }else {
            vh=(ViewHolder)convertView.getTag();
        }
        NivelIntermedio nivelIntermedio=list.get(position);
        int id=nivelIntermedio.Imagen;
        switch (id){
            case 1:
                vh.imagen.setImageResource(R.drawable.demostrativos);
                break;
            case 2:
                vh.imagen.setImageResource(R.drawable.interrogativo);
                break;
            case 3:
                vh.imagen.setImageResource(R.drawable.sufijos);
                break;
            case 4:
                vh.imagen.setImageResource(R.drawable.compuestas);
                break;
            case 5:
                vh.imagen.setImageResource(R.drawable.adjetivos);
                break;
            case 6:
                vh.imagen.setImageResource(R.drawable.posesivo);
                break;
            case 7:
                vh.imagen.setImageResource(R.drawable.infinitivo);
                break;
            case 8:
                vh.imagen.setImageResource(R.drawable.faltan);
                break;
            case 9:
                vh.imagen.setImageResource(R.drawable.dialogo);
                break;
            case 10:
                vh.imagen.setImageResource(R.drawable.facil);
                break;
        }

        vh.numero.setText(Integer.toString(nivelIntermedio.NumeroTema));
        vh.tema.setText(nivelIntermedio.Titulo);
        vh.descripcion.setText(nivelIntermedio.Descripcion);
        return convertView;
    }
}
