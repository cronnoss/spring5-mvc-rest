package com.cronnoss.api.v1.mapper;

import com.cronnoss.api.v1.model.CategoryDTO;
import com.cronnoss.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryMapperTest {

    public static final String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {

        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        Assertions.assertEquals(Long.valueOf(1L), categoryDTO.getId());
        Assertions.assertEquals("Joe", category.getName());
    }
}