package com.snownaul.bstudyguide;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-03-21.
 */

public class Question {

    int id=0;
    String favor;
    String question;
    int answerType;
    ArrayList<Answer> answers=new ArrayList<>();
    String correctAnswers;
    int times=0;
    int correctTiems=0;
    int percentage=0;

    public Question(int id, String favor, String question, int answerType, ArrayList<Answer> answers) {
        this.id = id;
        this.favor = favor;
        this.question = question;
        this.answerType = answerType;
        this.answers = answers;
    }

    public Question(){

        favor="";
        question="";
        if(answers!=null && answers.size()==0)
            answers.add(new Answer());
        correctAnswers="";


    }
}