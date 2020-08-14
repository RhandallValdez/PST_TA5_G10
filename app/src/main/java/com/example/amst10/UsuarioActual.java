package com.example.amst10;

import java.io.Serializable;

public class UsuarioActual implements Serializable {
    private String nombres,apellidos,celular,correo,categoriaFavorita,nomUsuario;
    private static UsuarioActual user;

    public UsuarioActual(String nombres, String apellidos, String celular, String correo, String categoriaFavorita, String nomUsuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.categoriaFavorita = categoriaFavorita;
        this.nomUsuario = nomUsuario;
    }

    public static void setUser(UsuarioActual user) {
        UsuarioActual.user = user;
    }

    public static UsuarioActual getUser() {
        return user;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCategoriaFavorita() {
        return categoriaFavorita;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }
}
