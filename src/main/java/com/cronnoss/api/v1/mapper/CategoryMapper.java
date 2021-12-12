package com.cronnoss.api.v1.mapper;

import com.cronnoss.api.v1.model.CategoryDTO;
import com.cronnoss.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
