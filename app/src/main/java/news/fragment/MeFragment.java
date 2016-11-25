package news.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.baobiao.news.R;

import news.activity.AboutActivity;
import news.activity.ColletcionActivity;
import news.activity.FeedBackActivity;
import news.activity.LoadActivity;
import news.activity.SettingActivity;
import news.utils.SpUtils;


/**
 * Created by baobiao on 2016/11/20.
 */

public class MeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout load;
    private TextView collect, feedback, about, setting, user;
    private String title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        initView();
        return view;
    }

    private void initView() {
        load = (LinearLayout) view.findViewById(R.id.load);
        collect = (TextView) view.findViewById(R.id.collect);
        feedback = (TextView) view.findViewById(R.id.feedback);
        about = (TextView) view.findViewById(R.id.about);
        setting = (TextView) view.findViewById(R.id.setting);
        user = (TextView) view.findViewById(R.id.user);

        load.setOnClickListener(this);
        collect.setOnClickListener(this);
        feedback.setOnClickListener(this);
        about.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        String username = SpUtils.getString(getActivity(), "username");
        if (!TextUtils.isEmpty(username)) {
            user.setText(username);
        } else {
            user.setText("点击登陆");
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.load:
                intent = new Intent(getActivity(), LoadActivity.class);
                getActivity().startActivityForResult(intent, 1);
                break;
            case R.id.collect:
                intent = new Intent(getActivity(), ColletcionActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.feedback:
                intent = new Intent(getActivity(), FeedBackActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.about:
                intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.setting:
                intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
        }
    }

}
