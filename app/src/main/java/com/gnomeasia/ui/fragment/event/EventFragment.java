package com.gnomeasia.ui.fragment.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gnomeasia.R;
import com.gnomeasia.base.BaseMainFragment;
import com.gnomeasia.ui.fragment.event.child.EventHomeFragment;

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
public class EventFragment extends BaseMainFragment {

    public static EventFragment newInstance() {

        Bundle args = new Bundle();
        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_event, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(EventHomeFragment.class) == null) {
            loadRootFragment(R.id.fl_event_container, EventHomeFragment.newInstance());
        }
    }
}
