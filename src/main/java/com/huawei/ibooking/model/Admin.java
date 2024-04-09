package com.huawei.ibooking.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author MoonshotAI
 * @since 2024-04-09
 */
@Data
@TableName("admin")
public class Admin implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 管理员ID
     */
    private String adminId;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 管理员密码
     */
    private String password;
}