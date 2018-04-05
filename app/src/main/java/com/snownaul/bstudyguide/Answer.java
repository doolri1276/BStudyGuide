package com.snownaul.bstudyguide;

/**
 * Created by alfo6-11 on 2018-03-21.
 */

public class Answer {

    boolean isChecked=false;
    String answer="";

    public Answer() {

    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public Answer(boolean isChecked, String answer) {

        this.isChecked = isChecked;
        this.answer = answer;
    }
}
