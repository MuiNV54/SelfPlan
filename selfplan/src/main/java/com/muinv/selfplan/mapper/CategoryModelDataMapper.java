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
import com.fernandocejas.android10.sample.domain.Category;
import com.fernandocejas.android10.sample.domain.User;
import com.muinv.selfplan.model.CategoryModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 */
public class CategoryModelDataMapper {

    @Inject
    public CategoryModelDataMapper() {
    }

    /**
     * Transform a {@link UserEntity} into an {@link User}.
     *
     * @param category Object to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public CategoryModel transform(Category category) {
        CategoryModel categoryModel = null;
        if (category != null) {
            category = new Category(category.getId());
            category.setContent(category.getContent());
            category.setColor(category.getColor());
            category.setIcon(category.getIcon());
            category.setUnit(category.getUnit());
        }

        return categoryModel;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param categories Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<CategoryModel> transform(Collection<Category> categories) {
        List<CategoryModel> categoriyModels = new ArrayList<>();
        CategoryModel categoryModel;
        for (Category category : categories) {
            categoryModel = transform(category);
            if (categoryModel != null) {
                categoriyModels.add(categoryModel);
            }
        }

        return categoriyModels;
    }
}
