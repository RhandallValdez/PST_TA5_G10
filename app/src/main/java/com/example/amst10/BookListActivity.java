package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {
    private ArrayList<Book> books;
    private UsuarioActual user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
       user=(UsuarioActual) getIntent().getSerializableExtra("usuario");

    }

    public ArrayList<Book> loadBooks(){


        return null;
    }

    public void profile(View v){
        Intent i = new Intent(this,);
        i.putExtra("usuario",user);

    }



}