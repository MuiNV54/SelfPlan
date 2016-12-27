package com.muinv.selfplan.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.muinv.selfplan.R;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

public class TodayFragment extends BaseSupportFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_today, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }
}
