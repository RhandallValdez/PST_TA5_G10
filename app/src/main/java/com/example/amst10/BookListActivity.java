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


public void category(){

}


}