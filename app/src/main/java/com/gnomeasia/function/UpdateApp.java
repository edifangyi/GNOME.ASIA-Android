package com.gnomeasia.function;

import android.app.Activity;

import com.blankj.utilcode.util.AppUtils;

import com.gnomeasia.Contants;
import com.gnomeasia.utils.http.OkGoUpdateHttpUtil;
import com.socks.library.KLog;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2017/9/23
 * 说    明：
 * ================================================
 */
public class UpdateApp {


    public void update(Activity activity, UpdataAppCallBack updataAppCallBack) {

        new UpdateAppManager.Builder()
                //必须设置，当前Activity
                .setActivity(activity)
                //必须设置，实现httpManager接口的对象
                .setHttpManager(new OkGoUpdateHttpUtil())
                .setUpdateUrl(Contants.CHECK_UPDATE)
                .build()
                .checkNewApp(new UpdateCallback() {
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        return super.parseJson(json);
                    }

                    /**
                     * 有新版本
                     *
                     * @param updateApp        新版本信息
                     * @param updateAppManager app更新管理器
                     */
                    @Override
                    public void hasNewApp(UpdateAppBean updateApp, UpdateAppManager updateAppManager) {

                        KLog.e("===1===" + AppUtils.getAppVersionName());
                        KLog.e("===2===" + updateApp.getNewVersion());

                        if (AppUtils.getAppVersionName().equals(updateApp.getNewVersion())) {

                            updataAppCallBack.noNewApp();

                        } else {
                            updataAppCallBack.hasNewApp(true);
                            updateAppManager.showDialogFragment();
                        }


                    }

                    //网络请求之前
                    @Override
                    public void onBefore() {
                    }

                    //网路请求之后
                    @Override
                    public void onAfter() {
                    }

                    //没有新版本
                    @Override
                    public void noNewApp() {

                        updataAppCallBack.noNewApp();

                    }
                });
    }


    public interface UpdataAppCallBack {

        void hasNewApp(boolean isPress);

        void noNewApp();
    }
}
