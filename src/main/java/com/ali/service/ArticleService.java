package com.ali.service;

import com.ali.pojo.Article;
import com.ali.pojo.PageBean;

public interface ArticleService {
    //添加
    void add(Article article);
    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article findById(Integer id);

    void deleteById(Integer id);

    void update(Article article);
}
