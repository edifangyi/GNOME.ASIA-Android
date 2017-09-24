package com.gnomeasia.ui.fragment.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gnomeasia.Contants;
import com.gnomeasia.MyApplication;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseMainFragment;
import com.gnomeasia.bean.UserBean;
import com.gnomeasia.ui.fragment.more.child.AvatarFragment;
import com.gnomeasia.ui.fragment.more.child.MoreHomeFragment;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

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
public class MoreFragment extends BaseMainFragment {

    private View mView;
    private TextView mToolbarTitle;


    private UserBean mUserBean;

    public static MoreFragment newInstance() {
        Bundle args = new Bundle();
        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_more, container, false);
        EventBus.getDefault().register(this);// 订阅
        return mView;
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getUserBean(UserBean userBean) {
        mUserBean = userBean;
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (findChildFragment(AvatarFragment.class) == null) {
            loadFragment();
        }
        mToolbarTitle = (TextView) mView.findViewById(R.id.toolbar_title);
        mToolbarTitle.setText(getString(R.string.toolbar_more));
    }


    private void loadFragment() {
        if (!TextUtils.isEmpty(MyApplication.getSpUtils().getString(Contants.SP.KEY_USER))) {

            loadRootFragment(R.id.fl_more_container_upper, AvatarFragment.newInstance(mUserBean.getTicket_code(),
                    mUserBean.getTicket_user_nickname(),
                    mUserBean.getTicket_user_avatar()));
            loadRootFragment(R.id.fl_more_container_lower, MoreHomeFragment.newInstance(mUserBean));

        } else {
            loadRootFragment(R.id.fl_more_container_upper, AvatarFragment.newInstance());
            loadRootFragment(R.id.fl_more_container_lower, MoreHomeFragment.newInstance());
        }

    }


    public void onBackToFirstFragment() {
        _mBackToFirstListener.onBackToFirstFragment();
    }
}
