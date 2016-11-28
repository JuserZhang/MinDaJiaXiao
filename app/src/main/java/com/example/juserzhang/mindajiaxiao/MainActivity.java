package com.example.juserzhang.mindajiaxiao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tv_Register;
    private TextView tv_Terms;
    private AutoCompleteTextView acto_Username;
    private Button btn_Login ;
    static final String[] str = new String[]{"abandon", "absolute", "absorb", "aid", "best", "bound",
            "desk","JuserZhang","张鹏"};
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


      /*
         自动补全文本框
       */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, str);
        //将字符串内容导入适配器
        acto_Username = (AutoCompleteTextView) findViewById(R.id.actv_username);
        acto_Username.setThreshold(1);//设置自动补全的阈值，1即为从第一位开始补全
        acto_Username.setAdapter(adapter);//通过适配器获得字符内容


        /*
          沉浸式状态栏
        */
        //状态栏 @ 顶部
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        //导航栏 @ 底部
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//透明导航栏


          /*
           PersionHome页面跳转
          */
        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PersionHome.class);
                startActivity(intent);
//                MainActivity.this.finish();
            }
        });

        /*
           Terms页面跳转
          */
        tv_Terms = (TextView) findViewById(R.id.tv_terms);
        tv_Terms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Terms.class);
                startActivity(intent);
//                MainActivity.this.finish();
            }
        });

        /*
          Register页面跳转
         */
        tv_Register = (TextView) findViewById(R.id.tv_Register);
        tv_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}


