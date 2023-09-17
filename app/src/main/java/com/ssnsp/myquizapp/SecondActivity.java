package com.ssnsp.myquizapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ssnsp.myquizapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button submitButton;

    // Define your quiz questions and answers
    private String[] questions = {"Who is Srk?", "India renamed to ?", "Who is PM of BHARAT?"};
    private String[] correctAnswers = {"Answer 1", "Answer 2", "Answer 3"};

    private String[] optionAnswers = {"Answer 1", "Answer 2", "Answer 3","Answer 4", "Answer 5", "Answer 6"};

    private int currentQuestionIndex = 0;
    private int currentoptionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);

        displayQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);

        // Dynamically populate RadioButtons with answer choices
        for (int i = 0; i < answerRadioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) answerRadioGroup.getChildAt(i);
            radioButton.setText(optionAnswers[currentoptionIndex]);
            currentoptionIndex++;
        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = answerRadioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                // Correct answer
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                // Incorrect answer
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }

            // Move to the next question
            currentQuestionIndex++;

            if (currentQuestionIndex < questions.length) {
                displayQuestion();
                answerRadioGroup.clearCheck();
            } else {
                // Quiz completed
                Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show();
            }
        } else {
            // No answer selected
            Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
        }
    }

}

