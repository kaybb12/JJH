package com.example.js;

import com.example.js.words.Voca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class ProblemSet {
    int problemCount = 20;
    Random random;

    int correctCount;
    int currentNumber;

    ArrayList<Integer> questions;

    public ProblemSet(int problemCount, ArrayList<Integer> problems) {
        this.problemCount = problemCount; //문제개수
        this.correctCount = 0; //맞은문제수
        this.currentNumber = 0; //현재 문제 번호

        random = new Random();
        random.setSeed(System.currentTimeMillis());
        makeQuestion(problems);
    }

    // 문제를 만들어 내는 함수
    void makeQuestion(ArrayList<Integer> problems) {
        questions = new ArrayList<Integer>();

        for(int i = 0; i < problemCount; ++i)
        {
            int value = random.nextInt(problems.size());
            questions.add(problems.get(value));
        }

        // problem 길이 내에서 rand 해서 questions 만들기
    }


    Integer getNextQuestion() {
        if (currentNumber < problemCount)
            return questions.get(currentNumber++);
        else
            return -1;
    }
}

