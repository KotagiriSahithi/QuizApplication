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

public class MainActivity extends AppCompatActivity
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
            new Question(R.string.a, "server",R.string.op11,R.string.op12,R.string.op13,R.string.op14),
            new Question(R.string.b, "process migration",R.string.op21,R.string.op22,R.string.op23,R.string.op24),
            new Question(R.string.c, "same CLK",R.string.op31,R.string.op32,R.string.op33,R.string.op34),
            new Question(R.string.d, "stateless servers",R.string.op41,R.string.op42,R.string.op43,R.string.op44),
            new Question(R.string.e, "the remaining sites can continue operating",R.string.op51,R.string.op52,R.string.op53,R.string.op54),
            new Question(R.string.f, "all the processors are synchronized",R.string.op61,R.string.op62,R.string.op63,R.string.op64),
            new Question(R.string.g, "it's users,servers and storage devices are dispersed",R.string.op71,R.string.op72,R.string.op73,R.string.op74),
            new Question(R.string.h, "simplicity",R.string.op81,R.string.op82,R.string.op83,R.string.op84),
            new Question(R.string.i, "address messages with the process-id",R.string.op91,R.string.op92,R.string.op93,R.string.op94),
            new Question(R.string.j, "all of the above",R.string.op101,R.string.op102,R.string.op103,R.string.op104),

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
        option1.setText(R.string.op11);
        option2.setText(R.string.op12);
        option3.setText(R.string.op13);
        option4.setText(R.string.op14);
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
                .makeText(MainActivity.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}
