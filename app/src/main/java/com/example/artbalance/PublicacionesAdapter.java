package com.example.artbalance;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView titulo=(TextView) view.findViewById(R.id.TextInfo1);
        TextView Precio= (TextView) view.findViewById(R.id.Precio);
        TextView Descripcion= (TextView) view.findViewById(R.id.Descripcion);
        TextView Usuario= (TextView) view.findViewById(R.id.Usuario);
        TextView Informacion= (TextView) view.findViewById(R.id.Informacion);
        TextView Tags= (TextView) view.findViewById(R.id.Tags);



        Glide.with(context).load(p.getImagen()).into(publicacionimagen);
        Precio.setText(String.valueOf(p.getPrecio()));
        Descripcion.setText(p.getDescripcion());
        Usuario.setText(p.getUsuario());
        Informacion.setText(p.getInformacion());
        Tags.setText(p.getTags());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), PublicacionAntesComprar.class);
                intent.putExtra("informacion",Informacion.getText().toString());
                intent.putExtra("precio", Precio.getText().toString());
                intent.putExtra("Descripcion", Descripcion.getText().toString());
                intent.putExtra("tags", Tags.getText().toString());
                intent.putExtra("imagen", p.getImagen());



                context.startActivity(intent);
            }
        });

        //Log.d("Imagen:", p.getImagen());
        return view;
    }
}
