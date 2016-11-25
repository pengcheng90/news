package news.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.baobiao.news.R;

import cn.bmob.v3.Bmob;
import news.fragment.JokeFragment;
import news.fragment.MainHomeFragment;
import news.fragment.MeFragment;
import news.fragment.WeiXinThermalFragment;

/**
 * MainActivity主页面
 */
public class MainActivity extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "MainActivity";
    private RadioButton tab_mainhome, tab_weixinthermal, tab_joke, tab_me;
    private RadioGroup mRadioGroup;
    private Fragment mMainHomeFragment, mWeiXinThermalFragment, mJokeFragmnet;
    private MeFragment meFragment;
    private Fragment mCurrentFragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //第一：默认初始化
        Bmob.initialize(this, "931b3d2f9329f8fa362dc046d5402f9c");
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        tab_mainhome = (RadioButton) findViewById(R.id.tab_mainhome);

        mRadioGroup.setOnCheckedChangeListener(this);
        tab_mainhome.setChecked(true);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
        FragmentManager fm = getFragmentManager();
        transaction = fm.beginTransaction();
        if (mCurrentFragment == null) {
            mCurrentFragment=new MainHomeFragment();
            transaction.add(R.id.fl, mCurrentFragment);
        }
        switch (checkId) {
            case R.id.tab_mainhome:
                if (!(mCurrentFragment instanceof MainHomeFragment)) {
                    changeFragment(1);
                }
                break;
            case R.id.tab_weixinthermal:
                if (!(mCurrentFragment instanceof WeiXinThermalFragment)) {
                    changeFragment(2);
                }
                break;
            case R.id.tab_joke:
                if (!(mCurrentFragment instanceof JokeFragment)) {
                    changeFragment(3);
                }
                break;
            case R.id.tab_me:
                if (!(mCurrentFragment instanceof MeFragment)) {
                    changeFragment(4);
                }
                break;
        }
        transaction.commit();
    }

    private void changeFragment(int tag) {
        switch (tag) {
            case 1:
                transaction.hide(mCurrentFragment);

                if (mMainHomeFragment == null) {
                    mMainHomeFragment = new MainHomeFragment();
                    transaction.add(R.id.fl, mMainHomeFragment);
                } else {
                    transaction.show(mMainHomeFragment);
                }
                mCurrentFragment = mMainHomeFragment;
                break;
            case 2:
                transaction.hide(mCurrentFragment);
                if (mWeiXinThermalFragment == null) {
                    mWeiXinThermalFragment = new WeiXinThermalFragment();
                    transaction.add(R.id.fl, mWeiXinThermalFragment);
                } else {
                    transaction.show(mWeiXinThermalFragment);
                }
                mCurrentFragment = mWeiXinThermalFragment;
                break;
            case 3:
                transaction.hide(mCurrentFragment);
                if (mJokeFragmnet == null) {
                    mJokeFragmnet = new JokeFragment();
                    transaction.add(R.id.fl, mJokeFragmnet);
                } else {
                    transaction.show(mJokeFragmnet);
                }
                mCurrentFragment = mJokeFragmnet;
                break;
            case 4:
                transaction.hide(mCurrentFragment);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.fl, meFragment);
                } else {
                    transaction.show(meFragment);
                }
                mCurrentFragment = meFragment;
                break;
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tra = fm.beginTransaction();
        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(i);
            if (!radioButton.isChecked()) {
                if(i==0){
                    tra.hide(mMainHomeFragment);
                }
                if(i==0){
                    tra.hide(mWeiXinThermalFragment);
                }
                if(i==0){
                    tra.hide(mJokeFragmnet);
                }
                if(i==0){
                    tra.hide(meFragment);
                }
            }
            tra.commit();
        }
    }
}
