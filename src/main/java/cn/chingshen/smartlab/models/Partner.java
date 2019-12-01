package cn.chingshen.smartlab.models;

import lombok.Data;

import java.util.Date;

/**
 * 合作伙伴
 */
@Data
public class Partner {
    private Integer id;
    private String name;// 名称
    private String email;// 邮箱地址
    private String callback; // 回调 url
    private String secret;
    private Date createdAt;
    private Date updatedAt;
}
