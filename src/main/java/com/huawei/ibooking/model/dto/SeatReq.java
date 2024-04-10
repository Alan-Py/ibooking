package com.huawei.ibooking.model.dto;

import lombok.Data;

@Data
public class SeatReq {
    private String seatId;
    private String roomId;
    private Boolean socket;
    private int startTime;
    private int endTime;
    private Boolean isToday;
    private Boolean isEmpty;
    public SeatReq() {
        this.isToday = true;
        this.isEmpty = true;
        this.startTime = 0;
        this.endTime = 23;
    }
}
