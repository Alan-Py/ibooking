package com.huawei.ibooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.ibooking.model.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 教室表Mapper接口
 * </p>
 *
 * @author Panyue
 * @since 2024-04-09
 */
@Mapper
public interface RoomMapper extends BaseMapper<Room> {
    @Select("select * from room where room_id = #{roomId}")
    Room getRoomByRoomId(String roomId);
    @Delete("delete from room where room_id = #{roomId}")
    int deleteRoomByRoomId(String roomId);
}
