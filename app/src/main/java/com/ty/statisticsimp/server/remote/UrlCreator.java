package com.ty.statisticsimp.server.remote;

/**
 * Created by Administrator on 2016/6/17.
 */
public class UrlCreator
{
    private static final String HOST = "http://danji.17hi.wang";

    private static final String TYPE_STARTUP = "/startup?type=startup";
    private static final String TYPE_REQUEST = "/reqcharge?type=request";
    private static final String TYPE_RESPONSE = "/ntfcharge?type=response";
    private static final String TYPE_ONLINE = "/oltime?type=online";
    private static final String APPID = "appid";
    private static final String CHANNELID = "channelid";
    private static final String MAC = "mac";
    private static final String IMEI = "imei";
    private static final String IMSI = "imsi";
    private static final String SIGN= "sign";

    public String getUrl2reportStartUp(String appid, String channelid, String mac, String imei, String imsi)
    {
        String sign = Md5.get32MD5(appid + channelid + imei + imsi + mac + "startup" + "danjiCODE000");
        return new StringBuilder().append(HOST).append(TYPE_STARTUP)
                                  .append(fix(appid,channelid,mac,imei,imsi,sign))
                                  .toString();
    }

    public String getUrl2reportRequest(String appid, String channelid, String mac, String imei, String imsi, String req_money)
    {
        String sign= Md5.get32MD5(appid+channelid+imei + imsi + mac+"request"+"danjiCODE000");
        return new StringBuilder().append(HOST).append(TYPE_REQUEST)
                                  .append(fix(appid,channelid,mac,imei,imsi,sign))
                                  .append("&").append("req_money").append("=").append(req_money)
                                  .toString();
    }

    public String getUrl2reportResult(String appid, String channelid, String mac, String imei, String imsi, String status, String resp_money)
    {
        String sign= Md5.get32MD5(appid+channelid+imei + imsi + mac+"response"+"danjiCODE000");
        return new StringBuilder().append(HOST).append(TYPE_RESPONSE)
                                  .append(fix(appid,channelid,mac,imei,imsi,sign))
                                  .append("&").append("status").append("=").append(status)
                                  .append("&").append("resp_money").append("=").append(resp_money)
                                  .toString();
    }

    public String getUrl2reportPlayTime(String appid, String channelid, String mac, String imei, String imsi, String online_time)
    {
        String sign= Md5.get32MD5(appid+channelid+imei + imsi + mac+"online"+"danjiCODE000");
        return new StringBuilder().append(HOST).append(TYPE_ONLINE)
                                  .append(fix(appid,channelid,mac,imei,imsi,sign))
                                  .append("&").append("online_time").append("=").append(online_time)
                                  .toString();
    }

    private String fix(String appid, String channelid, String mac, String imei, String imsi, String sign)
    {
        return new StringBuilder().append("&").append(APPID).append("=").append(appid)
                                  .append("&").append(CHANNELID).append("=").append(channelid)
                                  .append("&").append(MAC).append("=").append(mac)
                                  .append("&").append(IMEI).append("=").append(imei)
                                  .append("&").append(IMSI).append("=").append(imsi)
                                  .append("&").append(SIGN).append("=").append(sign).toString();
    }
}
