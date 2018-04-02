package com.snownaul.bstudyguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class SetDetailActivity extends AppCompatActivity {

    SearchView searchView;

    Set set;
    ArrayList<Question> questions;

    ToggleButton tgFavor;
    TextView tvFolder;
    TextView tvTitle;
    TextView tvInfo;

    TextView tvUser;
    TextView tvRecent;

    TextView tvQuetionsCnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail);

        Intent intent=getIntent();

        int id=intent.getIntExtra("id",-1);

        if(id==-1){
            Log.i("MyTag","SetDetailActivity : intent에서 받아온 값이 -1");
            finish();
        }

        set=G.dbHelper.getASet(id);

        if(set==null){
            Log.i("MyTag","SetDetailActivity : db에서 받아온 set이 null");
            finish();
        }

        questions=G.dbHelper.getQuestions(id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tgFavor=findViewById(R.id.tg_favor);
        tvFolder=findViewById(R.id.tv_folder);
        tvTitle=findViewById(R.id.tv_title);
        tvInfo=findViewById(R.id.tv_info);
        tvUser=findViewById(R.id.tv_user);
        tvRecent=findViewById(R.id.tv_recent);
        tvQuetionsCnt=findViewById(R.id.tv_questionscnt);

        tgFavor.setChecked(Boolean.parseBoolean(set.favor));
        tvFolder.setText(set.folder);
        tvTitle.setText(set.title);
        getSupportActionBar().setTitle("");
        tvInfo.setText(set.info);
        tvRecent.setText(set.recent);
        if(questions!=null){
            tvQuetionsCnt.setText(questions.size()+"");
        }







    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){

            case android.R.id.home:
                finish();
                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_set_detail,menu);

        MenuItem item=menu.findItem(R.id.menu_search);
        searchView=(SearchView)item.getActionView();



        return super.onCreateOptionsMenu(menu);
    }

    public void clickStorage(View v){
        Intent intent=new Intent(this,SetDetailStorageActivity.class);
        intent.putExtra("title",set.title);
        intent.putExtra("id",set.id);
        startActivity(intent);

    }

    public void clickStudy(View v){

    }

    public void clickPlay(View v){

    }

    public void clickReport(View v){

    }
}
