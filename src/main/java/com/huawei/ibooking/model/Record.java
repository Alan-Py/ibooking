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
    private String seatId;

    /**
     * 房间ID
     */
    private String roomId;

    /**
     * 学生ID
     */
    private String stuId;

    /**
     * 预订开始时间（单位：小时）
     */
    private Integer startTime;

    /**
     * 预订结束时间（单位：小时）
     */
    private Integer endTime;

    /**
     * 预订日期
     */
    private Date bookingDate;

    /**
     * 预订状态
     */
    private Integer status;

    public Record(String seatId, String roomId, String stuId, Integer startTime, Integer endTime, String bookingDate, Integer status) {
        this.seatId = seatId;
        this.roomId = roomId;
        this.stuId = stuId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingDate = new Date();
        this.status = status;
    }
}