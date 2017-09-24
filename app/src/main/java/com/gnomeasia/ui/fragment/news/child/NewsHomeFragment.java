package com.gnomeasia.ui.fragment.news.child;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gnomeasia.MyApplication;
import com.gnomeasia.R;
import com.gnomeasia.adapter.NewsAdapter;
import com.gnomeasia.base.BaseHomeFragment;
import com.gnomeasia.entity.NewsEntity;
import com.gnomeasia.view.DefineLoadMoreView;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;

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
public class NewsHomeFragment extends BaseHomeFragment {


    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.recycler_view)
    SwipeMenuRecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private ArrayList<NewsEntity> mList;

    private NewsAdapter mAdapter;


    public static NewsHomeFragment newInstance() {
        Bundle args = new Bundle();
        NewsHomeFragment fragment = new NewsHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_home;
    }

    @Override
    protected void initView(View view) {

        mToolbarTitle.setText(getString(R.string.toolbar_news));

        initRefreshLayout();
        initRectclerView();
        initLoadMore();
        initAdapter();


//        OkGo.<String>post("https://linuxstory.org/feed/")
//                .tag(this)
//                .execute(new JsonCallback<String>() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//
//
//                        KLog.xml(response.body().toString());
//
//
//
//
//                    }
//                });

        /**
         * 网络请求
         */
        MyApplication.getHandler().postDelayed(() -> {
            for (int i = 0; i < 10; i++) {
                NewsEntity entity = new NewsEntity();
                entity.setTitle("BY 望天海狸 - 六月,27TH 2017" + i);
                entity.setContext("内容" + i);
                entity.setIslike(false);
                mList.add(entity);
            }
            mAdapter.notifyDataSetChanged();
            mRecyclerView.loadMoreFinish(false, true);
            mRefreshLayout.setRefreshing(false);

        }, 1500);

        addHeadView();
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
        //初始化RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    /**
     * 初始化加载更多
     */
    private void initLoadMore() {
        // 加载更多的监听。
        DefineLoadMoreView loadMoreView = new DefineLoadMoreView(mContext);
        mRecyclerView.addFooterView(loadMoreView); // 添加为Footer。
        mRecyclerView.setLoadMoreView(loadMoreView); // 设置LoadMoreView更新监听。
        mRecyclerView.setLoadMoreListener(() -> loadMore());
    }

    /**
     * 初始化 适配器
     */
    private void initAdapter() {
        mList = new ArrayList<>();
        mAdapter = new NewsAdapter(R.layout.item_news, mList);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.setNotDoAnimationCount(3);
        mRecyclerView.setAdapter(mAdapter);
    }


    /**
     * 添加头
     */
    private void addHeadView() {
        View headView = getLayoutInflater().inflate(R.layout.layout_head_banner, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.addHeaderView(headView);
    }

    /**
     * 加载更多
     */
    private void loadMore() {

        MyApplication.getHandler().postDelayed(() -> {
            ArrayList<NewsEntity> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                NewsEntity entity = new NewsEntity();
                entity.setTitle("BY 望天海狸 - 六月,27TH 2017（加载新） " + i);
                entity.setContext("新 内容 " + i);
                entity.setIslike(false);
                list.add(entity);
            }
            mList.addAll(list);
            mAdapter.notifyItemRangeInserted(mList.size() - list.size() + 1, list.size());
            mRecyclerView.loadMoreFinish(false, true);
        }, 1500);


    }

    /**
     * 下拉刷新
     */
    private void loadData() {

        MyApplication.getHandler().postDelayed(() -> {
            ArrayList<NewsEntity> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                NewsEntity entity = new NewsEntity();
                entity.setTitle("BY 望天海狸 - 六月,27TH 2017（下拉新） " + i);
                entity.setContext("新 内容 " + i);
                entity.setIslike(false);
                list.add(entity);
            }

            mList.addAll(0, list);
            mAdapter.notifyDataSetChanged();

            mRefreshLayout.setRefreshing(false);
            mRecyclerView.loadMoreFinish(false, true);
        }, 1500);


    }
}