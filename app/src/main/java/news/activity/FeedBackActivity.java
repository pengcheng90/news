package news.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.baobiao.news.R;

import news.bombean.FeedbackBean;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import news.utils.SpUtils;

/**
 * Created by baobiao on 2016/11/20.
 */

public class FeedBackActivity extends Activity implements View.OnClickListener {
    private ImageView back;
    private Button commit;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_feedback);
        back = (ImageView) findViewById(R.id.back);
        commit = (Button) findViewById(R.id.commit);
        editText = (EditText) findViewById(R.id.editText);

        back.setOnClickListener(this);
        commit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.commit:
                commit();
                break;


        }

    }

    private void commit() {
        String feed = editText.getText().toString().trim();
        String username = SpUtils.getString(this, "username");
        if (TextUtils.isEmpty(feed)) {
            Toast.makeText(this, "请填写您的宝贵意见", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请先登录再提交", Toast.LENGTH_SHORT).show();
        }
        FeedbackBean bean = new FeedbackBean();
        bean.setUsername(username);
        bean.setFeed(feed);
        bean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    if (e.getErrorCode() == 401) {
                        Toast.makeText(getApplicationContext(), "已提交", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "提交失败" + e.getErrorCode(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
