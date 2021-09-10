package com.example.poem.author;

import android.app.Activity;
import android.app.ActivityOptions;
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
import com.example.poem.category.Category;
import com.example.poem.poem.Poem2Activity;
import com.example.poem.poem.PoemActivity;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorHolder> {

   private List<Author> listauthor;
   private Activity activity;

    public AuthorAdapter(List<Author> listauthor) {
        this.listauthor = listauthor;
        this.activity = activity;
    }

    public void setData(List<Author> list, Activity activity){
        this.listauthor =list;
        this.activity=activity;
    }
    @NonNull
    @Override
    public AuthorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new AuthorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorHolder holder, int position) {
        Author author = listauthor.get(position);
        if(author == null) {
            return;
        }
        holder.imgCate.setImageBitmap(Author.convertStringToBitmapFromAccess(holder.itemView.getContext(),author.getImage()));
        holder.tvName.setText(author.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), Poem2Activity.class);
                intent.putExtra("author_id", author.getId());
                intent.putExtra("author_name", author.getName());
                intent.putExtra("author_img", author.getImage());
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity, v, "imgcate_transition").toBundle();
                holder.itemView.getContext().startActivity(intent, bundle);




            }
        });
    }

    @Override
    public int getItemCount() {
        if(listauthor != null) {
            return listauthor.size();
        }
        return 0;
    }



    public class AuthorHolder extends RecyclerView.ViewHolder{

        private ImageView imgCate;
        private TextView tvName;

        public AuthorHolder(@NonNull View itemView) {
            super(itemView);
            imgCate = itemView.findViewById(R.id.img_category);
            tvName = itemView.findViewById(R.id.textview_name);
        }
    }
}
