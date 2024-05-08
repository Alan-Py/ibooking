package com.huawei.ibooking.model.dto;

import lombok.Data;

@Data
public class SeatReq {
    private String seatId;
    private String roomId;
    private Boolean socket;
    private Integer startTime;
    private Integer endTime;
    private Boolean isToday;
    private Boolean isEmpty;
    public SeatReq(String seatId,String roomId,Boolean socket,Integer startTime,Integer endTime,Boolean isToday,Boolean isEmpty) {
        this.isToday = isToday != null ? isToday : true;//默认查询今天的座位
        this.isEmpty = isEmpty != null ? isEmpty : false;//默认不查询空余座位，查询所有座位
        this.startTime = startTime != null ? startTime : 7;//默认查询从7点开始
        this.endTime = endTime != null ? endTime : 22;//默认查询到22点结束
    }
}
