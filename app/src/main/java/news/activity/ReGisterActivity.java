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

import news.bombean.UserBean;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by baobiao on 2016/11/20.
 */

public class ReGisterActivity extends Activity implements View.OnClickListener {
    private EditText username, password;
    private Button register;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_register);

        back = (ImageView) findViewById(R.id.back);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);

        back.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.register:
                userRegister();
                break;
        }
    }

    private void userRegister() {
        String name=username.getText().toString().trim();
        String pwd=password.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        UserBean user=new UserBean();
        user.setUsername(name);
        user.setPassword(pwd);
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    if(e.getErrorCode()==401){
                        Toast.makeText(getApplicationContext(), "用户已注册", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "注册失败"+e.getErrorCode(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
