package com.snownaul.bstudyguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class SetDetailStorageActivity extends AppCompatActivity {

    ArrayList<Question> questions;

    RecyclerView recyclerView;
    SetDetailStorageAdapter storageAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail_storage);

        Intent intent=getIntent();
        int setId=intent.getIntExtra("id",-1);

        DBHelper dbHelper=new DBHelper(this);

        questions=dbHelper.getQuestions(setId);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Storage");

        recyclerView=findViewById(R.id.recycler);
        storageAdapter=new SetDetailStorageAdapter(this,questions);
        recyclerView.setAdapter(storageAdapter);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                finish();
                return true;

        }







        return super.onOptionsItemSelected(item);
    }
}
