package news.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.baobiao.news.R;

import news.utils.SpUtils;

/**
 * Created by baobiao on 2016/11/20.
 */

public class SettingActivity extends Activity implements View.OnClickListener{
    private ImageView back;
    private Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_setting);
        back= (ImageView) findViewById(R.id.back);
        logOut= (Button) findViewById(R.id.logOut);

        back.setOnClickListener(this);
        logOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.logOut:
                SpUtils.removeString(this,"username");
                Toast.makeText(this,"退出成功",Toast.LENGTH_SHORT).show();
                finish();
        }
    }
}
