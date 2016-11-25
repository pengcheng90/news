package news.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baobiao.news.R;

import news.bombean.CollectionBean;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import news.utils.SpUtils;

/**
 * Created by baobiao on 2016/11/18.
 */

public class NewsDetailActivity extends Activity implements View.OnClickListener {
    private ImageView back;
    private TextView title;
    private WebView wv_detail;
    private String mTitle, mUrl;
    private String title1;
    private String url;
    private ProgressBar pg_web;
    private ImageView collection;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);
        initData();

        initView(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String username = SpUtils.getString(getApplicationContext(), "username");
        if (SpUtils.getString(getApplicationContext(), username).equals(url)) {
            collection.setImageResource(R.mipmap.collectioned);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        title1 = bundle.getString("title");
        url = bundle.getString("url");
    }


    private void initView(Bundle savedInstanceState) {
        wv_detail = new WebView(getApplicationContext());

        mRelativeLayout = (RelativeLayout) findViewById(R.id.fl);
        back = (ImageView) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        pg_web = (ProgressBar) findViewById(R.id.pg_web);
        collection = (ImageView) findViewById(R.id.collection);

        mRelativeLayout.addView(wv_detail);
        back.setOnClickListener(this);
        title.setOnClickListener(this);
        collection.setOnClickListener(this);

        title.setText(title1);
        if (savedInstanceState != null) {
            wv_detail.restoreState(savedInstanceState);
        } else {
            wv_detail.loadUrl(url);
        }

        wv_detail.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pg_web.setVisibility(View.VISIBLE);
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pg_web.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        //启用支持javascript
        WebSettings settings = wv_detail.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);// 显示缩放按钮
        settings.setUseWideViewPort(true);// 支持双击
        // 关闭缩放
        settings.setAppCacheMaxSize(1024 * 512 * 10);//设置缓冲大小，10M
        settings.setDefaultFixedFontSize(1);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (wv_detail.canGoBack()) {
                wv_detail.goBack();//返回上一页面
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                if (wv_detail.canGoBack()) {
                    wv_detail.goBack();//返回上一页面
                } else {
                    finish();
                }
                break;
            case R.id.collection:
                addCollection();

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //清楚webview，节省内存
        mRelativeLayout.removeAllViews();
        wv_detail.removeAllViews();
        wv_detail.destroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        wv_detail.saveState(outState);
    }

    private void addCollection() {
        final String userName = SpUtils.getString(this, "username");
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "请登录后收藏", Toast.LENGTH_SHORT).show();
            return;
        }
        CollectionBean colbean = new CollectionBean();
        colbean.setTitle(title1);
        colbean.setUrl(url);
        colbean.setUsername(userName);

        colbean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(), "搜藏成功", Toast.LENGTH_SHORT).show();
                    collection.setImageResource(R.mipmap.collectioned);
                    SpUtils.putString(getApplicationContext(), userName, url);
                    SpUtils.putString(getApplicationContext(), "username", userName);
                } else {
                    if (e.getErrorCode() == 401) {
                        Toast.makeText(getApplicationContext(), "您已经收藏了", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "收藏失败" + e.getErrorCode(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
