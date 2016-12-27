package com.muinv.selfplan.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.muinv.selfplan.R;
import com.muinv.selfplan.di.HasComponent;
import com.muinv.selfplan.di.components.DaggerUserComponent;
import com.muinv.selfplan.di.components.UserComponent;
import com.muinv.selfplan.view.adapter.ViewPagerAdapter;
import com.muinv.selfplan.view.fragment.CalendarFragment;
import com.muinv.selfplan.view.fragment.ChartFragment;
import com.muinv.selfplan.view.fragment.TodayFragment;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

public class SelfPlanActivity extends BaseActivity implements HasComponent<UserComponent> {
    @Bind(R.id.self_plan_toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;

    private UserComponent userComponent;

    private int[] tabIcons = {
            R.drawable.ic_new, R.drawable.ic_calendar, R.drawable.ic_chart
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_plan);
        ButterKnife.bind(this);
        this.initializeInjector();
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new TodayFragment(), "TODAY");
        viewPagerAdapter.addFragment(new CalendarFragment(), "CALENDAR");
        viewPagerAdapter.addFragment(new ChartFragment(), "ANALYTIC");
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }
}
