package com.huawei.ibooking.service;

import java.util.List;
import com.huawei.ibooking.model.Room;
import com.huawei.ibooking.model.Student;

/**
 * <p>
 * 教室表Service接口
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
public interface RoomService {
    //获得所有的教室的信息列表
    List<Room> getAllRooms();
    //通过id获得单个教室信息
    Room getRoomByRoomId(String roomId);
    // 添加教室信息
    boolean addRoom(Room room);
    // 更新教室信息
    boolean updateRoom(Room room);
    // 删除教室信息
    boolean deleteRoomByRoomId(String stuId);

}
