package com.example.amst10;

public class UsuarioActual {
    private String nombres,apellidos,celular,correo,categoriaFavorita,nomUsuario;

    public UsuarioActual(String nombres, String apellidos, String celular, String correo, String categoriaFavorita, String nomUsuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.categoriaFavorita = categoriaFavorita;
        this.nomUsuario = nomUsuario;
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
