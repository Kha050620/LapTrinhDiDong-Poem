package com.example.poem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.poem.poem.Poem;
import com.makeramen.roundedimageview.RoundedImageView;
import com.ramotion.foldingcell.FoldingCell;

public class DetailsActivity extends AppCompatActivity {
    private ImageView imgView;
    private TextView txtNamePoem, txtIntro, txtTitleContent, txtContent, txtNameAuthor;
    DBHelper dbHelper;
    ActionBar actionBar;
    FoldingCell foldingCell;
    ToggleButton buttonF;
    int favourite;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dbHelper=new DBHelper(DetailsActivity.this);
        foldingCell = findViewById(R.id.folding_cell);
        buttonF = findViewById(R.id.favouritebutton);
        imgView = findViewById(R.id.img_detail);
        // txtNamePoem = findViewById(R.id.namepoem_detail);
        txtIntro = findViewById(R.id.txt_introduce);
        txtTitleContent = findViewById(R.id.text_title_detail);
        txtContent = findViewById(R.id.cell_content_detail);
        txtNameAuthor = findViewById(R.id.text_name_author);
        Intent intent = getIntent();
        id = intent.getIntExtra("idPoem", 0);
        String img = intent.getStringExtra( "image");

        String name = intent.getStringExtra("name");
        String intro = intent.getStringExtra("introduce");
        String titleContent = intent.getStringExtra("name");
        String content = intent.getStringExtra("content");
        String nameAuthor = intent.getStringExtra("nameAuthor");
        favourite = intent.getIntExtra("favourite", 0);
        foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foldingCell.toggle(false);
            }
        });

//        String making = intent.getStringExtra("makingFood");
//        String des = intent.getStringExtra("desFood");
//        favourite = intent.getIntExtra("faFood", 0);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(name);
        imgView.setImageBitmap(Poem.convertStringToBitmapFromAccess(getApplication(),img));
       // txtNamePoem.setText(name);
        txtIntro.setText(intro);
        txtTitleContent.setText(titleContent);
        txtContent.setText(content);
        txtNameAuthor.setText(nameAuthor);
        setFavouriteButton(favourite);
   }
    public void onFavouriteClick(View view) {
        if (favourite == 1){
            dbHelper.updateFavoutite(id, favourite);
            Toast.makeText(this, "Bỏ yêu thích", Toast.LENGTH_SHORT).show();
            buttonF.setChecked(false);
        }
        else {
            dbHelper.updateFavoutite(id, favourite);
            Toast.makeText(this, "Thêm vào yêu thích", Toast.LENGTH_SHORT).show();
            buttonF.setChecked(true);
        }

    }


    private void setFavouriteButton(int favourite) {
        if(favourite == 1){
            buttonF.setChecked(true);
        }
        else{
            buttonF.setChecked(false);
        }
    }
    protected  void onResume(){
        super.onResume();
        setFavouriteButton(favourite);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}