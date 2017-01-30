package com.example.gilsoo.viewpagertest2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.class.getSimpleName();
    public static final int COUNT = 5;
    ViewPager viewPager;
    CircularPagerAdapter circularPagerAdapter;
    int currentPosition = COUNT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }
    public void initLayout(){
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        circularPagerAdapter = new CircularPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(circularPagerAdapter);
        viewPager.setCurrentItem(COUNT);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d(TAG, "onPageScrolled - position: " + position +", positionOffset : " + positionOffset + ", positionOffsetPixels : " + positionOffsetPixels);
//                Log.d(TAG, "onPageScrolled position : " + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected - position: " + position);
                currentPosition = position;
//                if(currentPosition < COUNT) {             // 어색한 이유 : selected 되기 전에 position을 바꿔버림.. 3배해서 똑같은 화면을 만든 이유가 있음
//                    viewPager.setCurrentItem(currentPosition + COUNT, false);
//                }else if(currentPosition >= 2*COUNT){
//                    viewPager.setCurrentItem(currentPosition - COUNT, false);
//                }
            }


            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG, "onPageScrollStateChanged - position : "+currentPosition+"state : " + state);
                if(currentPosition < COUNT) {
                    viewPager.setCurrentItem(currentPosition + COUNT, false);
                }else if(currentPosition >= 2*COUNT){
                    viewPager.setCurrentItem(currentPosition - COUNT, false);
                }

            }
        });
    }

    class CircularPagerAdapter extends FragmentPagerAdapter{

        public CircularPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            position %= COUNT;
            switch(position){
                case 0:
                    fragment = ContentFragment.newInstance(String.valueOf(position+1));
                    break;
                case 1:
                    fragment = ContentFragment.newInstance(String.valueOf(position+1));
                    break;
                case 2:
                    fragment = ContentFragment.newInstance(String.valueOf(position+1));
                    break;
                case 3:
                    fragment = ContentFragment.newInstance(String.valueOf(position+1));
                    break;
                case 4:
                    fragment = ContentFragment.newInstance(String.valueOf(position+1));
                    break;

            }
            return fragment;
        }

        @Override
        public int getCount() {
            return COUNT * 3;
        }
    }
}

