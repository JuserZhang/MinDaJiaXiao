package com.example.juserzhang.mindajiaxiao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class PersionHome extends Activity implements
        android.view.View.OnClickListener {

    private ViewPager mViewPager;// 用来放置界面切换
    private PagerAdapter mPagerAdapter;// 初始化View适配器
    private List<View> mViews = new ArrayList<View>();// 用来存放Tab01-04
    // 四个Tab，每个Tab包含一个按钮
    private LinearLayout mTabHome;
    private LinearLayout mTabFonnd;
    private LinearLayout mTabCar;
    private LinearLayout mTabSetting;
    // 四个按钮
    private ImageButton mHome;
    private ImageButton mFound;
    private ImageButton mCar;
    private ImageButton mSetting;

    private ImageButton  mIBCoach;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.personal_home);
       /*
          沉浸式状态栏
        */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//透明导航栏

        //初始化找教练页面下的找教练按钮
        mIBCoach=(ImageButton) findViewById(R.id.ib_search_coach);
        mIBCoach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersionHome.this, Coach.class);
                startActivity(intent);
            }
        });

        initView();
        initViewPage();
        select();
        initEvent();

    }


    /**
     * 初始化设置
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpage);
        // 初始化四个LinearLayout
        mTabHome = (LinearLayout) findViewById(R.id.ll_home);
        mTabFonnd = (LinearLayout) findViewById(R.id.ll_contacts);
        mTabCar = (LinearLayout) findViewById(R.id.ll_car);
        mTabSetting = (LinearLayout) findViewById(R.id.ll_service);
        // 初始化四个按钮
        mHome = (ImageButton) findViewById(R.id.ib_home);
        mFound = (ImageButton) findViewById(R.id.ib_contacts);
        mCar = (ImageButton) findViewById(R.id.ib_car);
        mSetting = (ImageButton) findViewById(R.id.ib_service);

    }

    /**
     * 初始化ViewPage
     */
    private void initViewPage() {

        // 初始化四个布局
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View tab01 = mLayoutInflater.inflate(R.layout.tab_home, null);
        View tab02 = mLayoutInflater.inflate(R.layout.contacts,null);
        View tab03 = mLayoutInflater.inflate(R.layout.tab_car, null);
        View tab04 = mLayoutInflater.inflate(R.layout.tab_setting, null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        // 适配器初始化并设置
        mPagerAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mViews.get(position));

            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return mViews.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void initEvent() {


        mTabHome.setOnClickListener(this);
        mTabFonnd.setOnClickListener(this);
        mTabCar.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             *ViewPage左右滑动时
             */
            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        resetImg();
                        mHome.setImageResource(R.drawable.home_pressed);
                        break;
                    case 1:
                        resetImg();
                        mFound.setImageResource(R.drawable.coach_pressed);
                        break;
                    case 2:
                        resetImg();
                        mCar.setImageResource(R.drawable.car_preassed);
                        break;
                    case 3:
                        resetImg();
                        mSetting.setImageResource(R.drawable.setting_pressed);
                        break;
                    default:
                        break;
                }
            }


            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /**
     * 默认选中主页home
     */
    private void select() {
        resetImg();
        mHome.setImageResource(R.drawable.home_pressed);
    }

    /**
     * 判断哪个要显示，及设置按钮图片
     */
    @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
            case R.id.ll_home:
                mViewPager.setCurrentItem(0);
                resetImg();
                mHome.setImageResource(R.drawable.home_pressed);
                break;
            case R.id.ll_contacts:
                mViewPager.setCurrentItem(1);
                resetImg();
                mFound.setImageResource(R.drawable.coach_pressed);
                break;

            case R.id.ll_car:
                mViewPager.setCurrentItem(2);
                resetImg();
                mCar.setImageResource(R.drawable.car_preassed);
                break;
            case R.id.ll_service:
                mViewPager.setCurrentItem(3);
                resetImg();
                mSetting.setImageResource(R.drawable.setting_pressed);
                break;

            default:
                break;
        }
    }

    /**
     * 把所有图片变暗
     */
    private void resetImg() {
        mHome.setImageResource(R.drawable.home_32);
        mFound.setImageResource(R.drawable.coach_32);
        mCar.setImageResource(R.drawable.car_32);
        mSetting.setImageResource(R.drawable.setting_32);
    }

}
