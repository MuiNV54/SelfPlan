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
package com.fernandocejas.android10.sample.data.repository.datasource;

import com.fernandocejas.android10.sample.data.cache.TaskCache;
import com.fernandocejas.android10.sample.data.cache.UserCache;
import com.fernandocejas.android10.sample.data.entity.TaskEntity;
import java.util.List;
import rx.Observable;

/**
 * {@link UserDataStore} implementation based on file system data store.
 */
class DiskTaskDataStore implements TaskDataStore {

    private final TaskCache taskCache;

    /**
     * Construct a {@link UserDataStore} based file system data store.
     *
     * @param taskCache A {@link UserCache} to cache data retrieved from the api.
     */
    DiskTaskDataStore(TaskCache taskCache) {
        this.taskCache = taskCache;
    }

    @Override
    public Observable<List<TaskEntity>> taskEntityList() {
        return this.taskCache.get();
    }

    @Override
    public Observable<TaskEntity> taskEntityDetails(final long taskId) {
        return this.taskCache.get(taskId);
    }
}
