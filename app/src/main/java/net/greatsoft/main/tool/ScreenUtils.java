package net.greatsoft.main.tool;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * ScreenUtils
 * Created by hanj on 14-9-25.
 */
public class ScreenUtils {
    private static int screenW= 1024;
    private static int screenH = 2048;

    public static int getScreenW(){
        return screenW;
    }

    public static int getScreenH(){
        return screenH;
    }

    public static int getScreenW(Activity mActivity){
        if (screenW == 0){
            initScreen(mActivity);
        }
        return screenW;
    }

    public static int getScreenH(Activity mActivity){
        if (screenH == 0){
            initScreen(mActivity);
        }
        return screenH;
    }

    private static void initScreen(Activity mActivity){
        DisplayMetrics metric = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        screenW = metric.widthPixels;
        screenH = metric.heightPixels;
    }
}
