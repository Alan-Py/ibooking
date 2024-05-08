package com.huawei.ibooking.model.dto;

import lombok.Data;

@Data
public class addRoomReq {

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

    public addRoomReq(String roomId, String roomName,String buildingId,
                      Integer seatAmount,Integer openTime ,Integer closeTime,
                      Boolean overnight,Integer maxBookingTime,Boolean open) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.buildingId = buildingId;
        this.seatAmount = seatAmount;
        this.openTime = openTime != null ? openTime : 7; // 默认开放时间为8点
        this.closeTime = closeTime != null ? closeTime : 22; // 默认关闭时间为18点
        this.overnight = overnight != null ? overnight : false; // 默认通宵状态由传入值决定
        this.maxBookingTime = maxBookingTime != null ? maxBookingTime : 4; // 默认最大预定时间为4h
        this.open = open != null ? open : true; // 默认开放状态由传入值决定
    }
}
