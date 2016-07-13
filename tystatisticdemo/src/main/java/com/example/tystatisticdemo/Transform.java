package com.example.tystatisticdemo;

import com.ty.statisticsimp.TyStatic;

/**
 * Created by Administrator on 2016/6/27.
 */
public class Transform
{
    public static void smali_reportResult(int resultCode, String billingIndex)
    {
        reportResult(resultCode, billingIndex);
    }

    public static void reportResult(int resultCode, String billingIndex)
    {
        if (resultCode == 1)
        {
            reportResultSuccess(billingIndex);
        }
        else
        {
            reportResultFail(billingIndex);
        }
    }

    private static void reportResultFail(String billingIndex)
    {
        TyStatic.reportResult(false, code2price(billingIndex));
    }

    private static void reportResultSuccess(String billingIndex)
    {
        TyStatic.reportResult(true, code2price(billingIndex));
    }

    public static void smali_reportRequest(String billingIndex)
    {
        reportRequest(billingIndex);
    }

    public static void reportRequest(String billingIndex)
    {
        TyStatic.reportRequest(code2price(billingIndex));
    }

    private static String code2price(String billingIndex)
    {
        if (billingIndex.equals("001"))
        {
            return "600";
        }
        if (billingIndex.equals("002"))
        {
            return "1000";
        }
        if (billingIndex.equals("003"))
        {
            return "2000";
        }
        if (billingIndex.equals("004"))
        {
            return "1500";
        }
        if (billingIndex.equals("005"))
        {
            return "400";
        }
        if (billingIndex.equals("006"))
        {
            return "2000";
        }
        if (billingIndex.equals("007"))
        {
            return "400";
        }
        if (billingIndex.equals("008"))
        {
            return "1000";
        }
        if (billingIndex.equals("009"))
        {
            return "1000";
        }
        if (billingIndex.equals("010"))
        {
            return "1000";
        }
        return "600";
    }
}
