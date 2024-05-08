package com.huawei.ibooking.controller;

import com.huawei.ibooking.common.ResponseData;
import com.huawei.ibooking.model.Student;
import com.huawei.ibooking.model.dto.StudentReq;
import com.huawei.ibooking.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * <p>
 * 学生表controller层
 * </p>
 *
 * @author panyue
 * @since 2024-04-09
 */
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private static final Logger LOGGER = Logger.getLogger(StudentController.class.getName());

    /***
     * 学生登录
     * @param req
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody StudentReq req) {
        Student student1 = studentService.getStudentByStuId(req.getStuId());
        if (student1 != null && student1.getPassword().equals(req.getPassword())) {
            // 返回student信息以及0表示成功
            return ResponseEntity.ok(new ResponseData(0, "成功"));
        } else {
            //返回状态码-1，用户名密码错误
            return ResponseEntity.ok(new ResponseData(-1, "用户名或密码错误"));
        }
    }

    /***
     * 学生注册
     * @param student
     * @return
     */
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody Student student) {
        Student res = studentService.getStudentByStuId(student.getStuId());
        if (res != null) {
            //返回状态码-1，用户已存在
            return ResponseEntity.ok(new ResponseData(-1, "用户已存在"));
        } else {
            //返回状态码0，注册成功
            if(student.getEmail()==null){
                student.setEmail("");
            }
            if(student.getPhone()==null){
                student.setPhone("");
            }
            studentService.addStudent(student);
            return ResponseEntity.ok(new ResponseData(0, "注册成功"));
        }
    }


    @GetMapping
    public ResponseEntity<List<Student>> list() {
        List<Student> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/{stuId}")
    public ResponseEntity<Student> query(@PathVariable("stuId") String stuId) {
        Student student = studentService.getStudentByStuId(stuId);
        if (student != null) {
            // 如果学生信息存在，返回200 OK状态码和学生对象
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            // 如果学生信息不存在，返回404 Not Found状态码和错误信息
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // 添加学生信息的方法
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            boolean isSuccess = studentService.addStudent(student);
            if (isSuccess) {
                // 创建一个成功的响应
                return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
            } else {
                // 创建一个失败的响应
                return new ResponseEntity<>("Failed to add student", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // 创建一个错误响应
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        boolean isSuccess = studentService.updateStudent(student);
        if (isSuccess) {
            // 更新成功，返回200 OK状态码和成功消息
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            // 更新失败，返回404 Not Found状态码和错误消息
            return new ResponseEntity<>("Student not found or update failed", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{stuId}")
    public ResponseEntity<?> deleteStudent(@PathVariable("stuId") String stuId) {
        boolean result = studentService.deleteStudentById(stuId);
        if (result) {
            // 删除成功，返回200 OK状态码和成功消息
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else {
            // 删除失败，返回404 Not Found状态码和错误消息
            return new ResponseEntity<>("Student not found or delete failed", HttpStatus.NOT_FOUND);
        }
    }

}
