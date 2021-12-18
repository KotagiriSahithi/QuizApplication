package com.example.quizapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity
        implements View.OnClickListener{


    private RadioButton option1;
    private RadioButton option2;
    private RadioButton option3;
    private RadioButton option4;
        private ImageButton nextButton;
        private ImageButton prevButton;
        private ImageView Image;
        private TextView questionTextView;
        private int correct = 0,a=0;
        // to keep current question track
        private int currentQuestionIndex = 0;

        private Question[] questionBank = new Question[] {
                // array of objects of class Question
                // providing questions from string
                // resource and the correct ans
                new Question(R.string.a1, "Causal"),
                new Question(R.string.b1, "stripplot()"),
                new Question(R.string.c1, "Open source"),
                new Question(R.string.d1, "John Chambers"),
                new Question(R.string.e1, "Command line interpreter"),
                new Question(R.string.f1, "6"),
                new Question(R.string.g1, "c()"),
                new Question(R.string.h1, "Function"),
                new Question(R.string.i1, "All of the mentioned"),
                new Question(R.string.j1, "All steps should be noted"),


        };

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);
            // setting up the buttons
            // associated with id
            option1 = findViewById(R.id.radioButton);
            option2 = findViewById(R.id.radioButton2);
            option3= findViewById(R.id.radioButton3);
            option4= findViewById(R.id.radioButton4);
            nextButton = findViewById(R.id.next_button);
            prevButton = findViewById(R.id.prev_button);
            nextButton = findViewById(R.id.next_button);
            prevButton = findViewById(R.id.prev_button);
            // register our buttons to listen to
            // click events
            questionTextView
                    = findViewById(R.id.answer_text_view);
            Image = findViewById(R.id.myimage);
            //falseButton.setOnClickListener((View.OnClickListener) this);
            //trueButton.setOnClickListener((View.OnClickListener) this);
            nextButton.setOnClickListener((View.OnClickListener) this);
            prevButton.setOnClickListener((View.OnClickListener) this);
        }
    RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);
    final String value =
            ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                    .getText().toString();
    //boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                //if (checked)
                checkAnswer(value);
                break;
            case R.id.radioButton2:
            case R.id.radioButton3:
            case R.id.radioButton4:
                //if (checked
                checkAnswer(value);
                break;

        }
    }
        @SuppressLint("SetTextI18n")
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v)
        {
            // checking which button is
            // clicked by user
            // in this case user choose false
            a++;
            switch (v.getId()) {
                /*case R.id.false_button:
                    checkAnswer(false);
                    a=0;
                    break;

                case R.id.true_button:
                    checkAnswer(true);
                    a=0;
                    break;*/

                case R.id.next_button:
                    // go to next question
                    // limiting question bank range
                    a=0;
                    if (currentQuestionIndex < 11) {
                        currentQuestionIndex
                                = currentQuestionIndex + 1;
                        // we are safe now!
                        // last question reached
                        // making buttons
                        // invisible
                        if (currentQuestionIndex == 10) {
                            questionTextView.setText(getString(
                                    R.string.correct, correct));
                            nextButton.setVisibility(
                                    View.INVISIBLE);
                            prevButton.setVisibility(
                                    View.INVISIBLE);
                            //trueButton.setVisibility(
                                   // View.INVISIBLE);
                            //falseButton.setVisibility(
                                   // View.INVISIBLE);
                            if (correct > 3) {

                                questionTextView.setText(
                                        "CORRECTNESS IS " + correct
                                                + " "
                                                + "OUT OF 6");
                                Image.setImageResource(
                                        R.drawable.happy);
                                // showing correctness
                            }
                            else
                                Image.setImageResource(
                                        R.drawable.resu);
                            // if correctness<3 showing sad emoji
                        }
                        else {
                            updateQuestion();
                        }
                    }

                    break;
                case R.id.prev_button:
                    if (currentQuestionIndex > 0) {
                        currentQuestionIndex
                                = (currentQuestionIndex - 1)
                                % questionBank.length;
                        updateQuestion();
                    }
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void updateQuestion()
        {
            Log.d("Current",
                    "onClick: " + currentQuestionIndex);

            questionTextView.setText(
                    questionBank[currentQuestionIndex]
                            .getAnswerResId());
            // setting the textview with new question
        /*switch (currentQuestionIndex) {
            case 1:
                // setting up image for each
                // question
                Image.setImageResource(R.drawable.f2);
                break;
            case 2:
                Image.setImageResource(R.drawable.f3);
                break;
            case 3:
                Image.setImageResource(R.drawable.f4);
                break;
            case 4:
                Image.setImageResource(R.drawable.f5);
                break;
            case 5:
                Image.setImageResource(R.drawable.f6);
                break;
            case 6:
                Image.setImageResource(R.drawable.f7);
                break;
            case 7:
                Image.setImageResource(R.drawable.f1);
                break;
        }*/
        }
        private void checkAnswer(String userChooseCorrect)
        {
            String answerIsTrue
                    = questionBank[currentQuestionIndex]
                    .isAnswerTrue();
            // getting correct ans of current question
            int toastMessageId;
            // if ans matches with the
            // button clicked

            if (userChooseCorrect == answerIsTrue) {
                toastMessageId = R.string.correct_answer;
                if(a==1)
                    correct++;
            }
            else {
                // showing toast
                // message correct
                a=1;
                toastMessageId = R.string.wrong_answer;
            }

            Toast
                    .makeText(MainActivity3.this, toastMessageId,
                            Toast.LENGTH_SHORT)
                    .show();
        }
}