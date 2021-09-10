package com.example.poem.poem;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class Poem {
    int idPoem;
    String name;
    String introduce;
    String image;
    String content;
    int favourite;
    int history;
    String nameAuthor;
    String nameCategory;

    public Poem(int idPoem, String name, String introduce, String image, String content, int favourite, int history, String nameCategory, String nameAuthor) {
        this.idPoem = idPoem;
        this.name = name;
        this.introduce = introduce;
        this.image = image;
        this.content = content;
        this.favourite = favourite;
        this.history = history;
        this.nameCategory = nameCategory;
        this.nameAuthor = nameAuthor;

    }

    public int getIdPoem() {
        return idPoem;
    }

    public void setIdPoem(int idPoem) {
        this.idPoem = idPoem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }


    public static Bitmap convertStringToBitmapFromAccess(Context context, String filename){
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(filename);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
