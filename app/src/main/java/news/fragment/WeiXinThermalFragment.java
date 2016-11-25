package news.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
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
import news.adapter.JunShiMyAdapter;
import news.adapter.SpacesItemDecoration;
import news.adapter.WeinXinFragmentMyAdapter;
import news.beans.JunShiBean;
import news.beans.WeiXinChoiceBean;
import news.utils.BitmapUtil;
import news.utils.ConstantValue;
import news.utils.Okhttp;
import news.utils.OkhttpUtil;
import okhttp3.Call;

/**
 * 微信热文Fragment
 * Created by baobiao on 2016/11/17.
 */

public class WeiXinThermalFragment extends Fragment {
    private static final String TAG = "WeiXinThermalFragment";
    private RecyclerView mRecyclerView;
    private View view;
    private WeiXinChoiceBean mWeiXinBean;
    private List<WeiXinChoiceBean.ResultBean.ListBean> mListBeen;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weixintherma, container, false);
        initView();
        return view;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);
        initData();
    }

    private void initData() {
        if(mWeiXinBean!=null){
            return;
        }
        //从网络上获取数据
        Map<String,String> map=new HashMap<>();
        map.put("key","356c39493d8e6092e6c236acf84a2c4c");
        map.put("ps","10") ;
        Okhttp.post(ConstantValue.URL_WEIXIN, map, new okhttp3.Callback() {
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

    private void processData(String data) {
        if (!data.contains("{")) {
            Log.i(TAG, "result：" + data);
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(data);
           final int error_code = jsonObject.getInt("error_code");
            if (error_code != 0) {
                Log.i(TAG, "result:" + data);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), error_code + "", Toast.LENGTH_SHORT).show();
                    }
                });

                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
        Gson gson = OkhttpUtil.getGsoninstance();
        mWeiXinBean = gson.fromJson(data, WeiXinChoiceBean.class);
        mListBeen = mWeiXinBean.getResult().getList();

        if (mListBeen != null) {
            //当fragment生命周期结束并销毁时，getActivity()返回的会是null。所以在使用时要注意判断null或者捕获空指针异常
            if(getActivity()==null){
                return;
            }
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    WeinXinFragmentMyAdapter adapter=new WeinXinFragmentMyAdapter(mListBeen,getActivity());
                    mRecyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(new WeinXinFragmentMyAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, WeiXinChoiceBean.ResultBean.ListBean data) {

                            Intent intent=new Intent(getActivity(), NewsDetailActivity.class);
                            Bundle bundle=new Bundle();
                            bundle.putString("title",data.getSource());
                            bundle.putString("url",data.getUrl());
                            intent.putExtras(bundle);
                            getActivity().startActivity(intent);
                        }
                    });
                }
            });
        }

    }

}
