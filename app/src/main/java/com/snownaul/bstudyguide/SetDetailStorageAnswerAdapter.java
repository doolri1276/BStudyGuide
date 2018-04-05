package com.snownaul.bstudyguide;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-04-03.
 */

public class SetDetailStorageAnswerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Answer> answers;

    public SetDetailStorageAnswerAdapter(Context context, ArrayList<Answer> answers) {
        this.context = context;
        this.answers = answers;
        Log.i("MyTag","과연 answers가 null이더냐..."+(answers==null));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.layout_storage_listanswers,parent,false);
        VH vh=new VH(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        Answer answer=answers.get(position);


        vh.cbAnswer.setChecked(answer.isChecked);
        Log.i("MyTag","끄아아ㅏㅇㅇ 왜 안되냐고오옹! : "+answer.answer+"");

        vh.tvAnswer.setText(answer.answer);
        if(answer.isChecked){
            vh.tvAnswer.setTextColor(0xFF4B4B4B);
            vh.tvAnswer.setTypeface(Typeface.DEFAULT_BOLD);
        }else{
            vh.tvAnswer.setTextColor(0xffaaaaaa);
            vh.tvAnswer.setTypeface(null,Typeface.NORMAL);
        }


    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    class VH extends RecyclerView.ViewHolder{
        CheckBox cbAnswer;
        TextView tvAnswer;

        public VH(View itemView) {
            super(itemView);

            cbAnswer=itemView.findViewById(R.id.cb_answer);
            tvAnswer=itemView.findViewById(R.id.tv_answer);


        }
    }
}
