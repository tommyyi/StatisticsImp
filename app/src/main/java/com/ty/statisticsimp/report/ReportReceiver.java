package com.ty.statisticsimp.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ty.statisticsimp.dao.DaoSession;
import com.ty.statisticsimp.dao.UrlEntity;
import com.ty.statisticsimp.server.constant.Config;

import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
public class ReportReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        List<UrlEntity> urlEntityList = DaoSession.getSession(context, Config.dbName).queryBuilder(UrlEntity.class).build().list();
        if (urlEntityList == null || urlEntityList.size() == 0)
        {
            return;
        }
        Thread2Report.getThread2Report(context).doStart();
    }
}
