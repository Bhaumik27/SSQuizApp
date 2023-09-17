
package com.example.myquizapp;

public class Question {
    private String question;
    private String choice1;
    private String choice2;
    private String correctAnswer;

    public Question(String question, String choice1, String choice2) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.correctAnswer = choice1; // Set the correct answer here
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
