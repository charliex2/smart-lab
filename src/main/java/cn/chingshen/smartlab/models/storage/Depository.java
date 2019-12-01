package cn.chingshen.smartlab.models.storage;

import lombok.Data;

import java.util.Date;

/**
 * 仓库
 */
@Data
public class Depository {

    private Integer id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
