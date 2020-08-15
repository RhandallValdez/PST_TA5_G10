package com.example.amst10;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookListFragment extends Fragment {
    private  Activity activity;
    public BookListFragment(Activity activity){
       super();
        this.activity=activity;
    }
    public BookListFragment(){
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        View v= inflater.inflate(R.layout.fragment_list,container,false);
        //BookAdapter adapter=new BookAdapter(getContext(),****items,activity);//items es el arrayList
        //recyclerView=v.findViewById(R.id.listBooks);
        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;

    }
}
