package news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.baobiao.news.R;

import java.util.List;

import news.bombean.CollectionBean;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import news.adapter.ColletionMyAdapter;
import news.utils.SpUtils;

/**
 * Created by baobiao on 2016/11/20.
 */

public class ColletcionActivity extends Activity implements View.OnClickListener {
    private ImageView back;
    private RecyclerView recyclerView;
    private String username;
    private Activity mActivity;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        mActivity = this;
        BmobQuery<CollectionBean> query = new BmobQuery<CollectionBean>();
        //username“ ”的数据
        String username= SpUtils.getString(this, "username");
        if (TextUtils.isEmpty(username)){
            Toast.makeText(getApplicationContext(), "请先登录后查看", Toast.LENGTH_SHORT).show();
            return;
        }
        query.addWhereEqualTo("username",username);
        query.setLimit(50);

        query.findObjects(new FindListener<CollectionBean>() {
            @Override
            public void done(List<CollectionBean> list, BmobException e) {
                if (e == null) {

                    if (list.size() == 0) {
                        Toast.makeText(getApplicationContext(), "无收藏内容", Toast.LENGTH_SHORT).show();
                    } else if (list.size() > 0) {
//                        Log.i("bmob", "CollectionBean:" + list.size() + "");
                        proccessData(list);
                    }

                } else {
//                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void proccessData(List<CollectionBean> list) {
        ColletionMyAdapter adapter = new ColletionMyAdapter(list, this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ColletionMyAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, CollectionBean data) {

                Intent intent = new Intent(mActivity, NewsDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", data.getTitle());
                bundle.putString("url", data.getUrl());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void initview() {
        setContentView(R.layout.activity_collection);

        back = (ImageView) findViewById(R.id.back);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }

    }
}
