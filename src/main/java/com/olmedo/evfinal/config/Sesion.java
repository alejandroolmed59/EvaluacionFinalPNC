package com.olmedo.evfinal.config;

import com.olmedo.evfinal.domain.Usuario;

public class Sesion {
    private Usuario usuario;
    private static  Sesion miSesion;

    public  static Sesion setSesion(Usuario usuario) {
        miSesion=new Sesion(usuario);
        return miSesion;
    }
    public static Sesion getSesion(){
        return miSesion;
    }

    public Sesion() {
    }

    private Sesion(Usuario usuario){
        this.usuario=usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
