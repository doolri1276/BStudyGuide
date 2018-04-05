package com.snownaul.bstudyguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-03-30.
 */

public class SetDetailStorageAdapter extends RecyclerView.Adapter {

    Context context;

    SetDetailStorageAnswerAdapter answersAdapter;


    public SetDetailStorageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.layout_storage_list,parent,false);
        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        Question t=G.questions.get(position);

        vh.tgFavor.setChecked(Boolean.parseBoolean(t.favor));
        vh.tvQuestionNum.setText(position+1+"");
        vh.tvQuestion.setText(t.question);

        int answercnt=0;
        for(Answer a: t.answers){
            if(a.isChecked)answercnt++;
        }

        vh.tvAnswerNum.setText("("+answercnt+" Answers)");
        answersAdapter=new SetDetailStorageAnswerAdapter(context,t.answers);
        vh.recyclerView.setAdapter(answersAdapter);



    }

    @Override
    public int getItemCount() {
        return G.questions.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ToggleButton tgFavor;
        TextView tvQuestionNum;
        ImageView ivEdit;
        TextView tvQuestion;
        TextView tvAnswerNum;
        RecyclerView recyclerView;

        public VH(View itemView) {
            super(itemView);

            tgFavor=itemView.findViewById(R.id.tg_favor);
            tvQuestionNum=itemView.findViewById(R.id.tv_question_num);
            ivEdit=itemView.findViewById(R.id.iv_edit);
            tvQuestion=itemView.findViewById(R.id.tv_question);
            tvAnswerNum=itemView.findViewById(R.id.tv_answer_num);
            recyclerView=itemView.findViewById(R.id.recycler);

            tgFavor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    G.dbHelper.updateQuestionFavor(getLayoutPosition(),isChecked);
                }
            });



        }
    }
}
