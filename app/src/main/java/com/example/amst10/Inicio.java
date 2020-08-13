package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Inicio extends AppCompatActivity {
    private EditText etUser,etContra;
    String login = "https://lab6-guzman.000webhostapp.com/login.php";
    UsuarioActual actUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.usuarioInicio);
        etContra = findViewById(R.id.ContraInicio);
    }
    public void ingresar(View v){
        String[] resultado;
        try {
            String[] datos = new String[]{
                    "login",
                    login,
                    etUser.getText().toString(),
                    etContra.getText().toString()
            };
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();
            System.out.println(resultado[0]);
            String[] info = resultado[0].split(",");
            if (info[0].equals("denegado")){
                Toast.makeText(Inicio.this, "Usuario no registrado o datos ingresados incorrectos.", Toast.LENGTH_SHORT).show();
                return;
            }
            actUsuario = new UsuarioActual(info[1], info[2],info[4],info[3],info[5],info[6]);
            System.out.println(info[1]+info[2]+info[3]);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void irRegistro(View v){
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);
    }
}