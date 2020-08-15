package com.example.amst10;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amst10.ui.DialogBoxBook;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private ArrayList<Book> items;
    public Context context;
    private Activity activity;

    public BookAdapter(Context ct, ArrayList<Book> items,Activity activity) {
        context= ct;
        this.items = items;
        this.activity=activity;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {


        items.get(position).setImageView( holder.itemImage);
        holder.title.setText(R.string.titulo+ items.get(position).getTitle());
        holder.author.setText(R.string.autor+items.get(position).getAuthor());
        holder.editorial.setText(R.string.editorial+items.get(position).getEditorial());

        final DialogBoxBook dbb= new DialogBoxBook(activity,items.get(position) );
        holder.cl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                dbb.popUpBuilder();
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public class BookViewHolder extends RecyclerView.ViewHolder {


        ImageView itemImage;
        TextView title,author,editorial;
        ConstraintLayout cl;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage= itemView.findViewById(R.id.bookImage);
            title=itemView.findViewById(R.id.titleTextView);
            author=itemView.findViewById(R.id.autorTextView);
            editorial=itemView.findViewById(R.id.editorialTextView);
            cl=itemView.findViewById(R.id.bookItemId);


        }
    }
    }
