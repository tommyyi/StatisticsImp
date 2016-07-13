package com.ty.statisticsimp;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2016/7/13.
 */
class AppParams
{
    private static final String TIANYI_GAME_APP_ID = "tianyiGameAppId";
    private static final String TIANYI_GAME_CHANNEL_ID = "tianyiGameChannelId";

    public String getAppId(Context context) throws Exception
    {
        return String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getInt(TIANYI_GAME_APP_ID));
    }

    public String getChannelId(Context context) throws Exception
    {
        return String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getInt(TIANYI_GAME_CHANNEL_ID));
    }
}
