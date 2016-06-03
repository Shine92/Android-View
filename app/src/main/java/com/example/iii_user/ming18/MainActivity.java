package com.example.iii_user.ming18;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager; //沒有輪轉效果
    private LayoutInflater flater; //配置圖
    private ArrayList<View> views; //這三個畫面 不會進進出出 會的話用 LinkedList
    private ViewFlipper viewFlipper; //使用ViewFlipper生成同一layout但是不同view的方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        flater = LayoutInflater.from(this);
        pager = (ViewPager)findViewById(R.id.pager);

        initpager();


    }
    private void initpager(){

        views = new ArrayList<>(); //有順序性



        views.add(flater.inflate(R.layout.layout_p0, null));    //空頁
        views.add(flater.inflate(R.layout.layout_p1, null));    //紅
        views.add(flater.inflate(R.layout.layout_p2,null));     //綠
        views.add(flater.inflate(R.layout.layout_p3, null));    //藍
        views.add(flater.inflate(R.layout.layout_p4, null));    //空頁

        pager.setAdapter(new MyAdapter()); //ViewFlipperur加入調便器

        pager.setOnPageChangeListener(new MychangeListener()); //換頁會拉不動

        pager.setCurrentItem(1);    //設定一開始是第1頁

        View view2 = views.get(2); //拿第二個陣列

        viewFlipper = (ViewFlipper)view2.findViewById(R.id.viewFlipper);

        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewFlipper.showNext();
            }
        });

    }

    private class MyAdapter extends PagerAdapter{ //實作抽象方法  調便器

        @Override
        public int getCount() {

            return views.size(); //設定有幾頁
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object; //是否相同
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ((ViewPager)container).addView(views.get(position));

            //container容器 //position位置
            Log.i("ming","addView"+position);
            return views.get(position); //傳回views裡的位置 第幾頁
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.i("ming","removeView"+position);

            //super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }
    }
    private class MychangeListener extends ViewPager.SimpleOnPageChangeListener{
        @Override
        public void onPageSelected(int position) {  //選到哪一頁
            super.onPageSelected(position);
            //如果到第0頁就拉回第1頁
            if(position == 0){
                pager.setCurrentItem(1);
                //如果到第4頁就拉回第3頁
            }else if(position == 4){
                pager.setCurrentItem(3);
            }
        }
    }
    public void changeF(View view){

    }
}
