package com.gnomeasia.ui.fragment.event.child;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gnomeasia.Contants;
import com.gnomeasia.R;
import com.gnomeasia.adapter.EventAdapter;
import com.gnomeasia.base.BaseHeaderAdapter;
import com.gnomeasia.base.BaseHomeFragment;
import com.gnomeasia.callback.JsonCallback;
import com.gnomeasia.bean.EventBean;
import com.gnomeasia.entity.PinnedHeaderEntity;
import com.gnomeasia.model.BaseResponse;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.oushangfeng.pinnedsectionitemdecoration.PinnedHeaderItemDecoration;
import com.oushangfeng.pinnedsectionitemdecoration.callback.OnHeaderClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

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
public class EventHomeFragment extends BaseHomeFragment {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.recycler_view)
    SwipeMenuRecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    List<PinnedHeaderEntity<EventBean.ListRoom.ListSpeark>> mList = new ArrayList<>();

    private EventAdapter mAdapter;

    public static EventHomeFragment newInstance() {
        Bundle args = new Bundle();
        EventHomeFragment fragment = new EventHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_event_home;
    }

    @Override
    protected void initView(View view) {

        mToolbarTitle.setText(getString(R.string.toolbar_event));


        initRefreshLayout();
        initRectclerView();
        initAdapter();
        loadData();
    }

    /**
     * 初始化 下拉刷新
     */
    private void initRefreshLayout() {
        mRefreshLayout.setRefreshing(true);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(() -> loadData());
    }

    /**
     * 初始化 RectclerView
     */
    private void initRectclerView() {
        OnHeaderClickListener headerClickListener = new OnHeaderClickListener() {
            @Override
            public void onHeaderClick(View view, int id, int position) {
            }

            @Override
            public void onHeaderLongClick(View view, int id, int position) {
            }

            @Override
            public void onHeaderDoubleClick(View view, int id, int position) {
            }
        };

        //初始化RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new PinnedHeaderItemDecoration.Builder(BaseHeaderAdapter.TYPE_HEADER).setDividerId(R.drawable.divider).enableDivider(true)
                .setHeaderClickListener(headerClickListener).create());


    }

    /**
     * 初始化 适配器
     */
    private void initAdapter() {
        mList = new ArrayList<>();
        mAdapter = new EventAdapter(mList);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.setNotDoAnimationCount(3);
        mRecyclerView.setAdapter(mAdapter);
    }


    /**
     * 下拉刷新
     */
    private void loadData() {


        OkGo.<BaseResponse<List<EventBean>>>post(Contants.EVENT)
                .tag(this)
                .execute(new JsonCallback<BaseResponse<List<EventBean>>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<List<EventBean>>> response) {

                        List<EventBean> entityList = response.body().data;


                        mList.clear();
                        for (EventBean eventBean : entityList) {

                            for (EventBean.ListRoom listRoom : eventBean.getList()) {

                                EventBean.ListRoom.ListSpeark speark = new EventBean.ListRoom.ListSpeark();
                                mList.add(new PinnedHeaderEntity<>(speark, BaseHeaderAdapter.TYPE_HEADER, eventBean.getTime() + "  →  " + listRoom.getRoom() + getString(R.string.event_room)));

                                for (EventBean.ListRoom.ListSpeark listSpeark : listRoom.getList()) {
                                    mList.add(new PinnedHeaderEntity<>(listSpeark, BaseHeaderAdapter.TYPE_DATA, eventBean.getTime() + "  →  " + listRoom.getRoom()));
                                }

                            }

                        }


                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.loadMoreFinish(false, false);
                        mRefreshLayout.setRefreshing(false);
                    }


                    @Override
                    public void onError(Response<BaseResponse<List<EventBean>>> response) {
                        super.onError(response);
                    }
                });

    }
}