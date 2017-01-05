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

import android.content.Context;
import android.support.annotation.NonNull;
import com.fernandocejas.android10.sample.data.cache.TaskCache;
import com.fernandocejas.android10.sample.data.entity.mapper.UserEntityJsonMapper;
import com.fernandocejas.android10.sample.data.net.RestApi;
import com.fernandocejas.android10.sample.data.net.RestApiImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class TaskDataStoreFactory {

    private final Context context;
    private final TaskCache taskCache;

    @Inject
    public TaskDataStoreFactory(@NonNull Context context, @NonNull TaskCache taskCache) {
        this.context = context.getApplicationContext();
        this.taskCache = taskCache;
    }

    /**
     * Create {@link UserDataStore} from a user id.
     */
    public TaskDataStore create() {
        return new DiskTaskDataStore(this.taskCache);
    }
}
