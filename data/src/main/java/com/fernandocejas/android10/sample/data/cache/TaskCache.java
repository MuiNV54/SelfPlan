package com.fernandocejas.android10.sample.data.cache;

import com.fernandocejas.android10.sample.data.entity.TaskEntity;
import com.fernandocejas.android10.sample.data.entity.UserEntity;
import java.util.List;
import rx.Observable;

/**
 * Created by FRAMGIA\nguyen.van.mui on 30/12/2016.
 */

public interface TaskCache {
    /**
     * Gets an {@link rx.Observable} which will emit a {@link UserEntity}.
     *
     * @param taskId The user id to retrieve data.
     */
    Observable<TaskEntity> get(final long taskId);

    Observable<List<TaskEntity>> get();

    /**
     * Puts and element into the cache.
     *
     * @param taskEntity Element to insert in the cache.
     */
    void put(TaskEntity taskEntity);

    /**
     * Checks if an element (User) exists in the cache.
     *
     * @param taskId The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final long taskId);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
