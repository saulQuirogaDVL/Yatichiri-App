package com.example.proyectsistem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.proyectsistem.Models.NivelIntroduccion;
import com.example.proyectsistem.R;

import java.util.List;

public class nivelesIntrodAdapter extends BaseAdapter {

    private Context context;
    private List<NivelIntroduccion> list;
    private int layout;

    public nivelesIntrodAdapter(Context context, List<NivelIntroduccion>list, int layout){
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
        TextView descripcion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        nivelesIntrodAdapter.ViewHolder vh;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(layout,null);
            vh=new nivelesIntrodAdapter.ViewHolder();
            vh.imagen=(ImageView)convertView.findViewById(R.id.imageIntro);
            vh.tema=(TextView)convertView.findViewById(R.id.txt_NomIntro);
            vh.descripcion=(TextView)convertView.findViewById(R.id.txt_DescIntro);
            convertView.setTag(vh);
        }else {
            vh=(nivelesIntrodAdapter.ViewHolder)convertView.getTag();
        }
        NivelIntroduccion nivelIntroduccion=list.get(position);
        int id=nivelIntroduccion.Imagen;
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

        }

        vh.tema.setText(nivelIntroduccion.Titulo);
        vh.descripcion.setText(nivelIntroduccion.Descripcion);
        return convertView;
    }
}
