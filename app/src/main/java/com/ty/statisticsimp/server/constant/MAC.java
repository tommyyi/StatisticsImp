package com.ty.statisticsimp.server.constant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/6/20.
 */
public class MAC
{
    private static final String field = "mac";

    public static String get(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Config.fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(field, null);
    }

    public static void set(Context context,String mac)
    {
        if(mac==null||mac.equals(""))
            return;

        SharedPreferences sharedPreferences = context.getSharedPreferences(Config.fileName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(field,mac).commit();
    }
}
