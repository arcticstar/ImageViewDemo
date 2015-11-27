package com.auxgroup.imageviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private RoundImageView img_round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_round= (RoundImageView) findViewById(R.id.img_round);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.smile);
       img_round.setMbitmap(bitmap);
    }
}
