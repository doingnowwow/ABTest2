package com.example.abtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    TabLayout tabLayout;
    ViewPager viewpager;
    MyAdapter adapter;

    //floating 버튼 역할
    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav);
        navigationView.setItemIconTintList(null);

        drawerLayout = findViewById(R.id.layout_drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerToggle.syncState();

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);

        fab = (FloatingActionButton) findViewById(R.id.btnFloat1);
        fab1 = (FloatingActionButton) findViewById(R.id.btnFloat2);
        fab2 = (FloatingActionButton) findViewById(R.id.btnFloat3);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);


        tabLayout = findViewById(R.id.layout_tab);
        //     TabLayout.Tab tab = null;

        //  tab = tabLayout.newTab().setIcon(R.drawable.ic_people_white_24dp);
        //    tabLayout.addTab(tab);
        //    tab = tabLayout.newTab().setIcon(R.drawable.ic_star_white_24dp);
        //    tabLayout.addTab(tab);

        viewpager = findViewById(R.id.pager);
        adapter = new MyAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);

        //아이콘을 삽입하고 싶다면..
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_people_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_star_white_24dp);

        //탭 변경 리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportActionBar().setSubtitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // 네비게이션바
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_addGroup:
                        break;
                    case R.id.menu_addMember:
                        break;
                    case R.id.menu_info:
                        break;
                    case R.id.menu_setting:
                        break;
                }

                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnFloat1:
                anim();
                Toast.makeText(this, "Floating Action Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnFloat2:
                anim();
                Toast.makeText(this, "Button1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnFloat3:
                anim();
                Toast.makeText(this, "Button2", Toast.LENGTH_SHORT).show();
                break;
        }


    }

    public void anim() {

        if (isFabOpen) {
            fab.setImageResource(R.drawable.image_ddang_white_24dp);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
        } else {
            fab.setImageResource(R.drawable.ic_clear_white_24dp);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
        }
    }


    public void onButton1Clicked(View view) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("ddd");
        arr.add("zdfasdf");

        Toast.makeText(getApplicationContext(), "버튼이 눌렸습니다!", Toast.LENGTH_LONG).show();
       ListView listView = view.findViewById(android.R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }

}
