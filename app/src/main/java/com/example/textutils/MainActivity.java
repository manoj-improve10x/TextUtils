package com.example.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    EditText urlTextTxt;
    String url;
    ImageView imageImg;
    Button previewBtn;
    ImageButton leftIBtn;
    ImageButton rightIBtn;
    Button horizontalBtn;
    Button verticalBtn;
    int ScaleX = 1;
    int ScaleY = 1;
    int angele = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("ImageUtils");
        urlTextTxt = findViewById(R.id.url_text_txt);
        imageImg = findViewById(R.id.image_img);
        previewBtn = findViewById(R.id.preview_btn);
        leftIBtn = findViewById(R.id.left_ibtn);
        rightIBtn = findViewById(R.id.right_ibtn);
        horizontalBtn = findViewById(R.id.horizontal_btn);
        verticalBtn = findViewById(R.id.vertical_btn);

        handlePreview();
        handleRotateLeft();
        handleRotateRight();
        handleFlipHorizontal();
        handleFlipVertical();
    }

    public void handlePreview() {
        previewBtn.setOnClickListener(view -> {
            getSupportActionBar().hide();
            angele = 0;
            ScaleX = 1;
            ScaleY = 1;
            imageImg.setScaleX(ScaleX);
            imageImg.setScaleY(ScaleY);
            url = urlTextTxt.getText().toString();
            Picasso.get().load(url).into(imageImg);
        });
    }

    public void handleRotateLeft() {
        leftIBtn.setOnClickListener(view -> {
            getSupportActionBar().show();
            angele = angele + (ScaleX * ScaleY *-90);
            Picasso.get().load(url).rotate(angele).into(imageImg);
        });
    }

    public void handleRotateRight() {
        rightIBtn.setOnClickListener(view -> {
            angele = angele +(ScaleX * ScaleY * 90);
            Picasso.get().load(url).rotate(angele).into(imageImg);
        });
    }

    public void handleFlipHorizontal() {
        horizontalBtn.setOnClickListener(view -> {
            ScaleX = ScaleX * -1;
            imageImg.setScaleX(ScaleX);
        });
    }

    public void handleFlipVertical() {
        verticalBtn.setOnClickListener(view -> {
            ScaleY = ScaleY * -1;
            imageImg.setScaleY(ScaleY);
        });
    }
}