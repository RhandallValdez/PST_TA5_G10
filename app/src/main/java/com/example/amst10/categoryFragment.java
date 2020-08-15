package com.example.amst10;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.ExecutionException;


public class categoryFragment extends Fragment {
    String login = "https://lab6-guzman.000webhostapp.com/libros.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category,container,false);

    }
    public void catAventura(View view){
        String[] resultado = null;
        try {
            String[] datos = new String[]{
                    "categoria",
                     login,
                    "Aventura"
            };
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void catCiencia(View view){
        String[] resultado = null;
        try {
            String[] datos = new String[]{
                    "categoria",
                    login,
                    "Ciencia"
            };
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void catTerror(View view){
        String[] resultado = null;
        try {
            String[] datos = new String[]{
                    "categoria",
                    login,
                    "Terror/Horror"
            };
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void catDrama(View view){
        String[] resultado = null;
        try {
            String[] datos = new String[]{
                    "categoria",
                    login,
                    "Romance/Drama"
            };
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}