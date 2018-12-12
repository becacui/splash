package com.xyt.splash;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by 13388 on 2018/12/9.
 */
//implements View.OnClickListener
public class EnterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_register;
    private Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);
        init();
    }
    private void init() {
        button_register = (Button) findViewById(R.id.button_register);
        button_register.setOnClickListener(this);//点击事件的按钮

    }
    /**
     * 点击事件
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //case R.id.button_login:  //如果点击登录按钮
            //    login();
            //    break;
            case R.id.button_register:  //注册按钮 跳转到注册页面
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;

        }
    }



}



