package com.ssnsp.myquizapp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
    private FirebaseDatabase database;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        FirebaseApp.initializeApp(this);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);
        database= FirebaseDatabase.getInstance("https://ss-quiz-app-default-rtdb.asia-southeast1.firebasedatabase.app/");
        myRef=database.getReference();
        displayQuestion();
        firebaseQuestion();

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
                //Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(SecondActivity.this,FinalResultActivity.class);
                startActivity(intent);
            }
        } else {
            // No answer selected
            Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
        }
    }
    private void firebaseQuestion(){
        try {
            myRef.child("Questions").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {

                        for (DataSnapshot questionSnapshot : dataSnapshot.getChildren()) {
                            String question = questionSnapshot.child("question").getValue(String.class);
                            String answer = questionSnapshot.child("answer").getValue(String.class);
                            String optionsA = questionSnapshot.child("opt_A").getValue(String.class);
                            String optionsB = questionSnapshot.child("opt_B").getValue(String.class);
                            String optionsC = questionSnapshot.child("opt_C").getValue(String.class);
                            String optionsD = questionSnapshot.child("opt_D").getValue(String.class);


                            Log.d("SecondActivity:", "Question: " + question + ", Answer: " + answer +
                                                                "optionA: " + optionsA);
                        }
                    } else {
                        Log.d("SecondActivity:", "No data");
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("SecondActivity:", "No error");            }
            });

        }catch (Exception e){
            Log.d("SecondActivity:", "No error" + e);            }
    }

}

