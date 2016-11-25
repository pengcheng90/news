package news.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by baobiao on 2016/11/20.
 */

public class SpUtils {

    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences("userinfo.txt", Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("userinfo.txt", Context.MODE_PRIVATE);
        String result = sp.getString(key, "");
        return result;
    }

    public static void removeString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("userinfo.txt", Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences("userinfo.txt", Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("userinfo.txt", Context.MODE_PRIVATE);
        int result = sp.getInt(key, 0);
        return result;
    }

}
