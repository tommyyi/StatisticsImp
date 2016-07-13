package com.ty.statisticsimp.server.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2016/6/17.
 */
public interface API
{
    @GET()
    Call<String> report(@Url String url);
}
