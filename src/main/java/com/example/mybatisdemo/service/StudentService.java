package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Student;
import com.example.mybatisdemo.mapper.StudentMapper;
import com.example.mybatisdemo.service.manager.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentManager studentManager;

    @Transactional(rollbackFor = Exception.class)
    public List<Student> findAll(){
        studentManager.saveDB();
        exceptionMethod();

        return null;
    }

    /**
     * 1.默认情况：
     */

    public void exceptionMethod(){
        int a = 0;
        int b = 1;

        int c = b/a;
    }

    public void saveDB(){
        Student student = new Student();
        student.setId(23);
        student.setBirthday(new Date());
        student.setName("测试A");
        student.setSex(1);
        studentMapper.save(student);
    }
}
