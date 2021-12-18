package com.example.quizapplication;

public class Question {


        // answerResId will store question
        private int answerResId;

        // answerTrue will store correct answer
        // of the question provided
        private String answerTrue;

        public Question(int answerResId, String answerTrue)
        {
            // setting the values through
            // arguments passed in constructor
            this.answerResId = answerResId;
            this.answerTrue = answerTrue;
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


}
