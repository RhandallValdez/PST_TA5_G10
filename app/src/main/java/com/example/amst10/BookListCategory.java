package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

public class BookListCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_category);
        Bundle bundle = getIntent().getExtras();
        ArrayList <Book> items ;
        items = (ArrayList<Book>) bundle.getSerializable("categoria");
        RecyclerView recyclerView;
        View v= View.inflate(this,R.layout.activity_book_list_category,false);
        final BookAdapter adapter=new BookAdapter(this,items,this);//items es el arrayList


        SearchView sv=v.findViewById(R.id.searchBooks);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return true;
            }
        });
        recyclerView=v.findViewById(R.id.listBooksC);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        return v;
    }
}