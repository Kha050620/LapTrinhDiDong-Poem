package com.example.poem.category;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.poem.poem.Poem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Category {
    int id;
    String name;
    String introduce;
    String image;
    List<Poem> poemList;

    public Category(int id, String name, String introduce, String image, List<Poem> poemList) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.image = image;
        this.poemList = poemList;
    }

    public static Bitmap convertStringToBitmapFromAccess(Context context, String image) {

            AssetManager assetManager = context.getAssets();
            try {
                InputStream is = assetManager.open(image);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Poem> getPoemList() {
        return poemList;
    }

    public void setPoemList(List<Poem> poemList) {
        this.poemList = poemList;
    }
}
