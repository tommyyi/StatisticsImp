package com.ty.statisticsimp.server.remote;

import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/6/17.
 */
public class ApiFactory
{
    private static final API mAPI;

    static
    {
        Converter.Factory converterFactory = new MyConverterFactory();
        mAPI = new Retrofit.Builder().baseUrl("http://www.domain.com").addConverterFactory(converterFactory).build().create(API.class);
    }

    public static API getAPI()
    {
        return mAPI;
    }
}
