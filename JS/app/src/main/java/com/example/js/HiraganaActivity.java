package com.example.js;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.js.words.Hiragana;
import com.example.js.words.Voca;

import java.util.ArrayList;
import java.util.Vector;

public class HiraganaActivity extends AppCompatActivity {
    ProblemSet problemSet; // 문제 생성 및 저장
    Voca currentVoca; //현재 답 저장
    TextView txtHira;
    Button btnHirasub, btnHirahome, btnHirastart;

    EditText editHira;

    String answer, correct;

    ImageView imgJeongdap, imgOdap;

    Integer problemNum;

    Animation animFadein, animFadeout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana);

        Intent it = getIntent();
        ArrayList<Integer> Hiravec = it.getIntegerArrayListExtra("HiraCheck");
        problemSet = new ProblemSet(20,Hiravec);
        Log.d("디버깅",""+Hiravec);

        btnHirahome = (Button) findViewById(R.id.btnHirahome);
        btnHirastart = (Button) findViewById(R.id.btnHirastart);
        btnHirasub = (Button) findViewById(R.id.btnHirasub);
        txtHira = (TextView) findViewById(R.id.txtHira);
        editHira = (EditText) findViewById(R.id.editHira);
        imgJeongdap = (ImageView) findViewById(R.id.imgCorrect);
        imgOdap = (ImageView) findViewById(R.id.imgOdap);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);


        btnHirahome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        setNextProblem();
        btnHirasub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSolution(problemNum);
                if (checkSolution(problemNum)==true)
                {
                 /* imgJeongdap.setVisibility(View.VISIBLE);
                    imgJeongdap.startAnimation(animFadeout);
                    imgJeongdap.setVisibility(View.INVISIBLE);
                    */
                    problemSet.correctCount++;
                    setNextProblem();
                }
                else if (checkSolution(problemNum)==false)
                {
                    /*
                    imgOdap.setVisibility(View.VISIBLE);
                    imgOdap.setAnimation(animFadeout);
                    imgOdap.setVisibility(View.INVISIBLE);
                    */
                    setNextProblem();
                }
            }
        });

        btnHirastart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);

                intent.putExtra("정답수",problemSet.correctCount);
                startActivity(intent);
            }
        });
    }

    void setNextProblem() {
        Integer next = problemSet.getNextQuestion();
        problemNum = next;
        if (next.intValue() != -1) {
            Log.d("오류확인",""+next);
            currentVoca = Hiragana.getVoca(next);
            // 화면을 Voca로 세팅
            txtHira.setText(currentVoca.jp);
        }
        else {
            // 문제 다 푼 경우
            btnHirastart.setEnabled(true);
            editHira.setEnabled(false);
            btnHirasub.setEnabled(false);
        }
    }

    Boolean checkSolution(Integer num) {
        answer = editHira.getText().toString();
        if (answer.equalsIgnoreCase(currentVoca.kr)) {
            return true;
        } else{
            return false;
        }
    }
}