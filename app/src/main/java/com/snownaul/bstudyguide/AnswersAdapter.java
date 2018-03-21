package com.snownaul.bstudyguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-03-21.
 */

public class AnswersAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Answer> answers;

    public AnswersAdapter(Context context, ArrayList<Answer> answers) {
        this.context = context;
        this.answers = answers;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(context).inflate(R.layout.layout_answers,parent,false);
        VH vh=new VH(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        Answer answer=answers.get(position);
        vh.cbAnswer.setChecked(answer.isChecked);
        vh.etAnswer.setText(answer.answer);


    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    class VH extends RecyclerView.ViewHolder{

        CheckBox cbAnswer;
        EditText etAnswer;

        public VH(View itemView) {
            super(itemView);

            cbAnswer=itemView.findViewById(R.id.cb_answer);
            etAnswer=itemView.findViewById(R.id.et_answer);

            cbAnswer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Answer answer=answers.get(getLayoutPosition());
                    answer.isChecked=isChecked;
                }
            });

            etAnswer.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    Answer answer=answers.get(getLayoutPosition());
                    answer.answer=s.toString();
                }
            });

        }
    }

}
