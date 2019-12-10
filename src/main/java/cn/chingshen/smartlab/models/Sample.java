package cn.chingshen.smartlab.models;

import cn.chingshen.smartlab.enums.GenderEnum;
import cn.chingshen.smartlab.enums.SampleStatus;
import cn.chingshen.smartlab.enums.SampleStoreStatus;
import lombok.Data;

import java.util.Date;

/**
 * 样本
 */
@Data
public class Sample {
    private Integer id;
    private String barcode; // 条码号
    private String name;
    private Integer age;
    private GenderEnum gender;
    private Integer partnerId;
    private SampleStatus status; //样本状态
    private SampleStoreStatus storeStatus; // 库存状态
    private Date receivedAt; // 收样本时间
    private Date rejectedAt; // 拒收时间
    private Date testedAt; // 检测时间
    private Date completedAt; // 完成时间
    private Date confirmedAt; // 确认时间

    // 库存相关的属性
    private Integer plateId; // 盘子的 id；
    private Integer index; // 序号
    private Integer row; // 行
    private Integer column; // 列

    //
    private Date createdAt;
    private Date updatedAt;
}
