package com.gnomeasia.ui.system;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseActivity;
import com.gnomeasia.base.BaseMainFragment;
import com.gnomeasia.ui.fragment.event.EventFragment;
import com.gnomeasia.ui.fragment.event.child.EventHomeFragment;
import com.gnomeasia.ui.fragment.gnome.GnomeFragment;
import com.gnomeasia.ui.fragment.gnome.child.GnomeViewPagerFragment;
import com.gnomeasia.ui.fragment.more.MoreFragment;
import com.gnomeasia.ui.fragment.more.child.MoreHomeFragment;
import com.gnomeasia.ui.fragment.news.NewsFragment;
import com.gnomeasia.ui.fragment.news.child.NewsHomeFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
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
public class MainActivity extends BaseActivity implements BaseMainFragment.OnBackToFirstListener {


    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;

    int lastSelectedPosition = 0;

    private SupportFragment[] mFragments = new SupportFragment[4];


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {


        SupportFragment firstFragment = findFragment(NewsFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = NewsFragment.newInstance();
            mFragments[SECOND] = EventFragment.newInstance();
            mFragments[THIRD] = GnomeFragment.newInstance();
            mFragments[FOURTH] = MoreFragment.newInstance();

            loadMultipleRootFragment(R.id.home_activity_frag_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.findFragmentByTag()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(EventFragment.class);
            mFragments[THIRD] = findFragment(GnomeFragment.class);
            mFragments[FOURTH] = findFragment(MoreFragment.class);
        }


        initBnv();
    }

    private void initBnv() {

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_main_news_red_24dp, R.string.main_news).setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_event_red_24dp, R.string.main_event).setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_gnome_red_24dp, R.string.main_gnome).setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.drawable.ic_main_more_red_24dp, R.string.main_more).setActiveColorResource(R.color.red))
                .setFirstSelectedPosition(lastSelectedPosition > 3 ? 3 : lastSelectedPosition)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                lastSelectedPosition = position;
            }

            @Override
            public void onTabUnselected(int position) {
                showHideFragment(mFragments[lastSelectedPosition], mFragments[position]);
            }

            @Override
            public void onTabReselected(int position) {
                final SupportFragment currentFragment = mFragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();

                // 如果不在该类别Fragment的主页,则回到主页;
                if (count > 1) {
                    if (currentFragment instanceof NewsHomeFragment) {
                        currentFragment.popToChild(NewsHomeFragment.class, false);
                    } else if (currentFragment instanceof EventFragment) {
                        currentFragment.popToChild(EventHomeFragment.class, false);
                    } else if (currentFragment instanceof GnomeFragment) {
                        currentFragment.popToChild(GnomeViewPagerFragment.class, false);
                    } else if (currentFragment instanceof MoreHomeFragment) {
                        currentFragment.popToChild(MoreHomeFragment.class, false);
                    }
                    return;
                }

//                // 这里推荐使用EventBus来实现 -> 解耦
//                if (count == 1) {
//                    // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
//                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                    EventBus.getDefault().post(new TabSelectedEvent(position));
//                }

            }
        });
    }


    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Override
    public void onBackToFirstFragment() {

        mBottomNavigationBar.selectTab(0);
        showHideFragment(mFragments[0]);
    }
}
