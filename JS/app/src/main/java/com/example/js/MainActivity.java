package com.example.js;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_hiragana = (Button) findViewById(R.id.btnHira);
        Button btn_katakana = (Button) findViewById(R.id.btnKata);
        Button btn_word = (Button) findViewById(R.id.btnWord);

        btn_hiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HiraganaActivity.class);
                startActivity(intent);
            }
        });

        btn_katakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),KatakanaActivity.class);
                startActivity(intent);
            }
        });

        btn_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),word.class);
                startActivity(intent);
            }
        });
    }
}