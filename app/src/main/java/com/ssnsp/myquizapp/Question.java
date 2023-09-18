
package com.ssnsp.myquizapp;

public class Question {
    private String question;
    private String answer;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;


    public Question(String question, String choice1, String choice2,String choice3,String choice4) {
        this.question = question;
        this.optionA = choice1;
        this.optionB = choice2;
        this.optionC = choice3;
        this.optionD = choice4;
        this.answer = choice1; // Set the correct answer here
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice1() {
        return optionA;
    }

    public String getChoice2() {
        return optionB;
    }
    public String getChoice3() {
        return optionC;
    }

    public String getChoice4() {
        return optionD;
    }

    public String getCorrectAnswer() {
        return answer;
    }
}


