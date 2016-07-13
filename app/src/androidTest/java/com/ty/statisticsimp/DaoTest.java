package com.ty.statisticsimp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2016/6/17.
 */
@RunWith(AndroidJUnit4.class)
public class DaoTest
{
    private Context mContext;

    @Before
    public void setUp() throws Exception
    {
        mContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void test() throws Exception
    {
        TyStatic.init(mContext);
        TyStatic.onCreate();
        TyStatic.reportRequest("200");
        TyStatic.reportResult(true, "200");
        TyStatic.onResume();
        Thread.sleep(10000);
        TyStatic.onPause();
        Thread.sleep(10000000);
    }
}
