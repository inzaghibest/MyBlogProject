package com.zhangxp.blog.service;

import com.zhangxp.blog.entity.Category;
import com.zhangxp.blog.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/28 0028.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    // 返回所有的分类列表
    public ArrayList<Category> getAllCategory() {
        List<Category> categoryList = categoryMapper.selectAll();
        ArrayList<Category> arrayList = new ArrayList<Category>();
        for (int i = 0; i<categoryList.size(); i++) {
            arrayList.add(categoryList.get(i));
        }
        return arrayList;
    }

    // 根据id删除分类,删除
}
