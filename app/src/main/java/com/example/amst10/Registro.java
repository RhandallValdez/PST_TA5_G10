package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class Registro extends AppCompatActivity {
    private EditText edNombre,edApellido,edCorreo,edCelular,edUsuario,edContraseña;
    private Spinner edcategoria;
    private String register = "https://lab6-guzman.000webhostapp.com/registro.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edNombre = findViewById(R.id.nombre);
        edApellido = findViewById(R.id.apellido);
        edCorreo = findViewById(R.id.correo);
        edCelular = findViewById(R.id.celular);
        edUsuario = findViewById(R.id.usuario);
        edContraseña = findViewById(R.id.contrasena);
        edcategoria = findViewById(R.id.categoria);
    }

    public void registrarse(View v){
        String nombre = edNombre.getText().toString();
        String apellido = edApellido.getText().toString();
        String correo = edCorreo.getText().toString();
        String celular = edCelular.getText().toString();
        String categoria = edcategoria.getSelectedItem().toString();
        String usuario = edUsuario.getText().toString();
        String contrasena = edContraseña.getText().toString();
        String[] datos = new String[]{
                "registrar",
                register,
                nombre,
                apellido,
                correo,
                celular,
                categoria,
                usuario,
                contrasena
        };
        AsyncQuery async = new AsyncQuery();
        async.execute(datos);
        finish();
    }
}