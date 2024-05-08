package com.huawei.ibooking.model.dto;

import lombok.Data;

@Data
public class AdminReq {
    /**
     * 管理员ID
     */
    private String adminId;

    /**
     * 管理员密码
     */
    private String password;
}
