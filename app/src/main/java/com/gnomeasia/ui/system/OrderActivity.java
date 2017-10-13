package com.gnomeasia.ui.system;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.fingdo.statelayout.StateLayout;
import com.github.sumimakito.awesomeqr.AwesomeQRCode;
import com.gnomeasia.Contants;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseActivity;
import com.gnomeasia.base.BaseHeaderAdapter;
import com.gnomeasia.bean.EventBean;
import com.gnomeasia.bean.OrderBean;
import com.gnomeasia.callback.JsonCallback;
import com.gnomeasia.entity.PinnedHeaderEntity;
import com.gnomeasia.model.BaseResponse;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;

import org.apache.commons.logging.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportActivity;
import pub.devrel.easypermissions.EasyPermissions;

public class OrderActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks{

    @BindView(R.id.order_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.img_order_call)
    ImageView mCall;
    @BindView(R.id.tv_start_time)
    TextView mStartTime;
    @BindView(R.id.img_order_QR)
    ImageView mQR;
    @BindView(R.id.tv_order_code)
    TextView mCode;
    @BindView(R.id.tv_order_sign_time)
    TextView mSignTime;
    @BindView(R.id.tv_order_price)
    TextView mOrderPrice;
    @BindView(R.id.tv_ticket_type)
    TextView mTicketType;
    @BindView(R.id.tv_ticket_count)
    TextView mCount;
    @BindView(R.id.tv_order_createtime)
    TextView mCreateTime;
    @BindView(R.id.tv_order_number)
    TextView morderNumber;
    @BindView(R.id.tv_order_status)
    TextView morderStatus;
    @BindView(R.id.sl_order_scroll)
    ScrollView mScrollView;

    @BindView(R.id.rl_refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    String phoneString = "";



    @Override
    protected int getContentViewId() {
        return R.layout.activity_order;
    }

    @Override
    protected void init() {
        mScrollView.setVisibility(View.GONE);

//        mRefreshLayout.setOnRefreshListener(() -> {
//            mScrollView.setVisibility(View.VISIBLE);
//        });
        mRefreshLayout.setRefreshing(true);
        load();

        mCall.setOnClickListener(v -> {

            if (!TextUtils.isEmpty(phoneString)){
                applyPermission();
            }


        });

    }


    private void load() {
        OkGo.<BaseResponse<OrderBean>>post(Contants.ORDER_DETAILES)
                .tag(this)
                .execute(new JsonCallback<BaseResponse<OrderBean>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<OrderBean>> response) {
                        OrderBean orderBean = response.body().data;
                        mRefreshLayout.setRefreshing(false);
                        mScrollView.setVisibility(View.VISIBLE);

                        phoneString = orderBean.getTicket_phone();
                        mCode.setText(orderBean.getTicket_code());
                        mSignTime.setText("");
                        mOrderPrice.setText(orderBean.getTicket_paid_amount()+"元");
                        mTicketType.setText("");
                        mCount.setText(orderBean.getTicket_quantity());
                        mCreateTime.setText(orderBean.getTicket_created_at());
                        morderNumber.setText(orderBean.getTicket_order_id());
                        morderStatus.setText(orderBean.getTicket_status());
                        if (orderBean.getTicket_code()!=null){
                            Bitmap bmp = getQR(orderBean.getTicket_code());
                            mQR.setImageBitmap(bmp);
                        }
                    }

                    @Override
                    public void onError(Response<BaseResponse<OrderBean>> response) {
                        super.onError(response);
                        Toast.makeText(OrderActivity.this,"数据错误",Toast.LENGTH_SHORT).show();
                        mRefreshLayout.setRefreshing(false);
                    }
                });
    }

    private Bitmap getQR(String code){

        Bitmap qrBitmap = AwesomeQRCode.create(code,420,
                20,// 二维码图像的外边距, 默认 20px
                1.0f,//数据区域点缩小比例
                Color.parseColor("#000000"),//实点的颜色
                Color.parseColor("#ffffff"),//空白区的颜色
                null,//欲嵌入的背景图, 设为 null 以禁用
                true,// Default is true. 若设为 true, 背景图外将绘制白色边框
                true,//Default is true. 若为 true, 背景图的主要颜色将作为实点的颜色, 即 colorDark
                false//Default is false. 若为 true, 数据点将以圆点绘制, 取代默认的小方块
               );
        return qrBitmap;
    }


    /**
     * 申请拨打电话权限
     */
    private void applyPermission(){
        String[] perms = {Manifest.permission.CALL_PHONE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneString));
            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(this,perms,0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    //分别返回授权成功和失败的权限
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneString));
        startActivity(intent);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(OrderActivity.this,"请到设置-权限管理中开启拨打电话权限！",Toast.LENGTH_SHORT).show();
    }
}
