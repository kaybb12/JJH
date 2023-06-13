package com.example.js;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.js.words.Hiragana;
import com.example.js.words.Katakana;
import com.example.js.words.Voca;

import java.util.ArrayList;

public class KatakanaActivity extends AppCompatActivity {

    ProblemSet problemSet; // 문제 생성 및 저장
    Voca currentVoca; //현재 답 저장
    TextView txtKata;
    Button btnKatasub, btnKatahome, btnKatastart;

    EditText editKata;

    String answer, correct;

    ImageView imgJeongdap, imgOdap;

    Integer problemNum;

    Animation animFadein, animFadeout;

    Toast t;

    int proNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana);

        Intent it = getIntent();
        ArrayList<Integer> Katavec = it.getIntegerArrayListExtra("KataCheck");
        proNum = it.getIntExtra("proNum",0);
        problemSet = new ProblemSet(proNum,Katavec);
        Log.d("디버깅",""+Katavec);

        btnKatahome = (Button) findViewById(R.id.btnKatahome);
        btnKatastart = (Button) findViewById(R.id.btnKatastart);
        btnKatasub = (Button) findViewById(R.id.btnKatasub);
        txtKata = (TextView) findViewById(R.id.txtKata);
        editKata = (EditText) findViewById(R.id.editKata);
        //imgJeongdap = (ImageView) findViewById(R.id.imgCorrect);
        //imgOdap = (ImageView) findViewById(R.id.imgOdap);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);

        btnKatahome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        setNextProblem();
        btnKatasub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSolution(problemNum);
                if (checkSolution(problemNum)==true)
                {
                 /* imgJeongdap.setVisibility(View.VISIBLE);
                    imgJeongdap.startAnimation(animFadeout);
                    imgJeongdap.setVisibility(View.INVISIBLE);
                    */
                    t = Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
                    LayoutInflater inflater = getLayoutInflater();
                    View v = inflater.inflate(R.layout.toast,null);
                    t.setView(v);

                    t.setGravity(Gravity.CENTER,0,0);
                    t.show();

                    problemSet.correctCount++;
                }
                else if (checkSolution(problemNum)==false)
                {
                    /*
                    imgOdap.setVisibility(View.VISIBLE);
                    imgOdap.setAnimation(animFadeout);
                    imgOdap.setVisibility(View.INVISIBLE);
                    */
                    t = Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
                    LayoutInflater inflater = getLayoutInflater();
                    View v = inflater.inflate(R.layout.toast1,null);
                    t.setView(v);

                    t.setGravity(Gravity.CENTER,0,0);

                    t.show();

                    Toast.makeText(getApplicationContext(),""+currentVoca.jp+":"+currentVoca.kr,Toast.LENGTH_SHORT).show();
                }
                setNextProblem();
            }
        });

        btnKatastart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);

                intent.putExtra("정답수",problemSet.correctCount);
                intent.putExtra("문제수",proNum);
                startActivity(intent);
            }
        });
    }

    void setNextProblem() {
        Integer next = problemSet.getNextQuestion();
        problemNum = next;
        if (next.intValue() != -1) {
            Log.d("오류확인",""+next);
            currentVoca = Katakana.getVoca(next);
            // 화면을 Voca로 세팅
            txtKata.setText(currentVoca.jp);
        }
        else {
            // 문제 다 푼 경우
            btnKatastart.setEnabled(true);
            editKata.setEnabled(false);
            btnKatasub.setEnabled(false);
        }
    }

    Boolean checkSolution(Integer num) {
        answer = editKata.getText().toString();
        if (answer.equalsIgnoreCase(currentVoca.kr)) {
            return true;
        } else{
            return false;
        }
    }
}