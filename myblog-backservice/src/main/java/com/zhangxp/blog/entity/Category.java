package com.zhangxp.blog.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Table(name = "category")
public class Category {
    /**
     * 主键
     */
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型：0文章，1阅读
     */
    private Integer type;

    /**
     * 级别
     */
    private Integer rank;

    /**
     * 父主键
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型：0文章，1阅读
     *
     * @return type - 类型：0文章，1阅读
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：0文章，1阅读
     *
     * @param type 类型：0文章，1阅读
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取级别
     *
     * @return rank - 级别
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置级别
     *
     * @param rank 级别
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 获取父主键
     *
     * @return parent_id - 父主键
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父主键
     *
     * @param parentId 父主键
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}