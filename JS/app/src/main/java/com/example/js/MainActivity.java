package com.example.js;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_word = (Button) findViewById(R.id.btnWord);
        Button btn_exam = (Button) findViewById(R.id.btnExam);

        Button btn_test = (Button) findViewById(R.id.btnTest);

        ImageView img_test = (ImageView) findViewById(R.id.img_test);
        Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        Animation animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);

        btn_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), WordActivity.class);
                startActivity(intent);
            }
        });
        btn_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
                startActivity(intent);
            }
        });
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_test.setVisibility(View.VISIBLE);
                img_test.startAnimation(animFadeout);
                img_test.setVisibility(View.INVISIBLE);
            }
        });
    }
}