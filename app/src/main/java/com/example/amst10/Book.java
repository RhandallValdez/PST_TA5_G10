package com.example.amst10;

import android.widget.ImageView;

public class Book {
    private String imageURL;
    private String author;
    private String editorial;
    private String title;
    private String description;

    public Book(String imageURL, String author, String editorial,String title, String description) {
        this.imageURL = imageURL;
        this.author = author;
        this.editorial = editorial;
        this.title =title;
        this. description=description;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setImageView(ImageView im){
        ImageTask it=new ImageTask(im);
        it.execute(imageURL);
    }
    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }
}
