package com.gnomeasia.ui.fragment.news.child;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.transition.Fade;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fingdo.statelayout.StateLayout;
import com.gnomeasia.R;
import com.gnomeasia.adapter.NewsAdapter;
import com.gnomeasia.base.BaseHomeFragment;
import com.gnomeasia.entity.NewsEntity;
import com.gnomeasia.ui.system.MainActivity;
import com.gnomeasia.view.DefineLoadMoreView;
import com.gnomeasia.view.DetailTransition;
import com.socks.library.KLog;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import org.mcsoxford.rss.RSSFeed;
import org.mcsoxford.rss.RSSItem;
import org.mcsoxford.rss.RSSReader;
import org.mcsoxford.rss.RSSReaderException;

import java.text.SimpleDateFormat;
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
    @BindView(R.id.state_layout)
    StateLayout mStateLayout;


    private ArrayList<NewsEntity> mList;

    private NewsAdapter mAdapter;

    private int cat = 0;

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

        mStateLayout.setUseAnimation(true);

        initRefreshLayout();
        initRectclerView();
        initLoadMore();
        initAdapter();
        loadData(cat);

    }


    private void initRefreshLayout() {
        mRefreshLayout.setRefreshing(true);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(() -> {
                    cat = 0;
                    loadData(cat);
                }

        );
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
        mRecyclerView.setLoadMoreListener(() -> {
            cat++;
            loadMore(cat);
        });
    }

    /**
     * 初始化 适配器
     */
    private void initAdapter() {
        mList = new ArrayList<>();
        mAdapter = new NewsAdapter(mList);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.setNotDoAnimationCount(3);
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.setSwipeItemClickListener((itemView, position) -> {

            KLog.e("==========" + mList.get(position).getLink());

            NewsItemFragment fragment = NewsItemFragment.newInstance(mList.get(position).getLink());
            start(fragment);

        });
    }


//    /**
//     * 添加头
//     */
//    private void addHeadView() {
//        View headView = getLayoutInflater().inflate(R.layout.layout_head_banner, (ViewGroup) mRecyclerView.getParent(), false);
//        mAdapter.addHeaderView(headView);
//    }

    /**
     * 加载更多
     *
     * @param cat
     */
    private void loadMore(int cat) {

        new Thread(() -> {
            try {

                RSSReader reader = new RSSReader();
                String uri = "https://linuxstory.org/feed/?cat=" + cat;
                RSSFeed feed = reader.load(uri);

                ArrayList<NewsEntity> list = new ArrayList<>();

                for (RSSItem rssItem : feed.getItems()) {

                    NewsEntity entity = new NewsEntity();
                    entity.setTitle(rssItem.getTitle());
                    entity.setDescription(rssItem.getDescription());
                    entity.setLink(rssItem.getLink().toString());
                    entity.setData(TimeUtils.date2String(rssItem.getPubDate(), new SimpleDateFormat("yyyy MM dd HH:mm:ss")));
                    entity.setLike(true);
                    list.add(entity);

                }

                if (list.size() == 0) {
                    ((MainActivity) mContext).runOnUiThread(() -> mRecyclerView.loadMoreFinish(false, false));


                } else {
                    mList.addAll(list);
                    ((MainActivity) mContext).runOnUiThread(() -> {
                        mAdapter.notifyDataSetChanged();
                        mAdapter.notifyItemRangeInserted(mList.size() - list.size() + 1, list.size());
                        mRecyclerView.loadMoreFinish(false, true);
                    });
                }


            } catch (RSSReaderException e) {

                mRecyclerView.loadMoreError(e.getStatus(), "发生错误！");
//                mStateLayout.showErrorView();
                e.printStackTrace();
            }
        }).start();

    }

    /**
     * 下拉刷新
     */
    private void loadData(int cat) {

        mList.clear();

        new Thread(() -> {
            try {

                RSSReader reader = new RSSReader();
                String uri = "https://linuxstory.org/feed/?cat=" + cat;
                RSSFeed feed = reader.load(uri);

                ArrayList<NewsEntity> list = new ArrayList<>();
                for (RSSItem rssItem : feed.getItems()) {
                    NewsEntity entity = new NewsEntity();
                    entity.setTitle(rssItem.getTitle());

                    entity.setDescription(rssItem.getDescription());
                    entity.setLink(rssItem.getLink().toString());

                    entity.setData(TimeUtils.date2String(rssItem.getPubDate(), new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss")));


                    entity.setLike(true);

                    KLog.e("=========" + entity.toString());

                    list.add(entity);
                }

                mList.addAll(0, list);

                mStateLayout.showContentView();

                ((MainActivity) mContext).runOnUiThread(() -> {
                    mAdapter.notifyDataSetChanged();
                    mRecyclerView.loadMoreFinish(false, true);
                    mRefreshLayout.setRefreshing(false);
                });


                KLog.e("==getTitle======" + feed.getTitle());
                KLog.e("==getDescription==" + feed.getDescription());
                KLog.e("==getLink==" + feed.getLink());


            } catch (RSSReaderException e) {
                mStateLayout.showErrorView();
                e.printStackTrace();
            }
        }).start();

    }
}