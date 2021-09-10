package com.example.poem.poem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poem.R;
import com.example.poem.category.Category;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

public class PoemAdapter extends ArrayAdapter<Poem> {


    public PoemAdapter(Context context, ArrayList<Poem> arrayList) {
        super(context,0,arrayList);
    }



    public View getView(int position, View convertView, ViewGroup parent){
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

//    public void setData(ArrayList<Poem> list){
//        arrayList = list;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public PoemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poem, parent, false);
//        return new PoemViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PoemViewHolder holder, int position) {
//        Poem poem = arrayList.get(position);
//        if(poem == null){
//            return;
//        }
//        holder.txt_Title.setText(poem.getName());
//        holder.txt_Content.setText(poem.getContent());
//        holder.txt_NameAuthor.setText(poem.getNameAuthor());
//        holder..setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                holder.foldingCell.toggle(false);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        if(arrayList == null) {
//            return 0;
//        }
//        else {
//            return arrayList.size();
//        }
//
//    }
//
//    public class PoemViewHolder extends  RecyclerView.ViewHolder {
//
//        private ImageView img;
//        private TextView txt_Title;
//        private TextView txt_Content, txt_NameAuthor;
//        public PoemViewHolder(@NonNull View itemView) {
//            super(itemView);
//            img = itemView.findViewById(R.id.img_poem);
//            txt_Title = itemView.findViewById(R.id.text_title);
//            txt_NameAuthor = itemView.findViewById(R.id.text_name_author);
//        }
//    }

}

//    public View getView(int position, View convertView, ViewGroup parent){
//        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_poem, parent, false);
//        Poem poem = getItem(position);
//
//        TextView textView = convertView.findViewById(R.id.text_title);
//        TextView textView1 = convertView.findViewById(R.id.text_content);
//        //ImageView image = convertView.findViewById(R.id.imgFood);
//
//        textView.setText(poem.getName());
//        textView1.setText(poem.getContent());
//        //image.setImageBitmap(Food.convertStringToBitmapFromAccess(getContext(), food.getImage()));
//
//
//        return convertView;
//    }


