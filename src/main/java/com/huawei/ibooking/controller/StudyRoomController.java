package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.StudyRoomBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.huawei.ibooking.model.StudyRoomDO;

import java.util.List;

@Controller
public class StudyRoomController {
    @Autowired
    private StudyRoomBusiness studyRoomBusiness;
    @GetMapping(value = "/studyroom")
    public ResponseEntity<List<StudyRoomDO>> list(){
        final List<StudyRoomDO> studyRooms = studyRoomBusiness.getStudyRooms();
        return ResponseEntity.ok(studyRooms);
    }

}
