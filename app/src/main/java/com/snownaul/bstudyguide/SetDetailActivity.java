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

        if(G.set==null){
            Log.i("MyTag","SetDetailActivity : 지금 설정된 set이 없다.");
            finish();
        }

        G.dbHelper.getQuestions();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tgFavor=findViewById(R.id.tg_favor);
        tvFolder=findViewById(R.id.tv_folder);
        tvTitle=findViewById(R.id.tv_title);
        tvInfo=findViewById(R.id.tv_info);
        tvUser=findViewById(R.id.tv_user);
        tvRecent=findViewById(R.id.tv_recent);
        tvQuetionsCnt=findViewById(R.id.tv_questionscnt);

        tgFavor.setChecked(Boolean.parseBoolean(G.set.favor));
        tvFolder.setText(G.set.folder);
        tvTitle.setText(G.set.title);
        getSupportActionBar().setTitle("");
        tvInfo.setText(G.set.info);
        tvRecent.setText(G.set.recent);
        if(G.questions!=null){
            tvQuetionsCnt.setText(G.questions.size()+"");
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
        startActivity(intent);

    }

    public void clickStudy(View v){
        Intent intent=new Intent(this,SetDetailStudyActivity.class);
        startActivity(intent);

    }

    public void clickPlay(View v){
        Intent intent=new Intent(this,SetDetailPlayActivity.class);
        startActivity(intent);
    }

    public void clickReport(View v){
        Intent intent=new Intent(this,SetDetailReportActivity.class);
        startActivity(intent);

    }
}
