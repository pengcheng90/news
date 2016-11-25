package news.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.baobiao.news.R;
//import com.squareup.okhttp.Callback;
//import com.squareup.okhttp.FormEncodingBuilder;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import news.activity.NewsDetailActivity;
import news.adapter.TopViewMyAdapter;
import news.beans.TopViewBean;
import news.utils.ConstantValue;
import news.utils.Okhttp;
import news.utils.OkhttpUtil;
import okhttp3.Call;

/**
 * Created by baobiao on 2016/11/18.
 */

public class TopView extends BaseView {
    private static final String TAG = "TopView";
    public static TopView topView;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<TopViewBean.ResultBean.DataBean> data;

    public TopView(Activity activity) {
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
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    void initData() {
        if (data != null) {
            setApapter();
            return;
        }
        //从网络上获取数据
        Map<String, String> map = new HashMap<>();
        map.put("key", "bb3ec455f4f4a29092c9bdfaa449aa6a");
        map.put("type", "top");
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
//        builder.add("type", "top");
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
        TopViewBean topViewBean = gson.fromJson(result, TopViewBean.class);
        data = new ArrayList<>();
        data = topViewBean.getResult().getData();
        setApapter();
    }

    private void setApapter() {
        if (data != null) {
            getContext().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    TopViewMyAdapter adapter = new TopViewMyAdapter(data, getContext());
//                    recyclerView.setAdapter(new MyAdapter());
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(new TopViewMyAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, TopViewBean.ResultBean.DataBean data) {
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
            return new TopView(activity);
        } else {
            return topView;
        }
    }
}
