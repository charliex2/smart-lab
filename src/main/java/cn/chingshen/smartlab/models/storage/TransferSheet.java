package cn.chingshen.smartlab.models.storage;

import cn.chingshen.smartlab.enums.TransferTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class TransferSheet {
    private Integer id;
    private String name;
    private String code;
    private TransferTypeEnum type;
    private Date transferredAt;
    private Date createdAt;
    private Date updatedAt;
}
