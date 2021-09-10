package com.example.poem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class WelcomeActivity extends AppCompatActivity {

    private static final String URL_GIF_IMAGE = "http://i.imgur.com/Vth6CBz.gif";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);

//        ImageView imageView = findViewById(R.id.img_gif);
//        Glide.with(this).load(URL_GIF_IMAGE).into(imageView);
        
//        GifImageView gifImageView = findViewById(R.id.img_gif2);
//        gifImageView.setImageResource(R.drawable.gif2);
//
//        final MediaController mc = new MediaController(this);
//        mc.setMediaPlayer((GifDrawable) gifImageView.getDrawable());
//        mc.setAnchorView(gifImageView);
//        gifImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mc.show();
//            }
//        });
    }
}