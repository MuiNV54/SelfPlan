/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.muinv.selfplan.mapper;

import com.fernandocejas.android10.sample.data.entity.UserEntity;
import com.fernandocejas.android10.sample.domain.Task;
import com.fernandocejas.android10.sample.domain.User;
import com.muinv.selfplan.di.PerActivity;
import com.muinv.selfplan.model.TaskModel;
import com.muinv.selfplan.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/**
 * Mapper class used to transform {@link User} (in the domain layer) to {@link UserModel} in the
 * presentation layer.
 */
@PerActivity
public class TaskModelDataMapper {

    private CategoryModelDataMapper entityDataMapper;

    @Inject
    public TaskModelDataMapper(CategoryModelDataMapper categoryEntityDataMapper) {
        this.entityDataMapper = categoryEntityDataMapper;
    }

    /**
     * Transform a {@link UserEntity} into an {@link User}.
     *
     * @param task Object to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public TaskModel transform(Task task) {
        TaskModel taskModel = null;
        if (task != null) {
            taskModel = new TaskModel(task.getId());
            taskModel.setAmount(task.getAmount());
            taskModel.setCategoryModel(entityDataMapper.transform(task.getCategory()));
            taskModel.setDescrease(task.isDescrease());
            taskModel.setDescription(task.getDescription());
        }

        return taskModel;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param taskCollection Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<TaskModel> transform(Collection<Task> taskCollection) {
        List<TaskModel> taskModels = new ArrayList<>();
        TaskModel taskModel;
        for (Task task : taskCollection) {
            taskModel = transform(task);
            if (task != null) {
                taskModels.add(taskModel);
            }
        }

        return taskModels;
    }
}
