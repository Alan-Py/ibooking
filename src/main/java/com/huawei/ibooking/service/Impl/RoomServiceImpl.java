package com.huawei.ibooking.service.Impl;

import com.huawei.ibooking.mapper.RoomMapper;
import com.huawei.ibooking.model.Room;
import com.huawei.ibooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomMapper roomMapper;
    @Autowired
    public RoomServiceImpl(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }
    @Override
    public List<Room> getAllRooms() {
        return roomMapper.selectList(null);
    }
    @Override
    public Room getRoomByRoomId(String roomId) {
        return roomMapper.getRoomByRoomId(roomId);
    }

    @Override
    public boolean addRoom(Room room) {
        return roomMapper.insert(room) > 0;
    }

    @Override
    public boolean updateRoom(Room room) {
        return roomMapper.updateById(room) > 0;
    }

    @Override
    public boolean deleteRoomByRoomId(String roomId) {
        return roomMapper.deleteRoomByRoomId(roomId) > 0;
    }
}
