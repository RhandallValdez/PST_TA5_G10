package com.example.amst10;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookListFragment extends Fragment {
    private  Activity activity;
    public static ArrayList<Book> items=new ArrayList<>();



    public BookListFragment(Activity activity){
       super();
        this.activity=activity;
    }
    public BookListFragment(){
        super();
    }
    public static  void  addBooks(){
        items.add(new Book("https://static.megustaleer.com/images/libros_650_x/P32147B.jpg","Ray Bradbury","Ballantine Books","Fahrenheit 451","Guy Montag es un bombero y el trabajo de un bombero es quemar libros, que están prohibidos porque son causa de discordia y sufrimiento.","Ciencia Ficcion"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        View v= inflater.inflate(R.layout.fragment_list,container,false);
       final BookAdapter adapter=new BookAdapter(getContext(),items,activity);//items es el arrayList


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

        return v;

    }
}
