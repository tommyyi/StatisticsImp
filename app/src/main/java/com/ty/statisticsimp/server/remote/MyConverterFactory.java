package com.ty.statisticsimp.server.remote;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/6/17.
 */
class MyConverterFactory extends Converter.Factory
{
    @Override
    public Converter<ResponseBody, String> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit)
    {
        return new MyConverter();
    }
}
