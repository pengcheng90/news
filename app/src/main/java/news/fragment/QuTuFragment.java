package news.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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

import news.adapter.QuTuFragmentMyAdapter;
import news.beans.QuTuBean;
import news.utils.ConstantValue;
import news.utils.Okhttp;
import news.utils.OkhttpUtil;
import okhttp3.Call;

/**
 * Created by baobiao on 2016/11/19.
 */

public class QuTuFragment extends Fragment {
    private static final String TAG = "QuTuFragment";
    private View view;
    private RecyclerView mRecyclerView;
    private List<QuTuBean.ResultBean> result;
    private QuTuFragmentMyAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_qutu, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        if(result!=null){
            setAdapter();
            return;
        }
        Map<String,String> map=new HashMap<>();
        map.put("key","997844f59febea94d77266be85e12581");
        map.put("type","pic") ;
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
        QuTuBean quTuBean = gson.fromJson(json, QuTuBean.class);
        result = quTuBean.getResult();
        setAdapter();
    }

    private void setAdapter() {
        if (result != null) {
            adapter = new QuTuFragmentMyAdapter(result, getActivity());
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        mRecyclerView.setAdapter(adapter);
                    }
                });
            }
        }
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_qutu);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }
}
