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

    String imgUrl0 = "https://cdn.sspai.com/2017/08/20/ced45c2415dbb295d6f782368a3087ae.png?imageMogr2/quality/95/thumbnail/!700x233r/gravity/Center/crop/700x233";
    String imgUrl1 = "https://cdn.sspai.com/article/59f09cd9-06bc-277e-25cd-22b35014ee9f.jpg?imageMogr2/quality/95/thumbnail/!700x233r/gravity/Center/crop/700x233";
    String imgUrl2 = "https://cdn.sspai.com/article/986aecaf-c5e1-5eef-bf1b-004f8a2bbf38.jpg?imageMogr2/quality/95/thumbnail/!700x233r/gravity/Center/crop/700x233";
    String imgUrl3 = "https://cdn.sspai.com/article/759989f9-e744-50e3-2585-23ad1c5f4e76.jpg?imageMogr2/quality/95/thumbnail/!700x233r/gravity/Center/crop/700x233";
    String imgUrl4 = "https://cdn.sspai.com/article/c5e1d152-0389-f3a4-3c1d-c19048152832.jpg?imageMogr2/quality/95/thumbnail/!700x233r/gravity/Center/crop/700x233";
    String imgUrl5 = "https://cdn.sspai.com/article/305c4951-902f-f30d-f2a9-16e34434c9d7.jpg?imageMogr2/quality/95/thumbnail/!700x233r/gravity/Center/crop/700x233";


    public NewsAdapter(int layoutResId, @Nullable ArrayList<NewsEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsEntity item) {

//        helper.addOnClickListener(R.id.linearLayout);


        holder.setText(R.id.tv_news_title,item.getTitle());
        holder.setText(R.id.tv_news_context,item.getContext());

        ((SparkButton) holder.getView(R.id.heart_button)).setChecked(item.getIslike());

        ((SparkButton) holder.getView(R.id.heart_button)).setEventListener(new SparkEventListener() {
            @Override
            public void onEvent(ImageView button, boolean buttonState) {

                item.setIslike(buttonState);

            }

            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {

            }

            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {

            }
        });

        Random random = new Random();//默认构造方法
        int u = random.nextInt(6);
        String imgUrl = null;

        switch (u) {
            case 0:
                imgUrl = imgUrl0;
                break;
            case 1:
                imgUrl = imgUrl1;
                break;
            case 2:
                imgUrl = imgUrl2;
                break;
            case 3:
                imgUrl = imgUrl3;
                break;
            case 4:
                imgUrl = imgUrl4;
                break;
            case 5:
                imgUrl = imgUrl5;
                break;
            default:
                imgUrl = imgUrl0;
                break;
        }


        GlideUtils.getInstance().LoadContextBitmap(mContext, imgUrl, (ImageView) holder.getView(R.id.iv_news_imge), R.drawable.image_placeholder, R.drawable.image_error, null);
    }
}
