package com.example.quizapplication;

public class Question {


        // answerResId will store question
        private int answerResId;

        // answerTrue will store correct answer
        // of the question provided
        private String answerTrue;
    int op1;int op2; int op3;int op4;

        public Question(int answerResId, String answerTrue, int op1,int op2, int op3,int op4)
        {
            // setting the values through
            // arguments passed in constructor
            this.answerResId = answerResId;
            this.answerTrue = answerTrue;
            this.op1=op1;
            this.op2=op2;
            this.op3=op3;
            this.op4=op4;
        }

        // returning the question passed
        public int getAnswerResId()
        {
            return answerResId;
        }

        // setting the question passed
        public void setAnswerResId(int answerResId)
        {
            this.answerResId = answerResId;
        }

        // returning the correct answer
        // of question
        public String isAnswerTrue()
        {
            return answerTrue;
        }

        // setting the correct
        // ans of question
        public void setAnswerTrue(String answerTrue)
        {
            this.answerTrue = answerTrue;
        }
        public int getoption1(){
            return op1;
        }
    public int getoption2(){
        return op2;
    }
    public int getoption3(){
        return op3;
    }
    public int getoption4(){
        return op4;
    }

}
