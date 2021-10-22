package com.example.artbalance;

public class Publicacion {
    String Descripcion;
    String Imagen;
    int Precio;
    String Usuario;
    String Informacion;
    String Tags;


    public String getDescripcion() {
        return Descripcion;
    } //NOMBRE DE LA IMAGEN

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public String getUsuario() {
        return Usuario;
    }  //MAIL DEL USUARIO

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getInformacion() {
        return Informacion;
    } //DESCRIPCION DE LA IMAGEN

    public void setInformacion(String informacion) {
        Informacion = informacion;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }



}