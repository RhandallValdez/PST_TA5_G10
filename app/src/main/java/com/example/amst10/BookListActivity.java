package com.example.amst10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {
    private ArrayList<Book> books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        //profile();
        BottomNavigationView BottomNavView= (BottomNavigationView)findViewById(R.id.navigationView);
        BottomNavView.setOnNavigationItemSelectedListener((navListener));
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,new ListFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener(){
        public boolean onNavigationItemSelected(@NonNull MenuItem item){
           Fragment selected=null;
           switch(item.getItemId()){
               case R.id.homeButton:
                   selected=new BookListFragment();
                   break;
               case R.id.menuButton:
                   selected=new categoryFragment();
                   break;
               case R.id.profileButton:
                   selected=new profileFragment();
                   break;
           }
           getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,selected).commit();
           return true;
        }
    };

    public ArrayList<Book> loadBooks(){


        return null;
    }

    public void profile(View v){

    }
public void profile(){
        TextView edNombre,edApellido,edCelular,edCorreo,edCategoria,edUsuario;

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

public void category(){

}


}