package com.example.juserzhang.mindajiaxiao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.juserzhang.mindajiaxiao.R.drawable.e;


public class Register extends Activity {

    private Spinner sp;
    private ArrayAdapter<CharSequence> adapter;
    private RadioGroup rg_sex;
    private RadioButton rb_man ,rb_woman;
    private EditText et_password,et_repassword;
    private  Button btn_Submit,btn_Back ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        /*
          沉浸式状态栏
        */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);   //透明导航栏




      /*
      Spinner下拉列表
       */
       sp=(Spinner)findViewById(R.id.Spinner);
      // sp.setPrompt("请选择");//为下拉列表设置标题
       spinner_set();



        /*
        判断输入密码是否一致 ,并保存信息
        * */
        et_password=(EditText)findViewById(R.id.et_passeord);
        et_repassword=(EditText)findViewById(R.id.et_repassword);
         btn_Submit=(Button)findViewById(R.id.btn_Submit);
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1=et_password.getText().toString();
                String password2=et_repassword.getText().toString();


                    if (password1.equals("")||password2.equals("")){
                        Toast.makeText(Register.this, "请输入密码", 1000).show();
                    }
                    else if (!password1.equals(password2)) {
                        Toast.makeText(Register.this, "您输入的密码不一致,请重新输入", 1000).show();
                    }

                    else
                        passActivity();


            }
        });






        /*
        页面返回——跳回主页面
         */
        btn_Back=(Button)findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                passActivityBack();
            }
        });


       /*
       性别选择
        */
        rg_sex=(RadioGroup)findViewById(R.id.rg_Sex);
        rb_man=(RadioButton)findViewById(R.id.rb_man);
        rb_woman=(RadioButton)findViewById(R.id.rb_woman);
         //默认选择男
        rb_man.setChecked(true);
      //  Toast.makeText(Register.this, "你选择的是:"+rb_man.getText().toString(), 1000).show();
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rb_man.getId()) {
                    Toast.makeText(Register.this, "你选择的是：" + rb_man.getText().toString(), 1000).show();
                } else if (checkedId == rb_woman.getId()) {
                    Toast.makeText(Register.this, "你选择的是:" + rb_woman.getText().toString(), 1000).show();
                }
            }
        });

    }
    /*
   下拉列表函数设置
    */
    public void spinner_set() {
      adapter=ArrayAdapter.createFromResource(this, R.array.Nation,android.R.layout.simple_spinner_item);
        //从XML文件获取数据

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //下拉列表从适配器中读取值
        sp.setAdapter(adapter);
        //下拉列表选定值后响应
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if(arg2 !=0 ){
                    String[] nation = getResources().getStringArray(R.array.Nation);
                    Toast.makeText(Register.this, "你选择的是:"+nation[arg2], 2000).show();
                }
                else{
                  //  Toast.makeText(Register.this, "没有选择任何选项！", 100).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
              //  Toast.makeText(Register.this, "没有选择任何选项！", 20).show();
            }
        });
    }




    public void passActivity(){
        Intent Intent = new Intent(Register.this, Submit.class);
        Register.this.startActivity(Intent);
    }

    /*
     自定义功能函数 ——Intent跳转
    */
    public void passActivityBack(){
        Intent intent=new Intent();
        intent.setClass(Register.this,MainActivity.class);
        startActivity(intent);
        Register.this.finish();
    }

}
