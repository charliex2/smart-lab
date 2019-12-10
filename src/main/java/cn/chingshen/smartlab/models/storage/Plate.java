package cn.chingshen.smartlab.models.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 样本盘
 */
public class Plate {

    @Getter
    private Integer id;

    @Getter
    @Setter
    private Integer column; // 列数

    @Getter
    @Setter
    private Integer row; // 行数

    @Getter
    @Setter
    private Integer protocolId; // 方法

    @Getter
    private Date createdAt;

    @Getter
    private Date updatedAt;
}
