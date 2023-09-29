package com.ssnsp.myquizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizResultAdapter extends RecyclerView.Adapter<QuizResultAdapter.ViewHolder> {

    private List<Question> quizResultItems;
    Context context;

    public QuizResultAdapter(List<Question> quizResultItems, Context context) {
        this.quizResultItems = quizResultItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.final_result_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question quizResultItem = quizResultItems.get(position);

        /*holder.textQuestionNumber.setText("Q" + (position + 1) + ".");
        holder.textQuestionText.setText(quizResultItem.getQuestion());

        holder.radioButtonOption1.setText(quizResultItem.getOpt_A());
        holder.radioButtonOption2.setText(quizResultItem.getOpt_B());*/

        holder.textQuestionNumber.setText(quizResultItem.getQuestion());
        holder.textViewAnswerNumber.setText("A" +(position + 1) + ". " +quizResultItem.getAnswer());

       /* int selectedOptionIndex = quizResultItem.getSelectedOptionIndex();
        if (selectedOptionIndex != -1) {
            holder.textViewSelectedAnswer.setVisibility(View.VISIBLE);
            holder.textViewSelectedAnswer.setText("Your Answer: Option " + (selectedOptionIndex + 1));
        } else {
            holder.textViewSelectedAnswer.setVisibility(View.GONE);
        }*/

       // holder.radioGroupOptions.check(selectedOptionIndex);
    }

    @Override
    public int getItemCount() {
        return quizResultItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textQuestionNumber;
        TextView textViewAnswerNumber;
        TextView textQuestionText;
        RadioGroup radioGroupOptions;
        RadioButton radioButtonOption1;
        RadioButton radioButtonOption2;
        RadioButton radioButtonOption3;
        RadioButton radioButtonOption4;
        ImageView answerStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*textQuestionNumber = itemView.findViewById(R.id.textViewQuestionNumber);
            radioGroupOptions = itemView.findViewById(R.id.radioGroupOptions);
            radioButtonOption1 = itemView.findViewById(R.id.radioButtonOption1);
            radioButtonOption2 = itemView.findViewById(R.id.radioButtonOption2);
            radioButtonOption3 = itemView.findViewById(R.id.radioButtonOption3);
            radioButtonOption4 = itemView.findViewById(R.id.radioButtonOption4);
            answerStatus = itemView.findViewById(R.id.imageViewAnswerStatus);*/
            textQuestionNumber = itemView.findViewById(R.id.textViewQuestionNumber);
            textViewAnswerNumber = itemView.findViewById(R.id.textViewAnswerNumber);
        }
    }
}
