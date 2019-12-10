package cn.chingshen.smartlab.models.test;

import cn.chingshen.smartlab.enums.RunStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 一个批次
 */
public class Batch {
    @Getter
    private Integer id;

    @Getter
    private String code;

    /**
     * Batch 流水号编号方式
     * 两位Protocol码 + YYYYMMDD + 两位序号
     *
     * @param prefix
     * @return
     */
    public String setCode(String prefix) {
        // TODO 需要实现生成 Batch 流水号的函数
        return "";
    }

    private RunStatus status;

    @Getter
    @Setter
    private Date completedAt;

    @Getter
    private Date createdAt;

    @Getter
    private Date updatedAt;
}
