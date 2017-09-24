package com.gnomeasia.ui.system;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.gnomeasia.Contants;
import com.gnomeasia.MyApplication;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseActivity;
import com.gnomeasia.bean.UserBean;
import com.gnomeasia.callback.JsonCallback;
import com.gnomeasia.model.BaseResponse;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;


import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

/**
 * Created by FANGYI on 2017/9/23.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_login_get_token)
    TextView mTvLoginGetToken;
    @BindView(R.id.edit_login_token)
    EditText mEditLoginToken;
    @BindView(R.id.btn_login_go)
    Button mBtnLoginGo;
    @BindView(R.id.btn_login_no_token)
    TextView mBtnLoginNoToken;

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {


        mTvLoginGetToken.setOnClickListener(view -> {
            startActivity(MainActivity.newInstance(mContext));
        });


        if (!TextUtils.isEmpty(MyApplication.getSpUtils().getString(Contants.SP.KEY_USER))) {
            mEditLoginToken.setText(MyApplication.getSpUtils().getString(Contants.SP.KEY_USER));
            mEditLoginToken.setSelection(MyApplication.getSpUtils().getString(Contants.SP.KEY_USER).length());
        }


        mBtnLoginGo.setOnClickListener(view -> {

            if (!verify()) return;

            mEditLoginToken.setEnabled(false);
            mBtnLoginGo.setEnabled(false);


            OkGo.<BaseResponse<UserBean>>post(Contants.LOGIN)
                    .params("code", mEditLoginToken.getText().toString())
                    .tag(this)
                    .execute(new JsonCallback<BaseResponse<UserBean>>() {
                        @Override
                        public void onSuccess(Response<BaseResponse<UserBean>> response) {

                            MyApplication.getSpUtils().put(Contants.SP.KEY_USER, mEditLoginToken.getText().toString());

                            UserBean userBean = response.body().data;

                            EventBus.getDefault().postSticky(userBean);

                            startActivity(MainActivity.newInstance(mContext));
                            finish();
                        }


                        @Override
                        public void onError(Response<BaseResponse<UserBean>> response) {
                            super.onError(response);
                            MyApplication.getSpUtils().put(Contants.SP.KEY_USER, "");
                            mEditLoginToken.setEnabled(true);
                            mBtnLoginGo.setEnabled(true);
                            KLog.e("========" + response.getException().getMessage());
                        }
                    });

        });

        mBtnLoginNoToken.setOnClickListener(view -> {
            MyApplication.getSpUtils().put(Contants.SP.KEY_USER, "");
            startActivity(MainActivity.newInstance(mContext));
            finish();
        });


    }

    /**
     * 校验
     *
     * @return
     */
    private boolean verify() {

        if (TextUtils.isEmpty(mEditLoginToken.getText().toString())) {
            ToastUtils.showShort(getString(R.string.content_cannot_be_empty));
            return false;
        } else
            return true;

    }
}
