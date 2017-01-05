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
package com.fernandocejas.android10.sample.data.repository;

import com.fernandocejas.android10.sample.data.entity.mapper.TaskEntityDataMapper;
import com.fernandocejas.android10.sample.data.entity.mapper.UserEntityDataMapper;
import com.fernandocejas.android10.sample.data.repository.datasource.TaskDataStore;
import com.fernandocejas.android10.sample.data.repository.datasource.TaskDataStoreFactory;
import com.fernandocejas.android10.sample.domain.Task;
import com.fernandocejas.android10.sample.domain.repository.TaskRepository;
import com.fernandocejas.android10.sample.domain.repository.UserRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
public class TaskDataRepository implements TaskRepository {

    private final TaskDataStoreFactory taskDataStoreFactory;
    private final TaskEntityDataMapper taskEntityDataMapper;

    /**
     * Constructs a {@link UserRepository}.
     *
     * @param taskDataStoreFactory A factory to construct different data source implementations.
     * @param taskEntityDataMapper {@link UserEntityDataMapper}.
     */
    @Inject
    public TaskDataRepository(TaskDataStoreFactory taskDataStoreFactory,
            TaskEntityDataMapper taskEntityDataMapper) {
        this.taskDataStoreFactory = taskDataStoreFactory;
        this.taskEntityDataMapper = taskEntityDataMapper;
    }

    @Override
    public Observable<List<Task>> tasks() {
        final TaskDataStore taskDataStore = this.taskDataStoreFactory.create();
        return taskDataStore.taskEntityList().map(this.taskEntityDataMapper::transform);
    }

    @Override
    public Observable<Task> task(long taskId) {
        final TaskDataStore taskDataStore = this.taskDataStoreFactory.create();
        return taskDataStore.taskEntityDetails(taskId).map(this.taskEntityDataMapper::transform);
    }
}
