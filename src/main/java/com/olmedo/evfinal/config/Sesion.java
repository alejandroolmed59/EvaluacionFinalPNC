package com.olmedo.evfinal.config;

import com.olmedo.evfinal.domain.Usuario;

public class Sesion {
    private Usuario usuario;
    private static  Sesion miSesion;

    public  static Sesion getSesion(Usuario usuario) {
        if (miSesion==null) {
            miSesion=new Sesion(usuario);
        }
        return miSesion;
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
