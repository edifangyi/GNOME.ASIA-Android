package com.gnomeasia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gnomeasia.ui.fragment.gnome.child.childpager.FirstPagerFragment;
import com.gnomeasia.ui.fragment.gnome.child.childpager.SchedulePagerFragment;


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
public class PagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public PagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = FirstPagerFragment.newInstance(mTitles[position]);
                break;
            case 1:
                fragment = SchedulePagerFragment.newInstance(mTitles[position]);
                break;
            case 2:
                fragment = FirstPagerFragment.newInstance(mTitles[position]);
                break;
            case 3:
                fragment = FirstPagerFragment.newInstance(mTitles[position]);
                break;
            case 4:
                fragment = FirstPagerFragment.newInstance(mTitles[position]);
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
