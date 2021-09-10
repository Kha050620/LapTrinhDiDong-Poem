package com.example.poem.history;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.ActionBar;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.poem.DBHelper;
import com.example.poem.DetailsActivity;
import com.example.poem.R;
import com.example.poem.poem.Poem;
import com.ramotion.foldingcell.FoldingCell;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class HistoryAdapter  extends ArrayAdapter<Poem> {


    public HistoryAdapter(Context context, ArrayList<Poem> arrayList) {
        super(context, 0, arrayList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_poem, parent, false);
        Poem poem = getItem(position);

        TextView txtName = convertView.findViewById(R.id.text_title);
        TextView txtName_Author = convertView.findViewById(R.id.text_name_author);
        ImageView image = convertView.findViewById(R.id.img_poem);

        txtName.setText(poem.getName());
        txtName_Author.setText(poem.getNameAuthor());
        image.setImageBitmap(Poem.convertStringToBitmapFromAccess(getContext(), poem.getImage()));

//        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation);
//        convertView.startAnimation(animation);
        return convertView;
    }
}
