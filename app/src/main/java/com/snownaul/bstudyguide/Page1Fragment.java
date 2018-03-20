package com.snownaul.bstudyguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alfo6-11 on 2018-03-20.
 */

public class Page1Fragment extends Fragment {

    CardView btnAddSet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page1,container,false);

        btnAddSet=view.findViewById(R.id.btn_addset);
        btnAddSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),AddSetActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }


}
