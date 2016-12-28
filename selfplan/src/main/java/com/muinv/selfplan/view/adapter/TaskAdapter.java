package com.muinv.selfplan.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.muinv.selfplan.R;
import com.muinv.selfplan.model.TaskModel;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by FRAMGIA\nguyen.van.mui on 28/12/2016.
 */

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TaskModel> taskList;
    private final LayoutInflater layoutInflater;

    @Inject
    public TaskAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.taskList = Collections.emptyList();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_task, parent, false);
        return new TaskHolder(view);
    }

    public void setTaskList(Collection<TaskModel> taskList) {
        if (taskList == null) {
            return;
        }
        this.taskList = (List<TaskModel>) taskList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TaskHolder taskHolder = (TaskHolder) holder;
        TaskModel taskModel = taskList.get(position);
        taskHolder.content.setText(taskModel.getCategoryModel().getContent());
        taskHolder.description.setText(taskModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return taskList == null ? 0 : taskList.size();
    }

    static class TaskHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.row_task_icon)
        TextView icon;
        @Bind(R.id.row_task_content)
        TextView content;
        @Bind(R.id.row_task_description)
        TextView description;

        public TaskHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

