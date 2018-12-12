package com.xyt.splash;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;

/**
 * Created by 13388 on 2018/12/9.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText_name, editText_ID, editText_tel, editText_password;
    private TextView textView_name, textView_ID, textView_tel, textView_password, textView_attention;
    private Button button_confirm;
    private ImageView returnImage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        init();
    }

    /**
     * 初始化控件的方法
     */
    private void init() {
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_ID = (EditText) findViewById(R.id.editText_ID);
        editText_tel = (EditText) findViewById(R.id.editText_tel);
        editText_password = (EditText) findViewById(R.id.editText_password);
        button_confirm = (Button) findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(this);

        returnImage = (ImageView) findViewById(R.id.button_return);
        returnImage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_confirm: //确定按钮
                register();
                break;
            case R.id.button_return:
                returnEnter(); //回到登陆界面
                break;
        }
    }

    private void returnEnter() {
        Intent intent = new Intent(this, EnterActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 注册方法
     */
    public void register() {
        final String name = editText_name.getText().toString().trim(); //获取姓名
        final String ID = editText_ID.getText().toString().trim(); //获取学号
        final String Phone = editText_tel.getText().toString().trim(); //获取电话
        final String Password = editText_password.getText().toString().trim(); //获取密码
        String confirm = button_confirm.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {  //当姓名没有输入时
            Toast.makeText(this, "姓名不能为空！", Toast.LENGTH_SHORT).show();
            editText_name.requestFocus();//使输入框失去焦点 将键盘隐藏起来
            return;
        } else if (TextUtils.isEmpty(ID)) {//当学号没有输入时
            Toast.makeText(this, "学号不能为空！", Toast.LENGTH_SHORT).show();
            editText_ID.requestFocus();//使输入框失去焦点
            return;
        } else if (TextUtils.isEmpty(Phone)) {//当电话没有输入时
            Toast.makeText(this, "电话不能为空！", Toast.LENGTH_SHORT).show();
            editText_tel.requestFocus();//使输入框失去焦点
            return;
        } else if (TextUtils.isEmpty(Password)) {//当密码没有输入时
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            editText_password.requestFocus();//使输入框失去焦点
            return;
        }
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(Password)) {
            final ProgressDialog pd = new ProgressDialog(this); //初始化等待条
            pd.setMessage("正在注册……");
            pd.show();

            //数据传给后台 验证是不是匹配 但咱们数据库还没建
            //模拟后台
            new Thread(new Runnable() {
                public void run() {
                    //注册的操作放在此处
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pd.dismiss();
                    returnEnter();
                }
            }).start(); //开启线程
        }
    }

}









