package com.gnomeasia.ui.fragment.more.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gnomeasia.R;
import com.gnomeasia.base.BaseHomeFragment;
import com.gnomeasia.ui.system.LoginActivity;
import com.gnomeasia.ui.system.MainActivity;
import com.gnomeasia.utils.glide.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by YoKeyword on 16/6/6.
 */
public class AvatarFragment extends BaseHomeFragment {
    public static final String TICKET_CODE = "ticket_code";
    public static final String TICKET_USER_NICKNAME = "ticket_user_nickname";
    public static final String TICKET_USER_AVATAR = "ticket_user_avatar";

    @BindView(R.id.iv_ticket_user_avatar)
    ImageView mIvTicketUserAvatar;
    @BindView(R.id.tv_ticket_user_nickname)
    TextView mTvTicketUserNickname;
    @BindView(R.id.tv_ticket_code)
    TextView mTvTicketCode;
    @BindView(R.id.ll_code_nickname)
    LinearLayout mLlCodeNickname;


    private String ticket_code;
    private String ticket_user_nickname;
    private String ticket_user_avatar;


    public static AvatarFragment newInstance(String ticket_code, String ticket_user_nickname, String ticket_user_avatar) {
        Bundle args = new Bundle();

        args.putString(TICKET_CODE, ticket_code);
        args.putString(TICKET_USER_NICKNAME, ticket_user_nickname);
        args.putString(TICKET_USER_AVATAR, ticket_user_avatar);
        AvatarFragment fragment = new AvatarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static AvatarFragment newInstance() {
        Bundle args = new Bundle();
        AvatarFragment fragment = new AvatarFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ticket_code = getArguments().getString(TICKET_CODE);
        ticket_user_nickname = getArguments().getString(TICKET_USER_NICKNAME);
        ticket_user_avatar = getArguments().getString(TICKET_USER_AVATAR);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_more_avatar;
    }

    @Override
    protected void initView(View view) {

        if (TextUtils.isEmpty(ticket_code)) {
            mLlCodeNickname.setVisibility(View.GONE);
            mIvTicketUserAvatar.setOnClickListener(view1 -> {
                startActivity(LoginActivity.newInstance(mContext));
                ((MainActivity) mContext).finish();
            });
        } else {
            GlideUtils.getInstance().LoadContextBitmap(mContext,
                    ticket_user_avatar,
                    mIvTicketUserAvatar,
                    R.drawable.ic_account_circle_black_24dp,
                    R.drawable.ic_account_circle_black_24dp,
                    null);
            mTvTicketUserNickname.setText(ticket_user_nickname);
            mTvTicketCode.setText(ticket_code);
        }


    }

}
