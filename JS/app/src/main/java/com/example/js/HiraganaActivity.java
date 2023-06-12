package com.example.js;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.js.words.Hiragana;
import com.example.js.words.Voca;

public class HiraganaActivity extends AppCompatActivity {
    ProblemSet problemSet; // 문제 생성 및 저장
    Voca currentVoca; //현재 답 저장

    // 액티비티간 데이터 전송 찾아 볼 것

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana);

        Button btnHirahome = (Button) findViewById(R.id.btnHirahome);
        Button btnHirastart = (Button) findViewById(R.id.btnHirastart);
        Button btnHirasub = (Button) findViewById(R.id.btnHirasub);

        btnHirahome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

       //problemSet = new ProblemSet(20,1); // 이전 액티비티에서 값 받아오기
    }

    void setNextProblem() {
        Integer next = problemSet.getNextQuestion();
        if (next.intValue() != -1) {
            currentVoca = Hiragana.hiragana.get(next);
            // 화면을 Voca로 세팅
        }
        else {
            // 문제 다 푼 경우
        }
    }

    // 답 제출시 onClick에서 호출하시면 됩니다.
    // onclick에서 만약 return true 이면 problemSet의 corectCount++; 해줄것 !!
    Boolean checkSolution(Integer num) {
        String answer = ""; // = EditText.getTest();
        if (answer == currentVoca.kr) //string compare사용
            return true;
        else return false;
    }
}