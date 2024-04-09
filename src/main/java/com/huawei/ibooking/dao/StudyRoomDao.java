package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.StudyRoomMapper;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudyRoomDao {
    @Autowired
    private StudyRoomMapper studyRoomMapper;
    public List<StudyRoomDO> getStudyRooms() {
        return studyRoomMapper.getStudyRooms();
    }

}
