//package com.huawei.ibooking.dao;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.huawei.ibooking.model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class StudentDao implements BaseMapper<Student> {
//
//    publiic
//    public List<StudentDO> getStudents() {
//        return studentMapper.getStudents();
//    }
//
//    public List<StudentDO> getStudent(final String stuNum) {
//        return studentMapper.getStudent(stuNum);
//    }
//
//    public boolean saveStudent(final StudentDO stu) {
//        return studentMapper.saveStudent(stu) > 0;
//    }
//
//    public boolean deleteStudent(final String stuNum) {
//        return studentMapper.deleteStudent(stuNum) > 0;
//    }
//}
