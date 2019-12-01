package cn.chingshen.smartlab.models.test;

import cn.chingshen.smartlab.enums.RunStatus;
import lombok.Data;

import java.util.Date;

/**
 * 一次跑样
 */
@Data
public class Run {
    private Integer id;
    private String code;
    private RunStatus status;
    private Date completedAt;
    private Date createdAt;
    private Date updatedAt;
}
