package org.example.homework_1_back.domain.vo;

import lombok.Data;

@Data
public class UserVo {
    private static final long serialVersionUID = 645013018751703184L;

    private Integer userId;

    private String userName;

    private Integer age;

    private String address;

    private String email;

    private String phone;

    private Integer sex;

    private String nickName;
}
