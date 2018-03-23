package com.snownaul.bstudyguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class SetDetailActivity extends AppCompatActivity {

    String title;
    Set set;

    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail);

        Intent intent=getIntent();

        DBHelper dbHelper=new DBHelper(this);
        int id=intent.getIntExtra("id",-1);

        if(id==-1){
            Log.i("MyTag","SetDetailActivity : intent에서 받아온 값이 -1");
            finish();
        }

        set=dbHelper.getASet(id);

        if(set==null){
            Log.i("MyTag","SetDetailActivity : db에서 받아온 set이 null");
            finish();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTitle=findViewById(R.id.tv_title);
        tvTitle.setText(set.title);


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
}
