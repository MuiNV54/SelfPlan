package com.muinv.selfplan.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
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
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    ViewPagerAdapter viewPagerAdapter;

    private UserComponent userComponent;
    private int navItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_plan);
        ButterKnife.bind(this);
        this.initializeInjector();
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setUpNavigationView();
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

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }

    private void setUpNavigationView() {
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        //Check to see which item was being clicked and perform appropriate action
                        switch (menuItem.getItemId()) {
                            //Replacing the main content with ContentFragment Which is our Inbox View;
                            case R.id.nav_home:
                                navItemIndex = 0;
                                drawer.closeDrawers();
                                break;
                            case R.id.nav_category:
                                navItemIndex = 1;
                                drawer.closeDrawers();
                                break;
                            default:
                                drawer.closeDrawers();
                                navItemIndex = 0;
                        }
                        setNavItemCheck(navItemIndex);
                        return true;
                    }
                });

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name,
                        R.string.app_name) {

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }
                };

        //Setting the actionbarToggle to drawer layout
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setNavItemCheck(int itemIndex) {
        navigationView.getMenu().getItem(0).setChecked(false);
        navigationView.getMenu().getItem(1).setChecked(false);
        navigationView.getMenu().getItem(itemIndex).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        super.onBackPressed();
    }
}
