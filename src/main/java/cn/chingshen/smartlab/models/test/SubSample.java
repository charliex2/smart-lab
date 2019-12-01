package cn.chingshen.smartlab.models.test;

import cn.chingshen.smartlab.enums.SubSampleStatus;
import lombok.Data;

import java.util.Date;

/**
 * 分样本，要分配到多少个流水，则就需要
 */
@Data
public class SubSample {
    private Integer id;
    private Integer sampleId;
    private Integer protocolId;
    private Integer runId;
    private SubSampleStatus status;
    private Date createdAt;
    private Date testedAt;
    private Date completedAt;
    private Date updatedAt;
}
