package com.huawei.ibooking.service;


import com.huawei.ibooking.model.Seat;
import com.huawei.ibooking.model.dto.SeatReq;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 座位表Service接口
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
public interface SeatService {
    //查看当前座位
    Seat getSeatBySeatId(String seatId, String roomId);
    // 更新座位today订阅信息
    int updateTodayBook(String seatId, String roomId, String todayBook);
    // 更新座位next订阅信息
    int updateNextBook(String seatId, String roomId, String nextBook);
    // 根据条件进行搜索座位，获取选定时段的空余座位
    List<Seat> getSeatList(SeatReq seatReq);
}
