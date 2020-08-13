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

public class Registro extends AppCompatActivity {
    private EditText edNombre,edApellido,edCorreo,edCelular,edUsuario,edContraseña;
    private Spinner edcategoria;
    private List<EditText> ets = Arrays.asList(edNombre, edApellido, edCorreo,edCelular,edUsuario,edContraseña);
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
        ArrayList<String> infoAIngresar = new ArrayList<>();
        String mandarSQL = "";
        for(int i=0;i<ets.size();i++){
            String str = ets.get(i).getText().toString();
            if(str.isEmpty()) {
                Toast.makeText(this, "Ingrese todos los datos.",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            infoAIngresar.add(str);
        }
        //no hay problema con el spinner ya que tiene uno preseleccionado
        infoAIngresar.add(edcategoria.getSelectedItem().toString());
        String[] resultado = null;
        try {
            String[] datos = new String[]{
                    "login",
                    //server
            };
            AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();
            //consulta.setText(resultado[0]);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finish();
    }
}