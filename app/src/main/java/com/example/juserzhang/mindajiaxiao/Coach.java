package com.example.juserzhang.mindajiaxiao;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JuserZhang on 2016/10/13.
 */

public class Coach extends Activity {
    private SimpleAdapter simpleAdapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach);

        /*
          沉浸式状态栏
        */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//透明导航栏


        list = (ListView) findViewById(R.id.MyListView);
        //person_item.xml为教练信息项布局
        simpleAdapter = new SimpleAdapter(Coach.this, getMyData(), R.layout.my_listitem,
                new String[]{"photo", "school", "sex", "star_level", "detail"},
                new int[]{
                        R.id.image_photo,
                        R.id.tv_school,
                        R.id.tv_sex,
                        R.id.tv_start_level,
                        R.id.tv_detail});
        list.setAdapter(simpleAdapter);

    }
    /*
    第一个context，很明显大家根据英文可以知道是上下文的意思，它官方的意思是：SimpleAdapter所要运行关联到的视图，这个是什么呢？
    就是你这个SimpleAdapter所在的Activity（一般而言），所以这个参数一般是“前Activity的名字.this”

    第二个是一个泛型只要是一个List就行，这一般会想到是ArrayList，而他内部存储的则是Map或者继承自Map的对象，比如HashMap，
    这些语法都是Java的基本语法，不再详述了！这里呢是作为数据源，而且每一个ArraList中的一行就代表着呈现出来的一行，
    Map的键就是这一行的列名，值也是有列名的。

    第三个资源文件，就是说要加载这个两列所需要的视图资源文件，一般在Layout建立相应的.xml文件，
    你可以左边一个TextView右边一个TextView，目的在于呈现左右两列的值！

    第四个参数是一个String数组，主要是将Map对象中的名称映射到列名，一一对应

    第五个是将第四个参数的值一一对象的显示（一一对应）在接下来的int形的id数组中，
    这个id数组就是LayOut的xml文件中命名id形成的唯一的int型标识符
    * */

    private List<Map<String, Object>> getMyData() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
        Map<String, Object> mMap = new HashMap<String, Object>();
                            mMap.put("photo", R.drawable.a);
                            mMap.put("school", "民大驾校");
                            mMap.put("sex", "男");
                            mMap.put("star_level", "3星级");
                            mMap.put("detail", "•••");
                            mList.add(mMap);

                            mMap = new HashMap<String, Object>();
                            mMap.put("photo", R.drawable.b);
                            mMap.put("school", "鼠星驾校");
                            mMap.put("sex", "女");
                            mMap.put("star_level", "5星级");
                            mMap.put("detail", "•••");
                            mList.add(mMap);


                            mMap = new HashMap<String, Object>();
                            mMap.put("photo", R.drawable.c);
                            mMap.put("school", "民大驾校");
                            mMap.put("sex", "女");
                            mMap.put("star_level", "3星级");
                            mMap.put("detail", "•••");
                            mList.add(mMap);


                            mMap = new HashMap<String, Object>();
                            mMap.put("photo", R.drawable.d);
                            mMap.put("school", "鼠星驾校");
                            mMap.put("sex", "男");
                            mMap.put("star_level", "4星级");
                            mMap.put("detail", "•••");
                            mList.add(mMap);

                            mMap = new HashMap<String, Object>();
                            mMap.put("photo", R.drawable.e);
                            mMap.put("school", "鼠星驾校");
                            mMap.put("sex", "男");
                            mMap.put("star_level", "4星级");
                            mMap.put("detail", "•••");
                            mList.add(mMap);

                            mMap = new HashMap<String, Object>();
                            mMap.put("photo", R.drawable.f);
                            mMap.put("school", "民大驾校");
                            mMap.put("sex", "女");
                            mMap.put("star_level", "4星级");
                            mMap.put("detail", "•••");
                            mList.add(mMap);

                            mMap = new HashMap<String, Object>();
                            mMap.put("photo", R.drawable.g);
                            mMap.put("school", "民大驾校");
                            mMap.put("sex", "男");
                            mMap.put("star_level", "4星级");
                            mMap.put("detail", "•••");
                            mList.add(mMap);
                            return mList;

    }
}
