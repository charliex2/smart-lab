package cn.chingshen.smartlab.models.test;

import lombok.Data;

import java.util.Date;

/**
 * 组套
 */
@Data
public class Panel {
    private Integer id;
    private String name;
    private String description;
    private Integer goodId;
    private Date createdAt;
    private Date updatedAt;
}
