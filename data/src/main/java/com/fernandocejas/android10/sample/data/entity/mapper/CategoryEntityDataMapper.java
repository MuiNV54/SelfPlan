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

import com.fernandocejas.android10.sample.data.entity.CategoryEntity;
import com.fernandocejas.android10.sample.data.entity.UserEntity;
import com.fernandocejas.android10.sample.domain.Category;
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
public class CategoryEntityDataMapper {

    @Inject
    public CategoryEntityDataMapper() {
    }

    /**
     * Transform a {@link UserEntity} into an {@link User}.
     *
     * @param categoryEntity Object to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public Category transform(CategoryEntity categoryEntity) {
        Category category = null;
        if (categoryEntity != null) {
            category = new Category(categoryEntity.getId());
            category.setContent(categoryEntity.content);
            category.setColor(categoryEntity.color);
            category.setIcon(categoryEntity.icon);
            category.setUnit(categoryEntity.unit);
        }

        return category;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param categoryEntities Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<Category> transform(Collection<CategoryEntity> categoryEntities) {
        List<Category> categories = new ArrayList<>();
        Category category;
        for (CategoryEntity categoryEntity : categoryEntities) {
            category = transform(categoryEntity);
            if (category != null) {
                categories.add(category);
            }
        }

        return categories;
    }
}
