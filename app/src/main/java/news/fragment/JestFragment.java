package news.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.baobiao.news.R;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import news.adapter.JestFragmentMyAdapter;
import news.beans.JestBean;
import news.utils.ConstantValue;
import news.utils.Okhttp;
import news.utils.OkhttpUtil;
import okhttp3.Call;


/**
 * Created by baobiao on 2016/11/19.
 */

public class JestFragment extends Fragment {
    private static final String TAG = "JestFragment";
    private View view;
    private RecyclerView recyclerView;
    private List<JestBean.ResultBean> result;
    private Activity activity;
    private ProgressBar prgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initView(inflater, container);
        initData();
        return view;
    }

    private void initData() {
        activity = getActivity();
        Map<String,String> map=new HashMap<>();
        map.put("key","997844f59febea94d77266be85e12581");
            Okhttp.post(ConstantValue.URL_JOKE, map, new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, okhttp3.Response response) throws IOException {
                    String result = response.body().string();
                        proccessData(result);
                }
            });
    }

    private void proccessData(String json) {
        if (!json.contains("{")) {
            Log.i(TAG, "result：" + json);
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(json);
            final int error_code = jsonObject.getInt("error_code");
            if (error_code != 0) {
                Log.i(TAG, "result:" + json);
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
        JestBean jestBean = gson.fromJson(json, JestBean.class);
        result = jestBean.getResult();
        if (result != null) {
            if (activity == null) {
                return;
            }
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    prgressBar.setVisibility(View.GONE);
                    recyclerView.setAdapter(new JestFragmentMyAdapter(result, getActivity()));
                }
            });

        }

    }

    private void initView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_jest, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        prgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
