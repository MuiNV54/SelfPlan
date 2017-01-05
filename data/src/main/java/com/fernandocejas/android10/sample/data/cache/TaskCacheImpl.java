package com.fernandocejas.android10.sample.data.cache;

import android.content.Context;
import com.activeandroid.query.Select;
import com.fernandocejas.android10.sample.data.entity.TaskEntity;
import com.fernandocejas.android10.sample.domain.executor.ThreadExecutor;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by FRAMGIA\nguyen.van.mui on 30/12/2016.
 */

public class TaskCacheImpl implements TaskCache {
    private static final String SETTINGS_FILE_NAME = "com.fernandocejas.android10.SETTINGS";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

    private static final String DEFAULT_FILE_NAME = "task_";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

    private final Context context;
    private final ThreadExecutor threadExecutor;

    /**
     * Constructor of the class {@link UserCacheImpl}.
     *
     * @param context A
     */
    @Inject
    public TaskCacheImpl(Context context, ThreadExecutor threadExecutor) {
        this.context = context;
        this.threadExecutor = threadExecutor;
    }

    @Override
    public Observable<TaskEntity> get(long taskId) {
        return Observable.create(subscriber -> {
            TaskEntity taskEntity =
                    new Select().from(TaskEntity.class).where(taskId + "").executeSingle();
            if (taskEntity != null) {
                subscriber.onNext(taskEntity);
                subscriber.onCompleted();
            } else {
                subscriber.onError(new Throwable());
            }
        });
    }

    @Override
    public Observable<List<TaskEntity>> get() {
        return Observable.create(subscriber -> {
            List<TaskEntity> taskEntities = new Select().from(TaskEntity.class).execute();
            if (taskEntities != null) {
                subscriber.onNext(taskEntities);
                subscriber.onCompleted();
            } else {
                subscriber.onError(new Throwable());
            }
        });
    }

    @Override
    public void put(TaskEntity taskEntity) {
        if (!isCached(taskEntity.getId())) {
            this.executeAsynchronously(new Runnable() {
                @Override
                public void run() {
                    taskEntity.save();
                }
            });
        }
    }

    @Override
    public boolean isCached(long taskId) {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void evictAll() {

    }

    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }
}
