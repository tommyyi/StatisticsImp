package com.ty.statisticsimp;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import com.ty.statisticsimp.dao.DaoSession;
import com.ty.statisticsimp.dao.UrlEntity;
import com.ty.statisticsimp.report.Thread2Report;
import com.ty.statisticsimp.server.constant.IMEI;
import com.ty.statisticsimp.server.constant.IMSI;
import com.ty.statisticsimp.server.constant.MAC;
import com.ty.statisticsimp.server.remote.Md5;
import com.ty.statisticsimp.server.remote.UrlCreator;

/**
 * Created by Administrator on 2016/6/20.
 */
public class TyStatic
{
    private static long start=0;
    private static boolean isInit = false;
    private static final UrlCreator mUrlCreator = new UrlCreator();
    private static Context context;
    private static String appId;
    private static String channelId;
    private static String mac;
    private static String imei;
    private static String imsi;

    public static void init(Context context)
    {
        isInit = true;

        TyStatic.context = context;
        AppParams appParams=new AppParams();
        try
        {
            TyStatic.appId = appParams.getAppId(context);
            TyStatic.channelId = appParams.getChannelId(context);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        mac = Tool.getMac(context);
        imei = Tool.getImei(context);
        imsi = Tool.getImsi(context);
    }

    private static void init(Context context, String appId, String channelId)
    {
        isInit = true;

        TyStatic.context = context;
        TyStatic.appId = appId;
        TyStatic.channelId = channelId;

        mac = Tool.getMac(context);
        imei = Tool.getImei(context);
        imsi = Tool.getImsi(context);
    }

    public static void onResume()
    {
        checkInit();
        start= System.currentTimeMillis();
    }

    public static void onPause()
    {
        checkInit();
        reportPlayTime((System.currentTimeMillis()-start)/1000+"");
    }

    public static void onCreate()
    {
        checkInit();
        String url = mUrlCreator.getUrl2reportStartUp(appId, channelId, mac, imei, imsi);
        fry(url);
    }

    public static void reportRequest(String req_money)
    {
        checkInit();
        String url = mUrlCreator.getUrl2reportRequest(appId, channelId, mac, imei, imsi, req_money);
        fry(url);
    }

    public static void reportResult(boolean isSuccessful, String resp_money)
    {
        checkInit();

        String status;
        if (isSuccessful)
        {
            status = "1";
        }
        else
        {
            status = "2";
        }

        String url = mUrlCreator.getUrl2reportResult(appId, channelId, mac, imei, imsi,status, resp_money);
        fry(url);
    }

    private static void reportPlayTime(String online_time)
    {
        if (!isInit)
        {
            throw new AssertionError();
        }

        String url = mUrlCreator.getUrl2reportPlayTime(appId, channelId, mac, imei, imsi,online_time);
        fry(url);
    }

    private static void checkInit()
    {
        if (!isInit)
        {
            throw new AssertionError("you do not initiate TyStatic, please initiate TyStatic first");
        }
    }

    private static void fry(String url)
    {
        DaoSession.getSession(context, "Report").insert(new UrlEntity(System.currentTimeMillis(), url));
        Thread2Report.getThread2Report(context).doStart();
    }

    private static class Tool
    {
        public static String getMac(Context context)
        {
            String mac = MAC.get(TyStatic.context);
            if (mac == null)
            {
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                mac = wifiInfo.getMacAddress();
                if (mac == null || mac.equals(""))
                {
                    mac = "000000000000";
                }
                MAC.set(context, mac);
            }
            return mac;
        }

        public static String getImei(Context context)
        {
            String imei = IMEI.get(context);
            if (imei == null)
            {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                imei = telephonyManager.getDeviceId();
                if (imei == null || imei.equals(""))
                {
                    imei = "000000000000";
                }
                IMEI.set(context, imei);
            }
            return imei;
        }

        public static String getImsi(Context context)
        {
            String imsi = IMSI.get(context);
            if (imsi == null)
            {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                imsi = telephonyManager.getSubscriberId();
                if (imsi == null || imsi.equals(""))
                {
                    imsi = "000000000000";
                }
                IMSI.set(context, imsi);
            }
            return imsi;
        }
    }
}
