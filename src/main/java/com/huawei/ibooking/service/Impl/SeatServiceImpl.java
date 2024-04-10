package com.huawei.ibooking.service.Impl;

import com.huawei.ibooking.mapper.SeatMapper;
import com.huawei.ibooking.model.Seat;
import com.huawei.ibooking.model.dto.SeatReq;
import com.huawei.ibooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Override
    public Seat getSeatBySeatId(String seatId, String roomId) {
        return seatMapper.getSeatBySeatId(seatId, roomId);
    }

    @Override
    public int updateTodayBook(String seatId, String roomId, String todayBook) {
        Seat seat = seatMapper.getSeatBySeatId(seatId, roomId);
        if(seat == null){
            return 0;
        }else{
            seat.setTodayBook(todayBook);
            return seatMapper.updateById(seat);
        }
    }

    @Override
    public int updateNextBook(String seatId, String roomId, String nextBook) {
        Seat seat = seatMapper.getSeatBySeatId(seatId, roomId);
        if(seat == null){
            return 0;
        }else{
            seat.setNextBook(nextBook);
            return seatMapper.updateById(seat);
        }
    }

    @Override
    //多条件模糊查询
    public List<Seat> getSeatList(SeatReq seatReq) {
        List<Seat> seatList = seatMapper.findSeatsByReq(seatReq.getRoomId(), seatReq.getSeatId(), seatReq.getSocket());
        //需要查询空座位
        if(seatReq.getIsEmpty()){
            //根据时间段和string todayBook和nextBook来筛选出空余座位
            for(Seat seat:seatList){
                if(seatReq.getIsToday()){
                    if(seat.getTodayBook().substring(seatReq.getStartTime(),seatReq.getEndTime()).contains("1")){
                        seatList.remove(seat);
                    }
                }else{
                    if(seat.getNextBook().substring(seatReq.getStartTime(),seatReq.getEndTime()).contains("1")){
                        seatList.remove(seat);
                    }
                }
            }
        }
        return seatList;
    }
}
