package news.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baobiao.news.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import news.view.CaiJingView;
import news.view.CommunityView;
import news.view.GuoJiView;
import news.view.GuoNeiView;
import news.view.JunShiView;
import news.view.KeJiView;
import news.view.ShiShangView;
import news.view.TiYuView;
import news.view.TopView;
import news.view.ViewPagerIndicator;
import news.view.YuLeView;

/**
 * Created by baobiao on 2016/11/17.
 */

public class MainHomeFragment extends Fragment {

    private View view;
    private ViewPager mViewPager;
    private ViewPagerIndicator mIndicator;
    private List<View> views;
    private List<String> mDatas = Arrays.asList("头条", "社会", "国内", "国际", "娱乐", "体育"
            , "军事", "科技", "财经", "时尚");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vp_indicator, container, false);
        initView();
        initDatas();
        //设置Tab上的标题
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(new MyAdapter(views));
        mViewPager.setOffscreenPageLimit(2);
        //设置关联的ViewPager
        mIndicator.setViewPager(mViewPager, 0);
        return view;
    }

    private void initDatas() {
        views = new ArrayList<View>();
        TopView top = (TopView) TopView.getInstance(getActivity());
        CommunityView community = (CommunityView) CommunityView.getInstance(getActivity());
        GuoNeiView guoNei = (GuoNeiView) GuoNeiView.getInstance(getActivity());
        GuoJiView guoJi = (GuoJiView) GuoJiView.getInstance(getActivity());
        YuLeView yuLe = (YuLeView) YuLeView.getInstance(getActivity());

        TiYuView tiYu = (TiYuView) TiYuView.getInstance(getActivity());
        JunShiView junShi = (JunShiView) JunShiView.getInstance(getActivity());
        KeJiView keJi = (KeJiView) KeJiView.getInstance(getActivity());
        CaiJingView caijing = (CaiJingView) CaiJingView.getInstance(getActivity());
        ShiShangView shiShang = (ShiShangView) ShiShangView.getInstance(getActivity());

        views.add(top.getView());
        views.add(community.getView());
        views.add(guoNei.getView());
        views.add( guoJi.getView());
        views.add( yuLe.getView());

        views.add(tiYu.getView());
        views.add( junShi.getView());
        views.add(keJi.getView());
        views.add(caijing.getView());
        views.add(shiShang.getView());
    }

    private class MyAdapter extends PagerAdapter {
        private List<View> views;

        public MyAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(views.get(position));
            return views.get(position);
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (object);
//	            return false;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(views.get(position));
        }

        @Override
        public Parcelable saveState() {
            return super.saveState();
        }
    }


    private void initView() {
        mViewPager = (ViewPager) view.findViewById(R.id.id_vp);
        mIndicator = (ViewPagerIndicator) view.findViewById(R.id.id_indicator);
    }
}
