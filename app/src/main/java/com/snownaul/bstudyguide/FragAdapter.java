package com.snownaul.bstudyguide;

import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alfo6-11 on 2018-03-20.
 */

public class FragAdapter extends FragmentPagerAdapter {

    Fragment[] frags=new Fragment[3];


    public FragAdapter(FragmentManager fm) {
        super(fm);

        frags[0]=new Page1Fragment();
        frags[1]=new Page2Fragment();
        frags[2]=new Page3Fragment();
    }

    @Override
    public Fragment getItem(int position) {
        return frags[position];
    }

    @Override
    public int getCount() {
        return frags.length;
    }
}
