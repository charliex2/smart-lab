package cn.chingshen.smartlab.models.test;

import lombok.Data;

import java.util.Date;

@Data
public class Protocol {
    private Integer id;
    private String name;
    private Integer timeLimit; // 时间限制
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
