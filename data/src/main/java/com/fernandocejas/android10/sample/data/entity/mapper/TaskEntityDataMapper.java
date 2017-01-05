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
package com.fernandocejas.android10.sample.data.entity.mapper;

import com.fernandocejas.android10.sample.data.entity.TaskEntity;
import com.fernandocejas.android10.sample.data.entity.UserEntity;
import com.fernandocejas.android10.sample.domain.Task;
import com.fernandocejas.android10.sample.domain.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 */
@Singleton
public class TaskEntityDataMapper {
    private CategoryEntityDataMapper entityDataMapper;

    @Inject
    public TaskEntityDataMapper(CategoryEntityDataMapper categoryEntityDataMapper) {
        this.entityDataMapper = categoryEntityDataMapper;
    }

    /**
     * Transform a {@link UserEntity} into an {@link User}.
     *
     * @param taskEntity Object to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public Task transform(TaskEntity taskEntity) {
        Task task = null;
        if (taskEntity != null) {
            task = new Task(taskEntity.getId());
            task.setAmount(taskEntity.amount);
            task.setCategory(entityDataMapper.transform(taskEntity.category));
            task.setDescrease(taskEntity.descrease);
            task.setDescription(taskEntity.description);
        }

        return task;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param taskEntityCollection Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<Task> transform(Collection<TaskEntity> taskEntityCollection) {
        List<Task> taskList = new ArrayList<>();
        Task task;
        for (TaskEntity taskEntity : taskEntityCollection) {
            task = transform(taskEntity);
            if (task != null) {
                taskList.add(task);
            }
        }

        return taskList;
    }
}
