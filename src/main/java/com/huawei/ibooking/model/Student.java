package com.huawei.ibooking.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@Data
@NoArgsConstructor
@TableName("student")
public class Student{
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生ID
     */
    private String stuId;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 电子邮件地址
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 学生密码
     */
    private String password;

    // 省略getter和setter方法
}