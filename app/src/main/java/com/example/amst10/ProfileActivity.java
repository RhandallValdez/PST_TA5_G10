package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView edNombre,edApellido,edCelular,edCorreo,edCategoria,edUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edNombre = findViewById(R.id.mostrarNombre);
        edApellido = findViewById(R.id.mostrarApellido);
        edCelular = findViewById(R.id.mostrarCelular);
        edCorreo = findViewById(R.id.mostrarCorreo);
        edCategoria = findViewById(R.id.mostrarFavorito);
        edUsuario = findViewById(R.id.mostrarNombreUsuario);

        edNombre.setText(UsuarioActual.getUser().getNombres());
        edApellido.setText(UsuarioActual.getUser().getApellidos());
        edCelular.setText(UsuarioActual.getUser().getCelular());
        edCorreo.setText(UsuarioActual.getUser().getCorreo());
        edCategoria.setText(UsuarioActual.getUser().getCategoriaFavorita());
        edUsuario.setText(UsuarioActual.getUser().getNomUsuario());
    }
}