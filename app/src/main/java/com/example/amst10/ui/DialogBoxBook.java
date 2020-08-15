package com.example.amst10.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amst10.Book;
import com.example.amst10.R;

public class DialogBoxBook {
    private Activity activity;
    private AlertDialog alertDialog;
    private Book book;
    public DialogBoxBook(Activity activity, Book book){
        this.activity=activity;
        this.book=book;
    }
    public void popUpBuilder(){
        ImageView im;
        TextView title,description;


        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        LayoutInflater inflater =activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.pop_up,null);
       im=v.findViewById(R.id.popUpbookImageView);
        book.setImageView(im);
        title=v.findViewById(R.id.popUpTittleTextView);
        description=v.findViewById(R.id.popUpDescriptionTextView);

        title.setText(book.getTitle());
        description.setText(book.getDescription());

        builder.setView(v);
        builder.setCancelable(true);
        alertDialog=builder.create();
        alertDialog.show();
    }

}
