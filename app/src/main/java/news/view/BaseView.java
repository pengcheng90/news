package news.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import news.utils.OkhttpUtil;

/**
 * Created by baobiao on 2016/11/18.
 */

abstract class BaseView {
    private static final String TAG = "BaseView";
    public Activity mActivity;
    public View view;
    public Gson gson;
    public static BaseView baseView;

    public View getView() {
        initView();
        initData();
        return view;
    }

    abstract void initView();

    abstract void initData();

    public void processData( String result) {

        gson = OkhttpUtil.getGsoninstance();
    }

    public Activity getContext() {
        return mActivity;
    }

    public static Object getInstance(Activity activity) {
        return baseView;
    }
}
