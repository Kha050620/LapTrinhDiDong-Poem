package com.example.poem.category;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poem.R;
import com.example.poem.poem.PoemActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

   private List<Category> listCategories;
   private Activity activity;

    public CategoryAdapter(List<Category> listCategories) {
        this.listCategories = listCategories;
        this.activity = activity;
    }

    public void setData(List<Category> list, Activity activity){
        this.listCategories=list;
        this.activity=activity;
    }
    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = listCategories.get(position);
        if(category == null) {
            return;
        }
        holder.imgCate.setImageBitmap(Category.convertStringToBitmapFromAccess(holder.itemView.getContext(),category.getImage()));
        holder.tvName.setText(category.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), PoemActivity.class);
                intent.putExtra("cate_id", category.getId());
                intent.putExtra("cate_name", category.getName());
                intent.putExtra("cate_img", category.getImage());
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity, v, "imgcate_transition").toBundle();
                holder.itemView.getContext().startActivity(intent, bundle);




            }
        });
    }

    @Override
    public int getItemCount() {
        if(listCategories != null) {
            return listCategories.size();
        }
        return 0;
    }



    public class CategoryHolder extends RecyclerView.ViewHolder{

        private ImageView imgCate;
        private TextView tvName;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            imgCate = itemView.findViewById(R.id.img_category);
            tvName = itemView.findViewById(R.id.textview_name);
        }
    }
}
