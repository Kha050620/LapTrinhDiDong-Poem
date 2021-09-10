package com.example.poem.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poem.DBHelper;
import com.example.poem.DetailsActivity;
import com.example.poem.R;
import com.example.poem.category.CategoryAdapter;
import com.example.poem.poem.Poem;
import com.example.poem.poem.PoemActivity;
import com.example.poem.poem.PoemAdapter;
import com.example.poem.poem.PoemAdapterRecycle;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class FavouriteFragment extends Fragment {

//    private RecyclerView recyclerView;
//    private PoemAdapterRecycle poemAdapterRecycle;
    private ListView list;
    private PoemAdapter poemAdapter;

    ArrayList<Poem> arrayList;
    DBHelper dbHelper;
    GifImageView imageEmpty;

    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;

    Menu menu;
    boolean isExpand = true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        dbHelper = new DBHelper(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

//        appBarLayout = view.findViewById(R.id.appBarLayout);
//        collapsingToolbarLayout = view.findViewById(R.id.collapsingToolbarLayout);
//        toolbar = view.findViewById(R.id.toolbar);
//        floatingActionButton = view.findViewById(R.id.fab_add);
//



        list = view.findViewById(R.id.listView_favourite);
        arrayList = dbHelper.loadPoemByFavourite(1);
        imageEmpty = view.findViewById(R.id.empty_list);
        if (arrayList.size() > 0){
            imageEmpty.setVisibility(View.GONE);
        }
        else {
            imageEmpty.setVisibility(View.VISIBLE);
        }
        poemAdapter = new PoemAdapter(getActivity(), arrayList);
        list.setAdapter(poemAdapter);

       // actionBar.setDisplayHomeAsUpEnabled(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(getContext(), DetailsActivity.class);
                intent1.putExtra("idPoem", arrayList.get(i).getIdPoem());
                intent1.putExtra("name", arrayList.get(i).getName());
                intent1.putExtra("introduce", arrayList.get(i).getIntroduce());
                intent1.putExtra("image", arrayList.get(i).getImage());
                intent1.putExtra("content", arrayList.get(i).getContent());
                intent1.putExtra("favourite", arrayList.get(i).getFavourite());
                intent1.putExtra("history", arrayList.get(i).getHistory());
                intent1.putExtra("nameCategory", arrayList.get(i).getNameCategory());
                intent1.putExtra("nameAuthor", arrayList.get(i).getNameAuthor());
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity(), view, "imgpoem_transition").toBundle();
                startActivity(intent1, bundle);
            }
        });
        return  view;


    }


    @Override
    public void onResume() {
        super.onResume();
        if (arrayList.size() > 0){
            imageEmpty.setVisibility(View.GONE);
        }
        else {
            imageEmpty.setVisibility(View.VISIBLE);
        }
        arrayList = dbHelper.loadPoemByFavourite(1);
        poemAdapter = new PoemAdapter(getActivity(), arrayList);
        list.setAdapter(poemAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initToolbar(){

    }

}
