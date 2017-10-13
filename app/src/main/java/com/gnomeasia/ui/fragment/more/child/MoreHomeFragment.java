package com.gnomeasia.ui.fragment.more.child;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gnomeasia.R;
import com.gnomeasia.base.BaseHomeFragment;
import com.gnomeasia.bean.TicketCustomFields;
import com.gnomeasia.bean.UserBean;
import com.gnomeasia.ui.fragment.more.MoreFragment;
import com.gnomeasia.ui.system.OrderActivity;
import com.gnomeasia.utils.glide.GlideUtils;
import com.gnomeasia.utils.http.Convert;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
public class MoreHomeFragment extends BaseHomeFragment {
    private static final String USERBEAN = "userBean";

    @BindView(R.id.tv_btn_settings)
    TextView mTvBtnSettings;
    @BindView(R.id.tv_btn_order_details)
    TextView mTvBtnOrder;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_work_address)
    TextView mTvWorkAddress;
    @BindView(R.id.tv_ticket_email)
    TextView mTvTicketEmail;
    @BindView(R.id.tv_ticket_phone)
    TextView mTvTicketPhone;
    @BindView(R.id.tv_ticket_order_id)
    TextView mTvTicketOrderId;
    @BindView(R.id.tv_ticket_total_amount)
    TextView mTvTicketTotalAmount;
    @BindView(R.id.tv_ticket_discount_amount)
    TextView mTvTicketDiscountAmount;
    @BindView(R.id.tv_ticket_refunded_amount)
    TextView mTvTicketRefundedAmount;

    private UserBean userBean;

    public static MoreHomeFragment newInstance(UserBean userBean) {
        Bundle args = new Bundle();
        args.putParcelable(USERBEAN, userBean);
        MoreHomeFragment fragment = new MoreHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static MoreHomeFragment newInstance() {
        Bundle args = new Bundle();
        MoreHomeFragment fragment = new MoreHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userBean = getArguments().getParcelable(USERBEAN);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_more_home;
    }

    @Override
    protected void initView(View view) {

        if (userBean == null) {

            mTvName.setVisibility(View.GONE);
            mTvWorkAddress.setVisibility(View.GONE);
            mTvTicketEmail.setVisibility(View.GONE);
            mTvTicketPhone.setVisibility(View.GONE);
            mTvTicketOrderId.setVisibility(View.GONE);
            mTvTicketTotalAmount.setVisibility(View.GONE);
            mTvTicketDiscountAmount.setVisibility(View.GONE);
            mTvTicketRefundedAmount.setVisibility(View.GONE);

        } else {
            List<TicketCustomFields> ticketCustomFields = Convert.fromJson(userBean.getTicket_custom_fields(), new TypeToken<List<TicketCustomFields>>() {
            }.getType());

            mTvName.setText(getString(R.string.more_name) + ticketCustomFields.get(0).getValue().substring(4, ticketCustomFields.get(0).getValue().length()));
            mTvWorkAddress.setText(getString(R.string.more_work_address) + ticketCustomFields.get(1).getValue().substring(4, ticketCustomFields.get(1).getValue().length()));
            mTvTicketEmail.setText(getString(R.string.more_email) + userBean.getTicket_email());
            mTvTicketPhone.setText(getString(R.string.more_phone) + userBean.getTicket_phone());
            mTvTicketOrderId.setText(getString(R.string.more_order_id) + userBean.getTicket_order_id());
            mTvTicketTotalAmount.setText(getString(R.string.more_total_amount) + userBean.getTicket_total_amount());
            mTvTicketDiscountAmount.setText(getString(R.string.more_discount_amount) + userBean.getTicket_discount_amount());
            mTvTicketRefundedAmount.setText(getString(R.string.more_refunded_amount) + userBean.getTicket_refunded_amount());
        }


        mTvBtnSettings.setOnClickListener(v -> start(SettingsFragment.newInstance()));
        mTvBtnOrder.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), OrderActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onBackPressedSupport() {
        // 这里实际项目中推荐使用 EventBus接耦
        ((MoreFragment) getParentFragment()).onBackToFirstFragment();
        return true;
    }
}