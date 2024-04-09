package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.StudyRoomDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudyRoomMapper {
    //获取所有的自习室列表
    List<StudyRoomDO> getStudyRooms();
}
