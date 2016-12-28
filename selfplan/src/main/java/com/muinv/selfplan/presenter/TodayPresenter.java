package com.muinv.selfplan.presenter;

import com.muinv.selfplan.model.CategoryModel;
import com.muinv.selfplan.model.TaskModel;
import com.muinv.selfplan.view.TaskListView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by FRAMGIA\nguyen.van.mui on 28/12/2016.
 */

public class TodayPresenter implements Presenter {
    private TaskListView taskListView;

    @Inject
    public TodayPresenter() {
    }

    public void setTaskListView(TaskListView taskListView) {
        this.taskListView = taskListView;
    }

    public void initialize() {
        this.loadTaskList();
    }

    private void loadTaskList() {
        this.getTaskList();
    }

    private void getTaskList() {
        List<TaskModel> taskModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TaskModel taskModel = new TaskModel();
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setContent("hello, every one!");
            taskModel.setCategoryModel(categoryModel);
            taskModel.setDescription("this is first test of my app!");
            taskModels.add(taskModel);
        }
        this.taskListView.renderTaskList(taskModels);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.taskListView = null;
    }
}