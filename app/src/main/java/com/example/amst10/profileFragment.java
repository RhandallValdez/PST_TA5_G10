package com.example.amst10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class profileFragment extends Fragment {

    private TextView edNombre,edApellido,edCelular,edCorreo,edCategoria,edUsuario;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile,container,false);
        TextView edNombre,edApellido,edCelular,edCorreo,edCategoria,edUsuario;

        edNombre = v.findViewById(R.id.mostrarNombre);
        edApellido = v.findViewById(R.id.mostrarApellido);
        edCelular = v.findViewById(R.id.mostrarCelular);
        edCorreo = v.findViewById(R.id.mostrarCorreo);
        edCategoria = v.findViewById(R.id.mostrarFavorito);
        edUsuario = v.findViewById(R.id.mostrarNombreUsuario);

        edNombre.setText(UsuarioActual.getUser().getNombres());
        edApellido.setText(UsuarioActual.getUser().getApellidos());
        edCelular.setText(UsuarioActual.getUser().getCelular());
        edCorreo.setText(UsuarioActual.getUser().getCorreo());
        edCategoria.setText(UsuarioActual.getUser().getCategoriaFavorita());
        edUsuario.setText(UsuarioActual.getUser().getNomUsuario());
        return v;

    }


}