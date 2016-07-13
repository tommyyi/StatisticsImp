package com.ty.statisticsimp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/7/13.
 */
public class AppParamsTest
{
    private static final String TAG = "AppParamsTest";

    @Test
    public void testParams() throws Exception
    {
        AppParams appParams = new AppParams();
        Context targetContext = InstrumentationRegistry.getTargetContext();
        String appId= appParams.getAppId(targetContext);
        String channelId=appParams.getChannelId(targetContext);
        Log.e(TAG,appId);
    }
}