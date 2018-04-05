package com.snownaul.bstudyguide;

import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-03-20.
 */

public class Set {

    int id;
    String title;
    String info;
    String folder;
    String favor;
    String date;
    String recent;
    int icon;
    int iconColor;
    int percentage;
    ArrayList<Question> questions;

    public Set(String title, String info, String folder, String favor, String date, String recent, int icon, int iconColor) {
        this.title = title;
        this.info = info;
        this.folder = folder;
        this.favor = favor;
        this.date = date;
        this.recent = recent;
        this.icon = icon;
        this.iconColor = iconColor;
        percentage=0;
    }

    public Set(int id, String title, String info, String folder, String favor, String date, String recent, int icon, int iconColor, int percentage) {
        this.id = id;
        this.title = title;
        this.info=info;
        this.folder = folder;
        this.favor = favor;
        this.date = date;
        this.recent = recent;
        this.icon = icon;
        this.iconColor = iconColor;
        this.percentage=percentage;
    }

    @Override
    public String toString() {
        String str="<세트 정보입니다!>\n" +
                "세트 아이디 : "+id+"\n" +
                "세트 타이틀 : "+title+"\n"+
                "세트 인포 : "+info+"\n"+
                "세트 폴더 : "+folder+"\n"+
                "세트 좋아요 : "+favor+"\n"+
                "세트 만든날짜 : "+date+"\n"+
                "세트 최근 사용 : "+recent+"\n"+
                "세트 아이콘 아이디 : "+icon+"\n"+
                "세트 아이콘 색 : "+iconColor+"\n"+
                "세트 퍼센트 : "+percentage+"\n" +
                "<끝입니다>===========\n\n";




        return str;
    }
}
