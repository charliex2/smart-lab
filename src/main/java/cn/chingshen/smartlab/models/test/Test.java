package cn.chingshen.smartlab.models.test;

import lombok.Data;

import java.util.Date;

/**
 * 一次检测
 */
@Data
public class Test {
    private Integer id;
    private String name;
    private Integer itemId;
    private Integer panelId;
    private Float value;
    private Boolean visible; // 是否对外汇报
    private Date createdAt;
    private Date updatedAt;
}
