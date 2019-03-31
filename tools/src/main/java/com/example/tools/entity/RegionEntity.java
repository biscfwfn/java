package com.example.tools.entity;

/**
 * 行政区实体类
 */
public class RegionEntity {
    /**
     * 编码
     */
    private String code;
    /**
     * 名字
     */
    private String name;
    /**
     * 级别
     */
    private String level;
    /**
     * 父级编码
     */
    private String parentCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
