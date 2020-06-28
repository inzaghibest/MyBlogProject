package com.zhangxp.blog.VO;


/**
 * Created by Administrator on 2020/6/28 0028.
 */
public class CategoryVo {
    private Integer id;
    private String name;
    /**
     * 类型：0文章，1阅读
     */
    private String type;
    /**
     * 级别
     */
    private Integer rank;
    private String parentName;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getRank() {
        return rank;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
    }
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
