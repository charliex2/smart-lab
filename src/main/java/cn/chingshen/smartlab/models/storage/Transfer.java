package cn.chingshen.smartlab.models.storage;

import cn.chingshen.smartlab.enums.TransferTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Transfer {
    private Integer id;
    private TransferTypeEnum type;
    private Date transferredAt;
    private Integer transferSheetId;
    private Integer sampleId;
    private Date createdAt;
    private Date updatedAt;
}
