package com.snownaul.bstudyguide;

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


}
