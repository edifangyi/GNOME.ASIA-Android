package com.gnomeasia.adapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.gnomeasia.R;
import com.gnomeasia.base.BaseHeaderAdapter;
import com.gnomeasia.bean.EventBean;
import com.gnomeasia.entity.PinnedHeaderEntity;

import java.util.List;

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
public class EventAdapter extends BaseHeaderAdapter<PinnedHeaderEntity<EventBean.ListRoom.ListSpeark>, BaseViewHolder> {


    public EventAdapter(List<PinnedHeaderEntity<EventBean.ListRoom.ListSpeark>> data) {
        super(data);

    }

    @Override
    protected void addItemTypes() {
        addItemType(BaseHeaderAdapter.TYPE_HEADER, R.layout.item_pinned_header);
        addItemType(BaseHeaderAdapter.TYPE_DATA, R.layout.item_event);
    }

    @Override
    protected void convert(BaseViewHolder holder, PinnedHeaderEntity<EventBean.ListRoom.ListSpeark> item) {
        switch (holder.getItemViewType()) {
            case BaseHeaderAdapter.TYPE_HEADER:
                holder.setText(R.id.tv_animal, item.getPinnedHeaderName());
                break;
            case BaseHeaderAdapter.TYPE_DATA:
                holder.setText(R.id.tv_event_title, item.getData().getTitile());
                holder.setText(R.id.tv_event_speark, item.getData().getSpeark());
                holder.setText(R.id.tv_event_startime, item.getData().getStartime());
                holder.setText(R.id.tv_event_endtime, item.getData().getEndtime());

        }

    }
}
