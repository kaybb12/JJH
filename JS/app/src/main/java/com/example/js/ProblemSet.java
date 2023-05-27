package com.example.js;

import java.util.List;
import java.util.Random;

public class ProblemSet {
    int problemCount = 20;
    Random random;

    int correctCount;
    int currentNumber;
    List<String> problems;

    ProblemSet(int problemCount, List<String> problems) {
        this.problemCount = problemCount;
        this.correctCount = 0;
        this.currentNumber = 0;
        this.problems = problems;

        random = new Random();
    }

    int makeQuestion() {
        return (random.nextInt(problems.size()));
    }
}
