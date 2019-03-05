package com.inducesmile.logintemplate.utils;

import android.content.Context;
import android.widget.Toast;

public class DisplayUtils {

    private DisplayUtils() {
    }


    public static void showToast(Context context, String content){
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

}
