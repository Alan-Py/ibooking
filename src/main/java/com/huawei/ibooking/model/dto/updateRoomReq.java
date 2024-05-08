package com.huawei.ibooking.model.dto;

import lombok.Data;

@Data
public class updateRoomReq {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 房间ID
     */
    private String roomId;

    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 所属楼宇ID
     */
    private String buildingId;

    /**
     * 座位数量
     */
    private Integer seatAmount;

    /**
     * 开放时间（单位：小时）
     */
    private Integer openTime;

    /**
     * 关闭时间（单位：小时）
     */
    private Integer closeTime;

    /**
     * 是否允许过夜
     */
    private Boolean overnight;

    /**
     * 最大预订时长（单位：小时）
     */
    private Integer maxBookingTime;

    /**
     * 房间是否开放
     */
    private Boolean open;
}
