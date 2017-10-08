package com.gnomeasia.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gnomeasia.R;
import com.gnomeasia.entity.NewsEntity;
import com.gnomeasia.utils.glide.GlideUtils;
import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

import java.util.ArrayList;
import java.util.Random;

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
public class NewsAdapter extends BaseQuickAdapter<NewsEntity, BaseViewHolder> {


    public NewsAdapter(@Nullable ArrayList<NewsEntity> data) {
        super(R.layout.item_news, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsEntity item) {


        holder.setText(R.id.tv_news_title, item.getTitle());
        holder.setText(R.id.tv_news_data, item.getData());
        holder.setText(R.id.tv_news_description, item.getDescription());

        ((SparkButton) holder.getView(R.id.heart_button)).setChecked(item.getLike());

        ((SparkButton) holder.getView(R.id.heart_button)).setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {

                item.setLike(buttonState);

            }

            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }

            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });
    }
}
