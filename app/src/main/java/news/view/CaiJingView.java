package news.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.baobiao.news.R;
//import com.squareup.okhttp.Callback;
//import com.squareup.okhttp.FormEncodingBuilder;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import news.activity.NewsDetailActivity;
import news.adapter.CaiJingViewMyAdapter;
import news.beans.CaiJingViewBean;
import news.utils.ConstantValue;
import news.utils.Okhttp;
import news.utils.OkhttpUtil;
import okhttp3.Call;

/**
 * Created by baobiao on 2016/11/18.
 */

public class CaiJingView extends BaseView {
    private static final String TAG = "TopView";
    public static CaiJingView topView;
    private RecyclerView recyclerView;
    private List<CaiJingViewBean.ResultBean.DataBean> data;

    public CaiJingView(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public View getView() {
        view = View.inflate(mActivity, R.layout.view_top, null);

        return super.getView();
    }

    @Override
    void initView() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    void initData() {
        if (data != null) {
            setAdapter();
            return;
        }
        //从网络上获取数据
        Map<String,String> map=new HashMap<>();
        map.put("key","bb3ec455f4f4a29092c9bdfaa449aa6a");
        map.put("type","caijing") ;
        Okhttp.post(ConstantValue.URL_TOP, map, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                String result = response.body().string();
                processData(result);
            }
        });
//        FormEncodingBuilder builder = new FormEncodingBuilder();
//        builder.add("key", "bb3ec455f4f4a29092c9bdfaa449aa6a");
//        builder.add("type", "caijing");
//
//        OkhttpUtil.post(ConstantValue.URL_TOP, builder, new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                String result = response.body().string();
////                Log.i(TAG,result);
//                processData(result);
//
//            }
//        });
    }

    @Override
    public void processData(String result) {
        super.processData(result);
        if (!result.contains("{")) {
            Log.i(TAG, "result：" + result);
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(result);
            int error_code = jsonObject.getInt("error_code");
            if (error_code != 0) {
                Log.i(TAG, "result" + result);
                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
        CaiJingViewBean caiJingViewBean = gson.fromJson(result, CaiJingViewBean.class);
        data = caiJingViewBean.getResult().getData();
        setAdapter();
    }

    private void setAdapter() {
        if (data != null) {
            if (getContext() == null) {
                return;
            }
            getContext().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    CaiJingViewMyAdapter adapter = new CaiJingViewMyAdapter(data, mActivity);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(new CaiJingViewMyAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, CaiJingViewBean.ResultBean.DataBean data) {
                            Intent intent = new Intent(getContext(), NewsDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("title", data.getTitle());
                            bundle.putString("url", data.getUrl());
                            intent.putExtras(bundle);

                            getContext().startActivity(intent);
                        }
                    });
                }
            });
        }
    }


    public static Object getInstance(Activity activity) {
        if (topView == null) {
            return new CaiJingView(activity);
        } else {
            return topView;
        }
    }
}
