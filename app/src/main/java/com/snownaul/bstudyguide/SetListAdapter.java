package com.snownaul.bstudyguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

/**
 * Created by alfo6-11 on 2018-03-21.
 */

public class SetListAdapter extends RecyclerView.Adapter{

    Context context;
    ArrayList<Set> sets;

    public SetListAdapter(Context context, ArrayList<Set> sets) {
        this.context = context;
        this.sets = sets;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(context).inflate(R.layout.layout_recycler_sets,parent,false);
        VH vh=new VH(itemView);


        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        Set set=sets.get(position);

        vh.ivIcon.setImageResource(set.icon);
        vh.ivIcon.setColorFilter(context.getResources().getColor(set.iconColor));
        vh.tvTitle.setText(set.title);
        vh.tvRecent.setText(set.recent);
        vh.tgFavor.setChecked(Boolean.parseBoolean(set.favor));
        vh.tvPercentage.setText(set.percentage);

    }

    @Override
    public int getItemCount() {
        return sets.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvRecent;
        ToggleButton tgFavor;
        TextView tvPercentage;
        ImageView ivMenu;

        public VH(View itemView) {
            super(itemView);

            ivIcon=itemView.findViewById(R.id.iv_icon);
            tvTitle=itemView.findViewById(R.id.tv_title);
            tvRecent=itemView.findViewById(R.id.tv_recent);
            tgFavor=itemView.findViewById(R.id.tg_favor);
            tvPercentage=itemView.findViewById(R.id.tv_percentage);
            ivMenu=itemView.findViewById(R.id.iv_menu);









        }
    }
}
