package com.huawei.ibooking.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 房间表
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@Data
@NoArgsConstructor
@TableName("room")
public class Room {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房间ID
     */
    private String room_id;

    /**
     * 房间名称
     */
    private String room_name;

    /**
     * 所属楼宇ID
     */
    private String building_id;

    /**
     * 座位数量
     */
    private Integer seat_amount;

    /**
     * 开放时间（单位：分钟）
     */
    private Integer open_time;

    /**
     * 关闭时间（单位：分钟）
     */
    private Integer close_time;

    /**
     * 是否允许过夜
     */
    private Boolean overnight;

    /**
     * 最大预订时长（单位：分钟）
     */
    private Integer max_booking_time;

    /**
     * 房间是否开放
     */
    private Boolean open;

    // 省略getter和setter方法
}