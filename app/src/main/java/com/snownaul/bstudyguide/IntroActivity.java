package com.snownaul.bstudyguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    LinearLayout layoutIntro;
    TextView tvMadeBy;

    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        G.dbHelper=new DBHelper(this);


        G.dbHelper.getAllSets();

        getSupportActionBar().hide();

        layoutIntro=findViewById(R.id.layout_intro);
        tvMadeBy=findViewById(R.id.tv_madeby);

        Animation ani= AnimationUtils.loadAnimation(this,R.anim.appear_logo);
        layoutIntro.startAnimation(ani);
        ani=AnimationUtils.loadAnimation(this,R.anim.appear_madeby);
        tvMadeBy.startAnimation(ani);





        timer.schedule(task,3000);

    }

    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
