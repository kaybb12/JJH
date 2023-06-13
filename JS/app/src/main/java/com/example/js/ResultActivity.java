package com.example.js;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtScore;
    Button btnHome;

    int CorrectNum;

    int proNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent it = getIntent();
        CorrectNum = it.getIntExtra("정답수",0);
        proNum = it.getIntExtra("문제수",0);

        txtScore = (TextView) findViewById(R.id.txtScore);
        btnHome = (Button) findViewById(R.id.btnResulthome);

        txtScore.setText(""+CorrectNum+"/"+proNum);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}