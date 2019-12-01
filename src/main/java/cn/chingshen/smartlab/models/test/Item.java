package cn.chingshen.smartlab.models.test;

import cn.chingshen.smartlab.enums.ValueTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * 检测项目
 */
@Data
public class Item {
    private Integer id;
    private String name;
    private String description;
    private ValueTypeEnum type;
    private String unit;
    private String properties;
    private Integer protocolId;
    private Integer panelId;
    private Date createdAt;
    private Date updatedAt;
}
