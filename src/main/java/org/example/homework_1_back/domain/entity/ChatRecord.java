package org.example.homework_1_back.domain.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 聊天记录(ChatRecord)实体类
 *
 * @author makejava
 * @since 2024-06-20 21:02:37
 */
@Data
public class ChatRecord implements Serializable {
    private static final long serialVersionUID = -88078468501418793L;
    /**
     * 记录编号
     */
    private Integer id;
    /**
     * 聊天内容
     */
    private String chatContent;
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

//    聊天类别，是ai回答的还是用户提问的 一般存储的是 问题 或者 答案

    private String type;
}

