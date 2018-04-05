package com.snownaul.bstudyguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-03-21.
 */

public class AddSetAdapter extends RecyclerView.Adapter{

    Context context;

    AnswersAdapter answersAdapter;

    public AddSetAdapter(Context context) {
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView=LayoutInflater.from(context).inflate(R.layout.layout_addset,parent,false);
        VH holder=new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        Log.i("MyTag","재사용되었다.");

        VH vh=(VH)holder;
        Question question =G.newQuestions.get(position);

        vh.tvQuestionNum.setText(position+1+"");
        vh.etQuestion.setText(question.question);

        answersAdapter=new AnswersAdapter(context,question.answers);
        vh.recyclerView.setAdapter(answersAdapter);

        vh.etQuestion.setText(question.question);


    }

    @Override
    public int getItemCount() {
        return G.newQuestions.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView tvQuestionNum;
        ImageView ivClear;
        EditText etQuestion;
        RecyclerView recyclerView;
        ImageView ivAddAnswer;


        public VH(View itemView) {
            super(itemView);

            tvQuestionNum=itemView.findViewById(R.id.tv_question_num);
            ivClear=itemView.findViewById(R.id.iv_clear);
            etQuestion=itemView.findViewById(R.id.et_question);
            recyclerView=itemView.findViewById(R.id.recycler);
            ivAddAnswer=itemView.findViewById(R.id.iv_add_answer);

            ivClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    G.newQuestions.remove(G.newQuestions.get(getLayoutPosition()));
                    AddSetAdapter.this.notifyItemRemoved(getLayoutPosition());
                    AddSetAdapter.this.notifyItemRangeChanged(getLayoutPosition(),
                            G.newQuestions.size()-getLayoutPosition());

                }
            });

            ivAddAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Question question =G.newQuestions.get(getLayoutPosition());
                    question.answers.add(new Answer());
                    answersAdapter.notifyItemInserted(question.answers.size()-1);
                    recyclerView.scrollToPosition(question.answers.size()-1);
                }
            });

            etQuestion.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Question question=G.newQuestions.get(getLayoutPosition());
                    question.question=s.toString();

                    Log.i("MyTag",getLayoutPosition()+"번째 문제 : "+question.question);


                }
            });



        }
    }
}
