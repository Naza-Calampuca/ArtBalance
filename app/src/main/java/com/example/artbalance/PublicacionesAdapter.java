package com.example.artbalance;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;


class PublicacionesAdapter  extends BaseAdapter {

    ArrayList<Publicacion> publicacions;

    Context context;

    PublicacionesAdapter(Context context, ArrayList<Publicacion> publicacions) {
        this.publicacions = publicacions;
        this.context = context;
    }

    @Override
    public int getCount() {
        return publicacions.size();
    }

    @Override
    public Object getItem(int position) {
        return publicacions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_publicaciones, viewGroup, false);
        }
        Publicacion p = publicacions.get(position);

        ImageView publicacionimagen= (ImageView) view.findViewById(R.id.publicacion);
        TextView Precio= (TextView) view.findViewById(R.id.Precio);
        TextView Descripcion= (TextView) view.findViewById(R.id.Descripcion);
       // TextView Usuario= (TextView) view.findViewById(R.id.);



        Glide.with(context).load(p.getImagen()).into(publicacionimagen);
        Precio.setText(String.valueOf(p.getPrecio()));
        Descripcion.setText(p.getDescripcion());

        //Log.d("Imagen:", p.getImagen());
        return view;
    }
}

