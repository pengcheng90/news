package news.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baobiao.news.R;
import com.google.gson.Gson;
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
import news.adapter.KeJiViewMyAdapter;
import news.adapter.TopViewMyAdapter;
import news.beans.KeJiViewBean;
import news.beans.TopViewBean;
import news.utils.BitmapUtil;
import news.utils.ConstantValue;
import news.utils.Okhttp;
import news.utils.OkhttpUtil;
import okhttp3.Call;

/**
 * Created by baobiao on 2016/11/18.
 */

public class KeJiView extends BaseView {
    private static final String TAG ="TopView" ;
    public static KeJiView topView;
    private RecyclerView recyclerView;
    private List<KeJiViewBean.ResultBean.DataBean> data;
    private ProgressBar progressBar;

    public KeJiView(Activity activity){
        this.mActivity=activity;
    }

    @Override
    public View getView() {
        view=View.inflate(mActivity,R.layout.view_keji,null);

        return super.getView();
    }

    @Override
    void initView() {
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        progressBar= (ProgressBar) view.findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    void initData() {
        if (data!=null){
            setAdapter();
        }
        //从网络上获取数据
        Map<String,String> map=new HashMap<>();
        map.put("key","bb3ec455f4f4a29092c9bdfaa449aa6a");
        map.put("type","keji") ;
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
        KeJiViewBean keJiViewBean=gson.fromJson(result,KeJiViewBean.class);
        data = keJiViewBean.getResult().getData();
        setAdapter();
    }

    private void setAdapter() {
        if(data!=null){
            if(getContext()==null){
                return;
            }
            getContext().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    KeJiViewMyAdapter adapter=new KeJiViewMyAdapter(data,mActivity);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(new KeJiViewMyAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, KeJiViewBean.ResultBean.DataBean data) {
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


    public  static Object getInstance(Activity activity) {
        if (topView==null){
            return new KeJiView(activity);
        }else {
            return topView;
        }
    }
}
