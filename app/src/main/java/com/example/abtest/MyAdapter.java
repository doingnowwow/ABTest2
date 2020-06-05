package com.example.abtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] fragments = new Fragment[2];
//    String[] pageTitles = new String[]{};

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0] = new PageFragment();
        fragments[1] = new PageFragment2();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    //뷰페이저와 연동된 텝레이아웃의 탭버튼들의
    //글씨를 리턴해주는 메소드
    /*@Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }*/
}
