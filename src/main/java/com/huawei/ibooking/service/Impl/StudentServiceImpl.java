package com.huawei.ibooking.service.Impl;

import com.huawei.ibooking.mapper.StudentMapper;
import com.huawei.ibooking.model.Student;
import com.huawei.ibooking.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectList(null);
    }

    @Override
    public Student getStudentByStuId(String stuId) {
        return studentMapper.getStudentByStuId(stuId);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentMapper.insert(student) > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateById(student) > 0;
    }

    @Override
    public boolean deleteStudentById(String stuId) {
        return studentMapper.deleteStudentByStuId(stuId) > 0;
    }
}