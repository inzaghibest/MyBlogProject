package com.zhangxp.blog.controller;

import com.zhangxp.blog.VO.CategoryVo;
import com.zhangxp.blog.common.Result;
import com.zhangxp.blog.entity.Category;
import com.zhangxp.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Administrator on 2020/6/28 0028.
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/getAllCategory")
    public Result getAllCategory() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("查询成功");
        ArrayList<Category> categoryArrayList = categoryService.getAllCategory();
        System.out.print("----------------------" + categoryArrayList.size());
        ArrayList<CategoryVo> categoryVoArrayList = new ArrayList<CategoryVo>();
        for (int i = 0; i<categoryArrayList.size(); i++)
        {
            CategoryVo categoryVo = new CategoryVo();
            Category category = categoryArrayList.get(i);
            categoryVo.setId(category.getId());
            categoryVo.setName(category.getName());
            categoryVo.setRank(category.getRank());
            categoryVo.setType(category.getType() == 0 ? "文章分类" : "读书分类");
            int parentId = category.getParentId();
            if (parentId == -1)
            {
                categoryVo.setParentName("无");
            }else {
                for (int j = 0; j< categoryArrayList.size(); j++)
                {
                    if (parentId == categoryArrayList.get(j).getId())
                    {
                        categoryVo.setParentName(categoryArrayList.get(j).getName());
                    }
                }
            }
            categoryVoArrayList.add(categoryVo);
        }
        result.setData(categoryVoArrayList);
        return result;
    }
}
