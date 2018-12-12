package com.xyt.splash;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by 13388 on 2018/12/9.
 */

public class SlapActivity extends AppCompatActivity {
    private ImageView imageView;
    private Animation animation;
    private int resids[]; //用于加载照片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //设置全屏

        setContentView(R.layout.slap_activity_layout);
        animation = AnimationUtils.loadAnimation(this, R.anim.enlarge);
        imageView = (ImageView) findViewById(R.id.slap_image);

        TypedArray ar=getResources().obtainTypedArray(R.array.imgArray); //获取图片数组
        int len = ar.length();                                         //获取数组长度
        resids= new int[len];                                         //初始化加载图片的数组

        for(int i=0;i<len; i++)
            resids[i] = ar.getResourceId(i,0);//for循环将图片读取出来

        Random rand= new Random(); //初始化随机数
        int pos= rand.nextInt(resids.length); //随即获取小于数组长度的数
        imageView.setImageResource(resids[pos]);  //把图片显示出来

        /**
         * 开启线程
         **/
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    imageView.startAnimation(animation); //给图片设置放大的动画
                    Thread.sleep(3000);                  //此界面休眠3秒
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                toSecond();                           //执行跳转到下一个界面的方法
            }
        }).start();

    }
    /**
     * 跳转到下一个界面 主界面  用intent 可以实现在两个activity之间传递数据
     */
    public void toSecond(){
        Intent intent =new Intent(this,EnterActivity.class);//跳转到主界面
        startActivity(intent); //开始跳转

        finish();
    }


}






