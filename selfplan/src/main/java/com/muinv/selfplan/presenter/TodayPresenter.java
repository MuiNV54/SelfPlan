package com.muinv.selfplan.presenter;

import android.util.Log;
import com.fernandocejas.android10.sample.domain.Task;
import com.fernandocejas.android10.sample.domain.interactor.DefaultSubscriber;
import com.fernandocejas.android10.sample.domain.interactor.UseCase;
import com.muinv.selfplan.mapper.TaskModelDataMapper;
import com.muinv.selfplan.model.TaskModel;
import com.muinv.selfplan.view.TaskListView;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by FRAMGIA\nguyen.van.mui on 28/12/2016.
 */

public class TodayPresenter implements Presenter {
    private TaskListView taskListView;
    private UseCase getTaskListUserCase;
    private TaskModelDataMapper taskModelDataMapper;

    @Inject
    public TodayPresenter(@Named("taskList") UseCase getTaskListUserCase,
            TaskModelDataMapper taskModelDataMapper) {
        this.getTaskListUserCase = getTaskListUserCase;
        this.taskModelDataMapper = taskModelDataMapper;
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
        this.getTaskListUserCase.execute(new TaskListSubscriber());
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
        getTaskListUserCase.unsubscribe();
    }

    private void showUsersCollectionInView(Collection<Task> tasksCollection) {
        final Collection<TaskModel> taskModels =
                this.taskModelDataMapper.transform(tasksCollection);
        this.taskListView.renderTaskList(taskModels);
    }

    private final class TaskListSubscriber extends DefaultSubscriber<List<Task>> {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(List<Task> tasks) {
            TodayPresenter.this.showUsersCollectionInView(tasks);
        }
    }
}