package com.example.juserzhang.mindajiaxiao;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;


public class splashScreen extends Activity {

    private ProgressBar LoginProgressBar;
    private Handler ProgressBarHandler;
    private int progress = 0;
    private int  max;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);



       /*
          沉浸式状态栏
        */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//透明导航栏




        //显示软件版本号
        PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo("com.example.juserzhang.mindajiaxiao", 0);
            TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
            versionNumber.setText("DesignBy JuserZhang © Version " + pi.versionName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }




        //初始化控件
        LoginProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        //处理动态加载滚动条
        //创建一个Handler
        ProgressBarHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //处理消息
                switch (msg.what)
                {
                    case 1: {
                        //设置滚动条
                        LoginProgressBar.setProgress(progress);
                        if (progress==100)
                        {
                             Intent Intent = new Intent(splashScreen.this, MainActivity.class);
                             splashScreen.this.startActivity(Intent);
                             splashScreen.this.finish();
                        }
                    }
                    break;
                    default:
                        break;
                }
            }
        };
        start();


    }

    private void start()
    {
        new  Thread(new Runnable() {
            @Override
            public void run() {
                 max = LoginProgressBar.getMax();
                try{
                    while (progress<max)
                    {
                        progress+=10;
                        Message msg = new Message();
                        //what就是一个标志，handle接受多个message的时候，进行区分给与对应操作的
                        msg.what=1;
                        ProgressBarHandler.sendMessage(msg);
                        Thread.sleep(500);
                    }

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
