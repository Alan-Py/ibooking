package com.huawei.ibooking.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * <p>
 * 预订记录表
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@Data
@NoArgsConstructor
@TableName("record")
public class Record {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 座位ID
     */
    private String seat_id;

    /**
     * 房间ID
     */
    private String room_id;

    /**
     * 学生ID
     */
    private String stu_id;

    /**
     * 预订开始时间（单位：分钟）
     */
    private Integer start_time;

    /**
     * 预订结束时间（单位：分钟）
     */
    private Integer end_time;

    /**
     * 预订日期
     */
    private Date booking_date;

    /**
     * 预订状态
     */
    private Integer status;
}