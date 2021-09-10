package com.example.poem.poem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poem.R;
import com.example.poem.category.Category;

import java.util.List;

public class PoemAdapterRecycle extends  RecyclerView.Adapter<PoemAdapterRecycle.PoemViewHolder> {
    private List<Poem> list;
    private Activity activity;

    public PoemAdapterRecycle(List<Poem> list) {
        this.list = list;
        this.activity = activity;
    }

    public void setData(List<Poem> list, Activity activity){
        this.list =list;
        this.activity=activity;
    }

    @NonNull
    @Override
    public PoemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poem, parent,false);

        return new PoemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PoemViewHolder holder, int position) {
            Poem poem = list.get(position);
            if(poem == null){
                return;
            }
            holder.txtName.setText(poem.getName());
            holder.txtName_Author.setText(poem.getNameAuthor());
        holder.image.setImageBitmap(Poem.convertStringToBitmapFromAccess(holder.itemView.getContext(),poem.getImage()));

    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public class PoemViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        TextView txtName_Author;
        ImageView image;


        public PoemViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.text_title);
            txtName_Author = itemView.findViewById(R.id.text_name_author);
            image = itemView.findViewById(R.id.img_poem);

        }
    }
}
