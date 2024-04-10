package com.huawei.ibooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.ibooking.model.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 座位表Mapper接口
 * </p>
 *
 * @author Panyue
 * @since 2024-04-09
 */
@Mapper
public interface SeatMapper extends BaseMapper<Seat> {
    //查看当前座位
    @Select("select * from seat where seat_id = #{seatId} and room_id = #{roomId}")
    Seat getSeatBySeatId(String seatId, String roomId);
    //查看当前教室的座位
    @Select("select * from seat where room_id = #{roomId}")
    List<Seat> getSeatListByRoomId(String roomId);
    //模糊多条件查询
    @Select("select * from seat where "
            + "(roomId = #{roomId} or #{roomId} is null) "
            + "and (seatId = #{seatId} or #{seatId} is null) "
            + "and (socket = #{socket} or #{socket} is null)")
    List<Seat> findSeatsByReq(@Param("roomId") String roomId,
                              @Param("seatId") String seatId,
                              @Param("socket") Boolean socket);


}