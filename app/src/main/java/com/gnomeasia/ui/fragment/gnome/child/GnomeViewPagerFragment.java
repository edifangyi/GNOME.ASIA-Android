package com.gnomeasia.ui.fragment.gnome.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gnomeasia.R;
import com.gnomeasia.adapter.PagerFragmentAdapter;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * ================================================
 * 作    者：FangYi
 * 邮    箱：87649669@qq.com
 * 版    本：1.0
 * 日    期：2017/8/23
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class GnomeViewPagerFragment extends SupportFragment {

    TabLayout mTab;
    ViewPager mViewPager;

    public static GnomeViewPagerFragment newInstance() {

        Bundle args = new Bundle();

        GnomeViewPagerFragment fragment = new GnomeViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gnome_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());

        mViewPager.setAdapter(new PagerFragmentAdapter(getChildFragmentManager(),
                getString(R.string.tab_gnome_news), getString(R.string.tab_gnome_schedule), getString(R.string.tab_gnome_venue), getString(R.string.tab_gnome_sponsor), getString(R.string.tab_gnome_staff)));

        mTab.setupWithViewPager(mViewPager);
    }

}
