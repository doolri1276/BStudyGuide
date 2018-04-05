package com.snownaul.bstudyguide;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddSetActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AddSetAdapter addSetAdapter;
//
    CardView cvAddQuestion;
    ImageView ivAddQuestion;

    EditText etTitle;
    EditText etInfo;

    String title;
    String info;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void addAFullQuestion(String question, Answer a1, Answer a2, Answer a3, Answer a4){
        ArrayList<Answer> answers=new ArrayList<>();
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);
        answers.add(a4);
        G.newQuestions.add(new Question(question,  answers));
    }

    public void addDatas(){

        addAFullQuestion("다음 중 직접접근 저장장치에 해당되는 보조기억장치는?",
                new Answer("캐시 기억장치"),new Answer("레지스터"),
                new Answer("DRAM"),new Answer(true,"하드디스크")
                );

        addAFullQuestion("컴퓨터의 보조기억장치에 대한 설명으로 올바른 것은?",
                new Answer(true,"비휘발성 기억장치이다."),
                new Answer("주기억장치에 비해 빠르게 데이터를 처리할 수 있다."),
                new Answer("기억장치 계층 구조상 캐시 기억장치와 주기억장치 사이에 위치한다."),
                new Answer("저장할 데이터가 소량일 때는 주기억장치 대신 보조기억장치를 사용한다.")
        );

        addAFullQuestion("다음 중 디스크 어레이를 활용하는 목적에 해당되는 것은?",
                new Answer("보조기억장치의 비용을 절감한다."),
                new Answer(true,"데이터 저장의 신뢰성이나 성능을 높인다."),
                new Answer("보조기억장치의 전력 소모를 절감한다."),
                new Answer("보조기억장치의 휴대성을 높인다.")
        );

        addAFullQuestion("다음 중 WORM 형식의 광 디스크에 대한 올바른 설명은?",
                new Answer(true,"공백 상태로 제작된 디스크에 1회에 한해 기록할 수 있다."),
                new Answer("자기디스크처럼 자유롭게 재기록을 할 수 있다."),
                new Answer("약 1,000회 가량 재 기록을 할 수 있다."),
                new Answer("공장에서 데이터가 기록된 상태로 제작된다.")
        );

        addAFullQuestion("다음 중 SSD에 대한 설명으로 올바른 것은?",
                new Answer("플로피디스크라고도 부른다."),
                new Answer(true,"주로 플래시 메모리를 사용하여 가볍고 전력 소모가 적다."),
                new Answer("모터로 구동되므로 내구성이 떨어지는 보조기억장치이다."),
                new Answer("트랙의 형태가 나선형인 ROM 형태의 장치이다.")
        );

        addAFullQuestion("다음 중 시스템 소프트웨어에 해당되는 것은?",
                new Answer("워드프로세서"),
                new Answer("포토샵"),
                new Answer(true,"Windows 10"),
                new Answer("엑셀")
        );

        addAFullQuestion("다음 중 운영체제에 대한 설명으로 올바른 것은?",
                new Answer("컴퓨터를 운영하는 사람이나 조직을 의미한다."),
                new Answer("마이크로소프트 Windows 10은 오픈 소스 운영체제이다."),
                new Answer("응용 소프트웨어 유형에 해당되는 소프트웨어이다."),
                new Answer(true,"컴퓨터의 프로그램들이 원활하게 실행될 수 있도록 관리하고 지원하는 역할을 한다.")
        );

        addAFullQuestion("다음 중 데이터를 표 형식으로 구성하여 계산이나 분석 등을 할 수 있게 하는 소프트웨어는?",
                new Answer(true,"스프레드시트"),
                new Answer("안드로이드"),
                new Answer("워드프로세스"),
                new Answer("유틸리티 소프트웨어")
        );

        addAFullQuestion("다음 중 프로그래밍 언어에 대한 설명으로 올바른 것은?",
                new Answer("어셈블리어는 CPU가 직접 이해하고 실행할 수 있다."),
                new Answer("제2세대 언어는 인공지능 응용 개발용 언어이다."),
                new Answer("제3세대 언어인 고급언어는 언어 번역기가 필요 없다."),
                new Answer(true,"제4세대 언어는 리포트 생성, 데이터 조작 및 분석 등 기존 순차적 고급언어에 비해 높은 수준의 기능을 제공한다.")
        );

        addAFullQuestion("다음 중 자유 소프트웨어 운동과 관련이 깊은 것은?",
                new Answer("사유 소프트웨어"),
                new Answer("UNIX"),
                new Answer(true,"GNU 프로젝트"),
                new Answer("한글 워드프로세서")
        );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_set);

        G.newQuestions=new ArrayList<>();
        G.newSet=null;


        addDatas();

        recyclerView=findViewById(R.id.recycler);
        addSetAdapter=new AddSetAdapter(this);
        recyclerView.setAdapter(addSetAdapter);

        ivAddQuestion=findViewById(R.id.iv_add_question);
        ivAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G.newQuestions.add(new Question());

                addSetAdapter.notifyItemInserted(G.newQuestions.size()-1);
                recyclerView.scrollToPosition(G.newQuestions.size()-1);

            }
        });

        recyclerView.requestFocus();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Create a New Set");

        etTitle=findViewById(R.id.et_title);
        etInfo=findViewById(R.id.et_info);

//        etTitle.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                Log.i("MyTag","title onEditorAction");
//                return false;
//            }
//        });
//
//        etTitle.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.i("MyTag","title beforeTextChanged");
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.i("MyTag","title onTextChanged");
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                title=s.toString();
//                Log.i("MyTag","title 변경 : "+title);
//            }
//        });

//        etInfo.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                info=s.toString();
//                Log.i("MyTag","info 변경 : "+info);
//            }
//        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case android.R.id.home:
                intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.submit:

                //Set Check
                if(setCheckError()) return true;

                //newSet의 데이터를 다 넣는다.
                setNewSetData();

                //TODO: questions view들에 입력된 데이터를 어떻게 questions객체에 넣을 수 있을지??
                G.dbHelper.insertSet();

                G.newSet=null;
                G.newQuestions=null;

                intent=new Intent(this,SetDetailActivity.class);
                startActivity(intent);
                finish();

//                if(id!=-1){
//                    intent=new Intent(this,SetDetailActivity.class);
//                    intent.putExtra("id",id);
//                    startActivity(intent);
//                    finish();
//                }



        }

        return super.onOptionsItemSelected(item);
    }

    public boolean setCheckError(){
        if(etTitle.getText().toString().length()==0){
            new SubmitDialogFragment().newInstance(1).show(getFragmentManager(),"TAG");
            return true;
        }

        for(int i=0;i<G.newQuestions.size();i++){
            if(G.newQuestions.get(i).question.length()==0){
                new SubmitDialogFragment().newInstance(2).show(getFragmentManager(),"TAG2");
                return true;
            }

            boolean nothingChecked=true;

            for(int j=0;j<G.newQuestions.get(i).answers.size();j++){
                Answer answer=G.newQuestions.get(i).answers.get(j);
                if(answer.answer.length()==0){
                    new SubmitDialogFragment().newInstance(3).show(getFragmentManager(),"TAG2");
                    return true;
                }
                if(nothingChecked&&answer.isChecked)nothingChecked=false;

            }

            if(nothingChecked){
                new SubmitDialogFragment().newInstance(4).show(getFragmentManager(),"TAG3");
                return true;
            }
        }






        return false;
    }

    public void setNewSetData(){
        String title=etTitle.getText().toString();
        String info=etInfo.getText().toString();
        Log.i("MyTag","title : "+title);
        Log.i("MyTag","etInfo : "+info);

        String folder="Default";
        String favor="false";
        String date=getTime();
        String recent=date;
        int icon=R.drawable.ic_brightness_1_black_24px;
        int iconColor=getResources().getColor(R.color.colorLightGray);
        Toast.makeText(this, iconColor+"", Toast.LENGTH_SHORT).show();
        int percent=0;

        if(G.newSet==null) G.newSet=new Set(title,info,folder,favor,date,recent,icon,iconColor);
    }

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    public void submit(){

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_addset,menu);

        return super.onCreateOptionsMenu(menu);
    }


    public static class SubmitDialogFragment extends DialogFragment{
        static int i;

        public static SubmitDialogFragment newInstance(int num) {
            i=num;
            return new SubmitDialogFragment();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

            switch (i){
                case 1:
                    builder.setView(R.layout.dialog_notitle);
                    break;
                case 2:
                    builder.setView(R.layout.dialog_emptyquestion);
                    break;
                case 3:
                    builder.setView(R.layout.dialog_emptyanswer);
                    break;
                case 4:
                    builder.setView(R.layout.dialog_nothingselected);
                    break;
            }
            builder.setPositiveButton("Close",null);

            return builder.create();
        }
    }


}
