package com.ty.statisticsimp.server.remote;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2016/6/17.
 */
class MyConverter implements Converter<ResponseBody, String>
{
    @Override
    public String convert(ResponseBody responseBody) throws IOException
    {
        return responseBody.string();
    }
}
