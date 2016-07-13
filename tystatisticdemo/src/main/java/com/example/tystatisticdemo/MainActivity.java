package com.example.tystatisticdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ty.statisticsimp.TyStatic;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //        初始化统计插件
        init(this);
        //        统计游戏的启动
        TyStatic.onCreate();
    }

    protected static void init(Context context)
    {
        TyStatic.init(context);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //        通过调用onResume和onPause可以统计用户使用时长
        TyStatic.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //        通过调用onResume和onPause可以统计用户使用时长
        TyStatic.onPause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void requestPay(View view)
    {
        //        用户请求了2块的支付
        TyStatic.reportRequest("200");
    }

    public void onResult(View view)
    {
        //        用户2块支付成功
        TyStatic.reportResult(true, "200");
        //        用户2块支付失败
        TyStatic.reportResult(false, "200");
    }
}
