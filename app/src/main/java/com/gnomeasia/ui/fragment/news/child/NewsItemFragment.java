package com.gnomeasia.ui.fragment.news.child;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fingdo.statelayout.StateLayout;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2017/10/9.
 */

public class NewsItemFragment extends BaseBackFragment {
    private static final String LINK = "link";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.web_view)
    WebView mWebView;

    @BindView(R.id.state_layout)
    StateLayout mStateLayout;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    private String mLink;


    public static NewsItemFragment newInstance(String link) {
        Bundle args = new Bundle();
        args.putString(LINK, link);
        NewsItemFragment fragment = new NewsItemFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_item, container, false);
        mLink = getArguments().getString(LINK);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(v -> _mActivity.onBackPressed());


        mRefreshLayout.setOnRefreshListener(() -> mWebView.reload());

        mWebView.loadUrl(mLink);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mRefreshLayout.setRefreshing(true);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mRefreshLayout.setRefreshing(false);
                mStateLayout.showContentView();
            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                mStateLayout.showErrorView();
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onReceivedTitle(WebView view, String title) {

                mToolbar.setTitle(title);
            }
        });


        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(true);
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        webSettings.setSupportZoom(true);
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mWebView.destroy();
    }
}
