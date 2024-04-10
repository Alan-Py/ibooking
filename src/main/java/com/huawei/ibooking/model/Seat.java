package com.huawei.ibooking.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 座位表
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@Data
@NoArgsConstructor
@TableName("seat")
public class Seat {
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
     * 是否配备电源插座
     */
    private Boolean socket;

    /**
     * 座位是否正在使用
     */
    private Boolean open;
    /**
     * 今天座位是否被占用
     */
    private String todayBook;
    /**
     * 明天座位是否被占用
     */
    private String nextBook;

}