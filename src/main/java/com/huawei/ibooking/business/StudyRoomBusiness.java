package com.huawei.ibooking.business;

import com.huawei.ibooking.dao.StudyRoomDao;
import com.huawei.ibooking.model.StudyRoomDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudyRoomBusiness {
    @Autowired
    private StudyRoomDao studyRoomDao;
    public List<StudyRoomDO> getStudyRooms() {
        return studyRoomDao.getStudyRooms();
    }
}
