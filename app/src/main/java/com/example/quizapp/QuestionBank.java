package com.example.quizapp;

public class QuestionBank {

    private String textQuestion[] = {
            "1. What are the pyramids located?",
            "2. Where does Cristiano Ronaldo play?",
            "3. What is the capital of germany?",
            "4. What is the team that won the most World Cup?",
            "5. In which city the Big Ben clock located?"
    };
    private String multipleChoice[][] = {
            {"Giza", "Berlin", "Paris", "Abu Dhabi"},
            {"Real Madrid", "Liverpool", "Byern Munich", "Juventus"},
            {"Berlin", "Munich", "Dusseldorf", "and Cologne"},
            {"Barazil", "Germany", "France", "Spain"},
            {"London", "New York", "Milan", "Madrid"}
    };
    // array of correct answer - in the same order as array of questions
    private String mCorrectAnswer[] =
            {"Giza", "Liverpool", "and Cologne", "France", "Milan"};

    // method return number of question
    public int getLength() {
        return textQuestion.length;
    }

    // method return question from array textQuestion[] based of array index
    public String getQuestion(int a) {
        String question = textQuestion[a];
        return question;
    }
    // method return a single multiple choice items for question based on array index,
    //based on number of muliple choice in the item list - 1,2,3,4 and 5 as an argument
    public String getChoice(int index, int num) {
     String choice0 = multipleChoice[index][num-1];
     return choice0;
    }

    //method return correct answer for the question based on array index
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }

}
