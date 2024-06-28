package org.example.homework_1_back.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-04-08 19:53:53
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 645013018751703184L;

    private Integer userId;

    private String userName;

    private Integer age;

    private String address;

    private String email;

    private String phone;

    private Integer sex;

    private String password;

    private String nickName;
    private String type;
    private Integer money;
}

