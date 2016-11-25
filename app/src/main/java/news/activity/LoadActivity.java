package news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.baobiao.news.R;

import java.util.List;

import news.bombean.UserBean;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import news.utils.SpUtils;

/**
 * Created by baobiao on 2016/11/20.
 */

public class LoadActivity extends Activity implements View.OnClickListener {
    private ImageView back;
    private EditText username, password;
    private Button load, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    private void initView() {

        setContentView(R.layout.activity_load);

        back = (ImageView) findViewById(R.id.back);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        load = (Button) findViewById(R.id.load);
        register = (Button) findViewById(R.id.register);

        back.setOnClickListener(this);
        load.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.load:
                userLoad();
                break;
            case R.id.register:
                Intent intent = new Intent(getApplicationContext(), ReGisterActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void userLoad() {

        final String name = username.getText().toString().trim();
        final String pwd = password.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String bql = "select * from UserBean where username = ?";

        new BmobQuery<UserBean>().doSQLQuery(bql, new SQLQueryListener<UserBean>() {
            @Override
            public void done(BmobQueryResult<UserBean> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<UserBean> list = (List<UserBean>) bmobQueryResult.getResults();
                    if (list.size() > 0) {
                        Toast.makeText(getApplicationContext(), "登录成功，返回主页面", Toast.LENGTH_SHORT).show();
                        if (list.get(0).getPassword().equals(pwd)) {

                            if (!TextUtils.isEmpty(SpUtils.getString(getApplicationContext(), "username"))) {
                                SpUtils.removeString(getApplicationContext(), "username");
                            }
                            SpUtils.putString(getApplicationContext(), "username", name);
                            SpUtils.putString(getApplicationContext(), "password", pwd);
                            finish();
                        }

                    } else {
                        Log.i("smile", "查询成功，无数据");
                    }
                } else {
                    Log.i("smile", "错误码：" + e.getErrorCode() + "，错误描述：" + e.getMessage());
                }
            }
        }, name);

    }
}
