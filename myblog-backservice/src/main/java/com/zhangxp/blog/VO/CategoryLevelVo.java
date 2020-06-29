package com.zhangxp.blog.VO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxp on 2020/6/29.
 * 按层级分类
 * {value, label, chidren: {value, label, chidren...}}
 */
public class CategoryLevelVo {
    private String name;
    private String label;
    private ArrayList<CategoryLevelVo> childrenLevelVoList;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public List<CategoryLevelVo> getChildern() {
        return this.childrenLevelVoList;
    }
    public void setChildren(ArrayList<CategoryLevelVo>  categoryLevelVoList) {
        this.childrenLevelVoList = categoryLevelVoList;
    }
}
