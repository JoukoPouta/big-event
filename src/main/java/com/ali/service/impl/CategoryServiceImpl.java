package com.ali.service.impl;

import com.ali.mapper.CategoryMapper;
import com.ali.pojo.Category;
import com.ali.service.CategoryService;
import com.ali.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        //补充属性
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId =( Integer) map.get("id");
        category.setCreateUser(userId);
        categoryMapper.add(category);
    }
}
