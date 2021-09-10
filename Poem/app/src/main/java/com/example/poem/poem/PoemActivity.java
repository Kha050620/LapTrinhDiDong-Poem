package com.example.poem.poem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.poem.DBHelper;
import com.example.poem.DetailsActivity;
import com.example.poem.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ramotion.foldingcell.FoldingCell;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class PoemActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Poem> arrayList, arrayListHis;
    PoemAdapter poemAdapter;
    DBHelper dbHelper;
    ImageView imageView;
    int cateid;
    int history;
    String name;
    ActionBar actionBar;


    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;

    Menu mMenu;
    boolean isExpand = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper(PoemActivity.this);
        setContentView(R.layout.activity_poem);
        imageView = findViewById(R.id.img_cate);
        listView= findViewById(R.id.listView_poem);


        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        toolbar = findViewById(R.id.toolbar);
        floatingActionButton = findViewById(R.id.fab_add);




        Intent intent = getIntent();
        cateid = intent.getIntExtra("cate_id", 0);
        String img = intent.getStringExtra("cate_img");
        name = intent.getStringExtra("cate_name");
        String nameAuthor = intent.getStringExtra("cate_nameAuthor");
        imageView.setImageBitmap(Poem.convertStringToBitmapFromAccess(PoemActivity.this, img));
        arrayList = dbHelper.loadPoemByCateID(cateid);
        poemAdapter = new PoemAdapter(PoemActivity.this, arrayList);
        listView.setAdapter(poemAdapter);
        //actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        initToolBar();
        initToolBarAnimation();
        onClickButtonAdd();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                history = arrayList.get(i).getHistory();
                Toast.makeText(getApplication(), history+"", Toast.LENGTH_SHORT).show();
                    if (history == 0){
                        dbHelper.updateHistory(arrayList.get(i).getIdPoem(),history);
                        Toast.makeText(getApplication(), "Add his", Toast.LENGTH_SHORT).show();
                    }
                Intent intent1 = new Intent(getApplication(), DetailsActivity.class);
                intent1.putExtra("idPoem", arrayList.get(i).getIdPoem());
                intent1.putExtra("name", arrayList.get(i).getName());
                intent1.putExtra("introduce", arrayList.get(i).getIntroduce());
                intent1.putExtra("image", arrayList.get(i).getImage());
                intent1.putExtra("content", arrayList.get(i).getContent());
                intent1.putExtra("favourite", arrayList.get(i).getFavourite());
                intent1.putExtra("history", arrayList.get(i).getHistory());
                intent1.putExtra("nameCategory", arrayList.get(i).getNameCategory());
                intent1.putExtra("nameAuthor", arrayList.get(i).getNameAuthor());
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(PoemActivity.this, view, "imgpoem_transition").toBundle();
                startActivity(intent1, bundle);


            }
        });
    }

    private  void initToolBar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     }
    }
    private void initToolBarAnimation(){
        collapsingToolbarLayout.setTitle(name);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thothatngonbatcu);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int myColor = palette.getVibrantColor(getResources().getColor(R.color.color_toolbar));
                collapsingToolbarLayout.setContentScrimColor(myColor);
                collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.color_backtrans));
            }
        });
                appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                    @Override
                    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                        if(Math.abs(verticalOffset)>200){
                            isExpand = false;
                        }
                        else{
                            isExpand = true;
                        }
                        invalidateOptionsMenu();
                    }
                });
    }


    private void onClickButtonAdd(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PoemActivity.this, "Click button add", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        mMenu = menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(mMenu != null && (!isExpand || mMenu.size() != 1)){
            mMenu.add("Add").setIcon(R.drawable.ic_baseline_add_circle_24).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        return super.onPrepareOptionsMenu(mMenu);
    }



//    public static Bitmap convertStringToBitmapFromAccess(Context context, String filename){
//        AssetManager assetManager = context.getAssets();
//        try {
//            InputStream is = assetManager.open(filename);
//            Bitmap bitmap = BitmapFactory.decodeStream(is);
//            return bitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_delete:
                return  true;

        }
        if(item.getTitle() == "Add"){
            Toast.makeText(this, "Clicked add", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}