package com.example.poem.custom_textview;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {
    private static Typeface thuphap1;
    private static Typeface thuphap2;
    private static Typeface thuphap3;
    private static Typeface thuphap4;
    private static Typeface thuphap5;

    public static Typeface getThuphap1(Context context) {
        if(thuphap1 == null)
            thuphap1 = Typeface.createFromAsset(context.getAssets(), "fonts/Vntfap01.ttf");

        return thuphap1;
    }

    public static Typeface getThuphap2(Context context) {
        if(thuphap2 == null)
            thuphap2 = Typeface.createFromAsset(context.getAssets(), "fonts/Vnthfapf.TTF");

        return thuphap2;
    }

    public static Typeface getThuphap3(Context context) {
        if(thuphap3 == null)
            thuphap3 = Typeface.createFromAsset(context.getAssets(), "fonts/Vongdohl.ttf");

        return thuphap3;
    }

    public static Typeface getThuphap4(Context context) {
        if(thuphap4 == null)
            thuphap4 = Typeface.createFromAsset(context.getAssets(), "fonts/TMC-Ong Do.TTF");

        return thuphap4;
    }

    public static Typeface getThuphap5(Context context) {
        if(thuphap5 == null)
            thuphap5 = Typeface.createFromAsset(context.getAssets(), "fonts/Tmcongdo.ttf");

        return thuphap5;
    }
}
