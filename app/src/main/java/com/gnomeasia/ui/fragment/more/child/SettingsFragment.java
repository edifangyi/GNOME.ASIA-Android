package com.gnomeasia.ui.fragment.more.child;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SnackbarUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gnomeasia.Contants;
import com.gnomeasia.MyApplication;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseHomeFragment;
import com.gnomeasia.function.UpdateApp;
import com.gnomeasia.ui.system.LoginActivity;
import com.gnomeasia.ui.system.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by YoKeyword on 16/6/6.
 */
public class SettingsFragment extends BaseHomeFragment {


    @BindView(R.id.toolbarSettings)
    Toolbar mToolbar;
    @BindView(R.id.tv_btn_updata_app)
    TextView mTvBtnUpdataApp;
    @BindView(R.id.tv_btn_logged_out)
    TextView mTvBtnLoggedOut;


    public static SettingsFragment newInstance() {

        Bundle args = new Bundle();

        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_more_settings;
    }

    @Override
    protected void initView(View view) {

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(v -> _mActivity.onBackPressed());

        mTvBtnUpdataApp.setOnClickListener(view1 -> update());

        if (TextUtils.isEmpty(MyApplication.getSpUtils().getString(Contants.SP.KEY_USER))) {
            mTvBtnLoggedOut.setText(getString(R.string.login));
        }
        mTvBtnLoggedOut.setOnClickListener(view12 -> {
            startActivity(LoginActivity.newInstance(mContext));
            ((MainActivity) mContext).finish();
        });
    }

    /**
     * 更新模块
     */
    private void update() {
        new UpdateApp().update((MainActivity) mContext, new UpdateApp.UpdataAppCallBack() {
            @Override
            public void hasNewApp(boolean isPress) {

            }

            @Override
            public void noNewApp() {

                ToastUtils.showShort(getString(R.string.no_update));

            }
        });
    }

    @Override
    public boolean onBackPressedSupport() {

        pop();
        return true;
    }
}
