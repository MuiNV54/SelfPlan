package com.muinv.selfplan.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.muinv.selfplan.R;
import com.muinv.selfplan.di.components.UserComponent;
import com.muinv.selfplan.model.TaskModel;
import com.muinv.selfplan.presenter.TodayPresenter;
import com.muinv.selfplan.view.TaskListView;
import com.muinv.selfplan.view.adapter.TaskAdapter;
import com.muinv.selfplan.view.adapter.UsersLayoutManager;
import java.util.Collection;
import javax.inject.Inject;

/**
 * Created by FRAMGIA\nguyen.van.mui on 27/12/2016.
 */

public class TodayFragment extends BaseSupportFragment implements TaskListView {
    @Inject
    TaskAdapter taskAdapter;

    @Inject
    TodayPresenter todayPresenter;

    @Bind(R.id.lv_task)
    RecyclerView lvTask;

    public TodayFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(UserComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_today, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        todayPresenter.setTaskListView(this);
        if (savedInstanceState == null) {
            this.loadTaskList();
        }
    }

    private void loadTaskList() {
        this.todayPresenter.initialize();
    }

    private void setupRecyclerView() {
        this.lvTask.setLayoutManager(new UsersLayoutManager(context()));
        this.lvTask.setAdapter(taskAdapter);
    }

    @Override
    public void renderTaskList(Collection<TaskModel> taskModelCollection) {
        if (taskModelCollection != null) {
            this.taskAdapter.setTaskList(taskModelCollection);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        lvTask.setAdapter(null);
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        todayPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        todayPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        todayPresenter.destroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }
}
