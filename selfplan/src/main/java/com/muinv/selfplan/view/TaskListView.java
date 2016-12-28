package com.muinv.selfplan.view;

import com.muinv.selfplan.model.TaskModel;
import com.muinv.selfplan.model.UserModel;
import java.util.Collection;

/**
 * Created by FRAMGIA\nguyen.van.mui on 28/12/2016.
 */

public interface TaskListView extends LoadDataView {
    /**
     * Render a user list in the UI.
     *
     * @param taskModelCollection The collection of {@link TaskModel} that will be shown.
     */
    void renderTaskList(Collection<TaskModel> taskModelCollection);
}
