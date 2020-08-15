package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

public class BookListCategory extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_category);
        Bundle bundle = getIntent().getExtras();
        ArrayList <Book> items ;
        items = (ArrayList<Book>) bundle.getSerializable("categoria");
        
        final BookAdapter adapter=new BookAdapter(this,items,this);//items es el arrayList
        recyclerView = (RecyclerView) findViewById(R.id.listBooksC);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}