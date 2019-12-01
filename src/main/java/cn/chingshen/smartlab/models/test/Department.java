package cn.chingshen.smartlab.models.test;

import lombok.Data;

import java.util.Date;

/**
 * 科室
 */
@Data
public class Department {
    private Integer id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
