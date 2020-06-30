package com.zhangxp.blog.controller;

import com.zhangxp.blog.VO.CategoryLevelVo;
import com.zhangxp.blog.VO.CategoryVo;
import com.zhangxp.blog.common.Result;
import com.zhangxp.blog.entity.Category;
import com.zhangxp.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

//    @RequestMapping(value = "/getLevelCategory")
//    public Result getLevelCategory() {
//        ArrayList<Category> categoryArrayList = categoryService.getAllCategory();
//        System.out.print("----------------------" + categoryArrayList.size() + "------------");
//        for (int first = 0; first < categoryArrayList.size(); first++)
//        {
//            CategoryLevelVo categoryLevelVo = new CategoryLevelVo();
//            Category item = categoryArrayList.get(first);
//            if (item.getRank() == 1) // 最低级菜单
//            {
//                categoryLevelVo.setName(item.getName());
//                categoryLevelVo.setLabel(item.getName());
//                int id = item.getId();
//                // 寻找子级菜单
//                ArrayList<CategoryLevelVo> categoryLevelVoList = new ArrayList<CategoryLevelVo>();
//                for (int second = 0; second < categoryArrayList.size(); second++)
//                {
//                    Category chidrenItem = categoryArrayList.get(second);
//                    if (first == second) // 同一个不管
//                    {
//                        continue;
//                    }else if (id == chidrenItem.getParentId() && chidrenItem.getRank() == 1){ // 是直接子级菜单
//                        CategoryLevelVo categoryLevelVo1 = new CategoryLevelVo();
//                        categoryLevelVo1.setName(chidrenItem.getName());
//                        categoryLevelVo1.setLabel(chidrenItem.getName());
//                        int childrenId = item.getId();
//
//                        for (int three = 0; three < categoryArrayList.size(); three++) // 寻找下一级菜单
//                        {
//                            Category sonItem = categoryArrayList.get(three);
//                            if (second == three) // 同一个不处理
//                            {
//                                continue;
//                            }else if (childrenId == sonItem.getId() && chidrenItem.getRank() == 2) // 孙级菜单
//                            {
//                                CategoryLevelVo categoryLevelVo2 = new CategoryLevelVo();
//                                categoryLevelVo2.setName(sonItem.getName());
//                                categoryLevelVo2.setLabel(sonItem.getName());
//                                // 孙级菜单不再有下一级菜单了。
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//    }
}
