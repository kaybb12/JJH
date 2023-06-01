package com.example.js;

import com.example.js.words.Voca;

import java.util.ArrayList;
import java.util.Random;

public class ProblemSet {
    int problemCount = 20;
    Random random;

    int correctCount;
    int currentNumber;

    ArrayList<Integer> questions;

    ProblemSet(int problemCount, ArrayList<Integer> problems) {
        this.problemCount = problemCount;
        this.correctCount = 0;
        this.currentNumber = 0;

        random = new Random();
    }

    // 문제를 만들어 내는 함수
    void makeQuestion(ArrayList<Integer> problem) {
        questions = new ArrayList<>();

        // problem 길이 내에서 rand 해서 questions 만들기
    }


    Integer getNextQuestion() {
        if (currentNumber <= problemCount)
            return questions.get(currentNumber++);

        else
            return -1;
    }
}

