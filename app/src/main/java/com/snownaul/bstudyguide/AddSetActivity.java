package com.snownaul.bstudyguide;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddSetActivity extends AppCompatActivity {

    ArrayList<Question> questions=new ArrayList<>();

    RecyclerView recyclerView;
    AddSetAdapter addSetAdapter;
//
    CardView cvAddQuestion;
    ImageView ivAddQuestion;

    EditText etTitle;
    EditText etInfo;

    DBHelper dbHelper;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_set);

        dbHelper=new DBHelper(this);

        questions.add(new Question());
        questions.add(new Question());
        questions.add(new Question());
        questions.add(new Question());
        questions.add(new Question());

        recyclerView=findViewById(R.id.recycler);
        addSetAdapter=new AddSetAdapter(this,questions);
        recyclerView.setAdapter(addSetAdapter);

        ivAddQuestion=findViewById(R.id.iv_add_question);
        ivAddQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questions.add(new Question());

                addSetAdapter.notifyItemInserted(questions.size()-1);
                recyclerView.scrollToPosition(questions.size()-1);

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etTitle=findViewById(R.id.et_title);
        etInfo=findViewById(R.id.et_info);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;
            case R.id.submit:
                if(etTitle.getText().toString().length()==0){
                   new SubmitDialogFragment().newInstance(1).show(getFragmentManager(),"TAG");
                   return false;
                }

                for(int i=0;i<questions.size();i++){
                    if(questions.get(i).question.length()==0){
                        new SubmitDialogFragment().newInstance(2).show(getFragmentManager(),"TAG2");
                        return false;
                    }

                    for(int j=0;j<questions.get(i).answers.size();j++){
                        if(questions.get(i).answers.get(j).answer.length()==0){
                            new SubmitDialogFragment().newInstance(3).show(getFragmentManager(),"TAG2");
                            return false;
                        }
                    }
                }

                String title=etTitle.getText().toString();
                String info=etInfo.getText().toString();
                String folder="default";
                String favor="false";
                String date=getTime();
                String recent=date;
                int icon=R.drawable.ic_brightness_1_black_24px;
                int iconColor=getResources().getColor(R.color.colorLightGray);
                Toast.makeText(this, iconColor+"", Toast.LENGTH_SHORT).show();
                int percent=0;

                //Boolean success=dbHelper.insertSet(title, info, folder, favor, date, recent, icon, iconColor, percent, questions);

//                if(success){
//                    Intent intent=new Intent(this,SetDetailActivity.class);
//                    intent.putExtra("title",title);
//                    intent.putExtra("info",info);
//                    intent.putExtra("folder",folder);
//                    intent.putExtra("favor",favor);
//                    intent.putExtra("date",date);
//                    intent.putExtra("recent",recent);
//                    intent.putExtra("icon",icon);
//                    intent.putExtra("iconColor",iconColor);
//                    startActivity(intent);
//                    finish();
//                }


        }

        return super.onOptionsItemSelected(item);
    }

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
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
            }
            builder.setPositiveButton("Close",null);

            return builder.create();
        }
    }


}
