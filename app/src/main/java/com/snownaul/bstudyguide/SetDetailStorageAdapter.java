package com.snownaul.bstudyguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    ArrayList<Question> questions;

    public SetDetailStorageAdapter(Context context, ArrayList<Question> questions) {
        this.context = context;
        this.questions = questions;
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
        Question t=questions.get(position);

        vh.tgFavor.setChecked(Boolean.parseBoolean(t.favor));
        vh.tvQuestionNum.setText(position+1+"");
        vh.tvQuestion.setText(t.question);
        vh.tvAnswerNum.setText("("+t.answers.size()+" Answers)");

        vh.ans01.setText(t.answers.get(0).answer);
        vh.ans02.setText(t.answers.get(1).answer);
        vh.ans03.setText(t.answers.get(2).answer);
        vh.ans04.setText(t.answers.get(3).answer);

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ToggleButton tgFavor;
        TextView tvQuestionNum;
        ImageView ivEdit;
        TextView tvQuestion;
        TextView tvAnswerNum;
        RecyclerView recyclerView;

        TextView ans01,ans02,ans03,ans04;

        public VH(View itemView) {
            super(itemView);

            tgFavor=itemView.findViewById(R.id.tg_favor);
            tvQuestionNum=itemView.findViewById(R.id.tv_question_num);
            ivEdit=itemView.findViewById(R.id.iv_edit);
            tvQuestion=itemView.findViewById(R.id.tv_question);
            tvAnswerNum=itemView.findViewById(R.id.tv_answer_num);
            recyclerView=itemView.findViewById(R.id.recycler);

            ans01=itemView.findViewById(R.id.ans01);
            ans02=itemView.findViewById(R.id.ans02);
            ans03=itemView.findViewById(R.id.ans03);
            ans04=itemView.findViewById(R.id.ans04);


        }
    }
}
