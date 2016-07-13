package com.ty.statisticsimp.report;

import android.content.Context;
import android.util.Log;

import com.ty.statisticsimp.dao.DaoSession;
import com.ty.statisticsimp.dao.UrlEntity;
import com.ty.statisticsimp.server.constant.Config;
import com.ty.statisticsimp.server.remote.ApiFactory;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

/**
 * Created by Administrator on 2016/6/20.
 */
public class Thread2Report extends Thread
{
    private static Thread2Report thread2Report;
    private final Context mContext;

    private Thread2Report(Context context)
    {
        mContext = context;
        thread2Report = this;
    }

    public void doStart()
    {
        if (getState() == State.NEW)
        {
            try
            {
                super.start();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void start()
    {
    }

    public static Thread2Report getThread2Report(Context context)
    {
        if (thread2Report == null)
        {
            thread2Report = new Thread2Report(context);
        }
        return thread2Report;
    }

    @Override
    public void run()
    {
        List<UrlEntity> urlEntityList = DaoSession.getSession(mContext, Config.dbName).queryBuilder(UrlEntity.class).build().list();
        if (urlEntityList == null || urlEntityList.size() == 0)
        {
            thread2Report = null;
            return;
        }

        for (int index = 0; index < urlEntityList.size(); index++)
        {
            try
            {
                Response response = ApiFactory.getAPI().report(urlEntityList.get(index).getUrl()).execute();
                if (response.isSuccessful() && response.body().equals("ok"))
                {
                    DaoSession.getSession(mContext, Config.dbName).delete(urlEntityList.get(index));
                    Log.e("send", "send ok");
                    System.out.print("send ok\r\n");
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
                thread2Report = null;
                return;
            }
        }
        thread2Report = null;
    }
}
