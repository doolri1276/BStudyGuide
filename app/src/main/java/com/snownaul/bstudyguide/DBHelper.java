package com.snownaul.bstudyguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-03-20.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="StudyGuide.db";
    public static final String SG_TABLE="studyguide";
    public static final String SG_ID="id";
    public static final String SG_TITLE="title";
    public static final String SG_INFO="info";
    public static final String SG_FOLDER="folder";
    public static final String SG_FAVOR="favor";
    public static final String SG_DATE="date";
    public static final String SG_RECENT="recent";
    public static final String SG_ICON="icon";
    public static final String SG_ICONCOLOR="iconcolor";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("MyTag","DB : onCreate");
        db.execSQL("create table studyguide "+"(id integer primary key autoincrement, title text, info text, folder text, favor text, date text, recent text, icon int, iconcolor int, percentage int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists studyguide");

        onCreate(db);
    }

    public boolean insertSet(String title, String info, String folder, String favor, String date, String recent, int icon, int iconColor, int percentage, ArrayList<Question> questions){
        SQLiteDatabase rdb=this.getReadableDatabase();

        Cursor cursor = rdb.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name ='"+title+"'" , null);
        cursor.moveToFirst();

        if(cursor.getCount()>0){
            return false;
        }

        SQLiteDatabase wdb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(SG_TITLE,title);
        contentValues.put(SG_INFO,info);
        contentValues.put(SG_FOLDER,folder);
        contentValues.put(SG_FAVOR,favor);
        contentValues.put(SG_DATE,date);
        contentValues.put(SG_RECENT,recent);
        contentValues.put(SG_ICON,icon);
        contentValues.put(SG_ICONCOLOR,iconColor);
        contentValues.put("percentage",percentage);
        wdb.insert(SG_TABLE,null,contentValues);

//        Cursor res=wdb.rawQuery("select id from studyguide where title='"+title+"'",null);
//        int idid=res.getInt(0);


        wdb.execSQL("create table "+title+" (id integer primary key autoincrement, " +
                "favor text, question text, answerType int, answer text, correctAnswers " +
                "string, times int, correctTimes int, percentage int)");

        for(int i=0;i<questions.size();i++){
            Question question=questions.get(i);
            contentValues=new ContentValues();
            contentValues.put("favor",question.favor);
            contentValues.put("question", question.question);
            contentValues.put("answerType",question.answerType);
            String s="";
            for(int j=0;j<question.answers.size();j++){
                s+=question.answers.get(j)+"|";
            }
            contentValues.put("answer",s);
            contentValues.put("correctAnswers",question.correctAnswers);
            contentValues.put("times",question.times);
            contentValues.put("correctTimes",question.correctTimes);
            contentValues.put("percentage",question.percentage);
            wdb.insert(title,null,contentValues);

        }


        return true;
    }

    public int numberOfSets(){
        SQLiteDatabase db=this.getReadableDatabase();
        int numSets=(int) DatabaseUtils.queryNumEntries(db,SG_TITLE);
        return numSets;
    }

    public ArrayList<Set> getAllSets(){
        ArrayList<Set> sets=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from studyguide",null);
        res.moveToFirst();
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

        int i=1;
        while(res.isAfterLast()==false){
            i++;
            id=res.getInt(res.getColumnIndex(SG_ID));

            title=res.getString(res.getColumnIndex(SG_TITLE));
            info=res.getString(res.getColumnIndex(SG_INFO));
            folder=res.getString(res.getColumnIndex(SG_FOLDER));
            favor=res.getString(res.getColumnIndex(SG_FAVOR));
            date=res.getString(res.getColumnIndex(SG_DATE));
            recent=res.getString(res.getColumnIndex(SG_RECENT));
            icon=res.getInt(res.getColumnIndex(SG_ICON));
            iconColor=res.getInt(res.getColumnIndex(SG_ICONCOLOR));
            percentage=res.getInt(res.getColumnIndex("percentage"));
            Set set=new Set(id,title,info,folder,favor,date,recent,icon,iconColor, percentage);
            sets.add(set);
            String s=sets.get(sets.size()-1).toString();
            Log.i("MyTag",s);
            res.moveToNext();
        }
        Log.i("MyTag","set의 갯수 : "+sets.size());
        return sets;

    }


}
