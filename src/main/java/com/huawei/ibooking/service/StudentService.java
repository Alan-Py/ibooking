package com.huawei.ibooking.service;

import com.huawei.ibooking.model.Student;

import java.util.List;
/**
 * <p>
 * 学生表Service接口
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
public interface StudentService {
    //获得所有的学生的信息列表
    List<Student> getAllStudents();
    //通过id获得单个学生信息
    Student getStudentByStuId(String stuId);
    // 添加学生信息
    boolean addStudent(Student student);
    // 更新学生信息
    boolean updateStudent(Student student);
    // 删除学生信息
    boolean deleteStudentById(String roomId);
}