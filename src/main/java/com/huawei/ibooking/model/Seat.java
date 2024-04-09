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
    private String seat_id;

    /**
     * 房间ID
     */
    private String room_id;

    /**
     * 是否配备电源插座
     */
    private Boolean socket;

    /**
     * 房间是否开放
     */
    private Boolean open;
}