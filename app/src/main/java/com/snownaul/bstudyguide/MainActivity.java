package com.snownaul.bstudyguide;


import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    ArrayList<Set> sets;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    ActionBarDrawerToggle drawerToggle;

    //AHBottomNavigation bottomNavigation;

    ViewPager pager;
    FragAdapter fragAdapter;
    BottomNavigationView bottomNavigationView;
    MenuItem prevMenuItem;
    NestedScrollView nestedScrollView;

    FragmentManager fragmentManager;


    android.support.v4.app.Fragment[] frags=new android.support.v4.app.Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DBHelper(this);
        sets=dbHelper.getAllSets();




        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView=findViewById(R.id.navigation_view);

        //navigationView.setItemIconTintList(null);


        //navigation아이콘을 누를때 불려지는 기능
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });

        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.appbar_scrolling_view_behavior,R.string.bottom_sheet_behavior);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        navigationView.setItemIconTintList(null);


//        nestedScrollView=findViewById(R.id.nestedscrolllview);
//        nestedScrollView.setFillViewport(true);

        pager=findViewById(R.id.pager);
        fragAdapter=new FragAdapter(getSupportFragmentManager());
        pager.setAdapter(fragAdapter);

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Log.i("MyTag","불려진 아이 : "+item.getItemId());

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.navigation_dashboard:
                        pager.setCurrentItem(1);
                        break;
                    case R.id.navigation_notifications:
                        pager.setCurrentItem(2);
                        break;
                }


                return false;
            }

        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(prevMenuItem!=null){
                    prevMenuItem.setChecked(false);
                }else{
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem=bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        fragmentManager=getSupportFragmentManager();




    }

    @Override
    protected void onResume() {
        super.onResume();






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerToggle.onOptionsItemSelected(item);


        return super.onOptionsItemSelected(item);
    }


}
