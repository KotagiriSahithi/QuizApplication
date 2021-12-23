package com.example.quizapplication;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity
        implements View.OnClickListener {

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
    String value;
    RadioGroup rg ;

    private Question[] questionBank = new Question[] {
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Question(R.string.a1, "Causal",R.string.op211,R.string.op212,R.string.op213,R.string.op214),
            new Question(R.string.b1, "stripplot()",R.string.op221,R.string.op222,R.string.op223,R.string.op224),
            new Question(R.string.c1, "Open source",R.string.op231,R.string.op232,R.string.op233,R.string.op234),
            new Question(R.string.d1, "John Chambers",R.string.op241,R.string.op242,R.string.op243,R.string.op244),
            new Question(R.string.e1, "Command line interpreter",R.string.op251,R.string.op252,R.string.op253,R.string.op254),
            new Question(R.string.f1, "6",R.string.op261,R.string.op262,R.string.op263,R.string.op264),
            new Question(R.string.g1, "c()",R.string.op271,R.string.op272,R.string.op273,R.string.op274),
            new Question(R.string.h1, "Function",R.string.op281,R.string.op282,R.string.op283,R.string.op284),
            new Question(R.string.i1, "All of the mentioned",R.string.op291,R.string.op292,R.string.op293,R.string.op294),
            new Question(R.string.j1, "All steps should be noted",R.string.op2101,R.string.op2102,R.string.op2103,R.string.op2104),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up the buttons
        // associated with id
        // falseButton = findViewById(R.id.false_button);
        //trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        // register our buttons to listen to
        // click events
        questionTextView
                = findViewById(R.id.answer_text_view);
        Image = findViewById(R.id.myimage);
        //falseButton.setOnClickListener(this);
        //trueButton.setOnClickListener(this);
        option1 = findViewById(R.id.radioButton);
        option2 = findViewById(R.id.radioButton2);
        option3= findViewById(R.id.radioButton3);
        option4= findViewById(R.id.radioButton4);

        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        questionTextView.setText(R.string.a1);
        option1.setText(R.string.op211);
        option2.setText(R.string.op212);
        option3.setText(R.string.op213);
        option4.setText(R.string.op214);
        if(rg.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getApplicationContext(), "Please select an option...", Toast.LENGTH_SHORT).show();
        }
        else {
            value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
                    .getText().toString();
            checkAnswer(value);
        }
        //checkAnswer(value);
    }
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v)
    {
        // checking which button is
        // clicked by user
        // in this case user choose false
        if(rg.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getApplicationContext(), "Please select an option...", Toast.LENGTH_SHORT).show();
        }
        else {
            value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
                    .getText().toString();
            checkAnswer(value);
        }
        // a++;
        switch (v.getId()) {

            case R.id.next_button:
                // go to next question
                // limiting question bank range
                a=0;
                if (currentQuestionIndex <11) {
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
                        option1.setVisibility(
                                View.INVISIBLE);
                        option2.setVisibility(
                                View.INVISIBLE);
                        option3.setVisibility(
                                View.INVISIBLE);
                        option4.setVisibility(
                                View.INVISIBLE);
                        if (correct > 3) {

                            questionTextView.setText(
                                    "CORRECTNESS IS " + correct
                                            + " "
                                            + "OUT OF 10");
                            Image.setImageResource(
                                    R.drawable.happy);
                            // showing correctness
                        }
                        else
                            Image.setImageResource(
                                    R.drawable.resu);
                        //questionTextView.setText(
                        //"Better Luck Next Time!");
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
                break;
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
        option1.setText(questionBank[currentQuestionIndex].getoption1());
        option2.setText(questionBank[currentQuestionIndex].getoption2());
        option3.setText(questionBank[currentQuestionIndex].getoption3());
        option4.setText(questionBank[currentQuestionIndex].getoption4());



        // setting the textview with new question
    }
    private void checkAnswer(String userChooseCorrect)
    {
        String answerIsTrue
                = questionBank[currentQuestionIndex].isAnswerTrue();
        // getting correct ans of current question
        int toastMessageId;
        // if ans matches with the
        // button clicked
        if(answerIsTrue!=null){
            if (userChooseCorrect.equals(answerIsTrue)) {
                toastMessageId = R.string.correct_answer;
                //if(a==1)
                correct++;
            }
            else {
                // showing toast
                // message correct
                //a=1;
                toastMessageId = R.string.wrong_answer;
            }
        }
        else
            toastMessageId=R.string.select_answer;

        Toast
                .makeText(MainActivity3.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}
