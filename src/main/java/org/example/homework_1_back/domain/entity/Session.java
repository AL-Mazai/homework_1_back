package org.example.homework_1_back.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Session implements Serializable {
    private Integer id;
    /**
     * 聊天内容
     */
    private Integer chatRecordId;
    /**
     * 聊天创建时间
     */
    private Date createdTime;
    /**
     * 删除标记（0表示已删除，1表示正常）
     */
    private Integer delTag;
    /**
     * 聊天所属用户
     */
    private Integer userId;
}
