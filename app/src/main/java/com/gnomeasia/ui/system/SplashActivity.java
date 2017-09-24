package com.gnomeasia.ui.system;

import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.gnomeasia.Contants;
import com.gnomeasia.MyApplication;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseActivity;
import com.gnomeasia.bean.UserBean;
import com.gnomeasia.callback.JsonCallback;
import com.gnomeasia.function.UpdateApp;
import com.gnomeasia.model.BaseResponse;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import me.wangyuwei.particleview.ParticleView;

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
public class SplashActivity extends BaseActivity {
    @BindView(R.id.pv_splash_welcome)
    ParticleView mPvSplashWelcome;
    private boolean mIsBackPressed;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
//        update();
        mPvSplashWelcome.startAnim();

        mPvSplashWelcome.setOnParticleAnimListener(() -> MyApplication.getHandler().postDelayed(() -> {

            if (!TextUtils.isEmpty(MyApplication.getSpUtils().getString(Contants.SP.KEY_USER))) {

                OkGo.<BaseResponse<UserBean>>post(Contants.LOGIN)
                        .params("code", MyApplication.getSpUtils().getString(Contants.SP.KEY_USER))
                        .tag(this)
                        .execute(new JsonCallback<BaseResponse<UserBean>>() {
                            @Override
                            public void onSuccess(Response<BaseResponse<UserBean>> response) {

                                UserBean userBean = response.body().data;

                                EventBus.getDefault().postSticky(userBean);

                                startActivity(MainActivity.newInstance(mContext));
                                finish();
                            }


                            @Override
                            public void onError(Response<BaseResponse<UserBean>> response) {
                                super.onError(response);
                                MyApplication.getSpUtils().put(Contants.SP.KEY_USER, "");
                                ToastUtils.showShort(R.string.error);
                            }
                        });
            } else {
                startActivity(LoginActivity.newInstance(mContext));
                finish();
            }

        }, 500));
    }


    /**
     * 更新模块
     */
    private void update() {
        new UpdateApp().update(this, new UpdateApp.UpdataAppCallBack() {
            @Override
            public void hasNewApp(boolean isPress) {
                mIsBackPressed = isPress;
            }

            @Override
            public void noNewApp() {
                mPvSplashWelcome.setOnParticleAnimListener(() -> MyApplication.getHandler().postDelayed(() -> {

                    if (!TextUtils.isEmpty(MyApplication.getSpUtils().getString(Contants.SP.KEY_USER))) {

                        OkGo.<BaseResponse<UserBean>>post(Contants.LOGIN)
                                .params("code", MyApplication.getSpUtils().getString(Contants.SP.KEY_USER))
                                .tag(this)
                                .execute(new JsonCallback<BaseResponse<UserBean>>() {
                                    @Override
                                    public void onSuccess(Response<BaseResponse<UserBean>> response) {

                                        UserBean userBean = response.body().data;

                                        EventBus.getDefault().postSticky(userBean);

                                        startActivity(MainActivity.newInstance(mContext));
                                        finish();
                                    }


                                    @Override
                                    public void onError(Response<BaseResponse<UserBean>> response) {
                                        super.onError(response);
                                        MyApplication.getSpUtils().put(Contants.SP.KEY_USER, "");
                                        ToastUtils.showShort(R.string.error);
                                    }
                                });
                    } else {
                        startActivity(LoginActivity.newInstance(mContext));
                        finish();
                    }

                }, 500));
            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (mIsBackPressed) {
            super.onBackPressed();
            System.exit(0);
        }
    }
}
