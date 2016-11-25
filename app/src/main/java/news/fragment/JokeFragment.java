package news.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baobiao.news.R;

/**
 * Created by baobiao on 2016/11/19.
 */

public class JokeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "JokeFragment";
    private View view;
    private FragmentTransaction tra;
    private Fragment mCurrentFragment, quTuFragment, jestFragment;
    private TextView qutu, joke;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_joke, container, false);
        initView();
        return view;

    }

    private void initView() {
        qutu = (TextView) view.findViewById(R.id.qutu);
        joke = (TextView) view.findViewById(R.id.joke);
        qutu.setOnClickListener(this);
        joke.setOnClickListener(this);
        onClick(qutu);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = getChildFragmentManager();
        tra = fm.beginTransaction();
        if (mCurrentFragment == null) {
            mCurrentFragment = getFragment(1);
            tra.add(R.id.fl_joke,mCurrentFragment);
        }

        switch (view.getId()) {
            case R.id.qutu:
                if (!(mCurrentFragment instanceof QuTuFragment)) {
                    changeFragment(getFragment(1));
                }
                clearBackGround(R.id.qutu);
                break;
            case R.id.joke:
                if (!(mCurrentFragment instanceof JestFragment)) {
                    changeFragment(getFragment(2));
                }
                clearBackGround(R.id.joke);
                break;

        }
        tra.commit();
    }

    private void clearBackGround(int viewId) {
        switch (viewId) {

            case R.id.qutu:
                qutu.setBackgroundResource(R.color.bg_joke);
                joke.setBackgroundResource(R.color.white1);
                break;
            case R.id.joke:
                qutu.setBackgroundResource(R.color.white1);
                joke.setBackgroundResource(R.color.bg_joke);
                break;

        }
    }

    private Fragment getFragment(int type) {
        switch (type) {
            case 1:
                if (quTuFragment == null) {
                    return new QuTuFragment();
                } else {
                    return quTuFragment;
                }
            case 2:
                if (jestFragment == null) {
                    return new JestFragment();
                } else {
                    return jestFragment;
                }
        }
        return null;
    }

    private void changeFragment(Fragment fragment) {
        tra.hide(mCurrentFragment);
        tra.add(R.id.fl_joke, fragment);
        mCurrentFragment = fragment;
    }
}
