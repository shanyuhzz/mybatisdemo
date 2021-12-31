package com.example.mybatisdemo.service.manager;

import com.example.mybatisdemo.entity.Student;
import com.example.mybatisdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class StudentManager {
    @Autowired
    private StudentMapper studentMapper;

    public void exceptionMethod(){
        int a = 0;
        int b = 1;

        int c = b/a;
    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveDB(){
        Student student = new Student();
        student.setId(23);
        student.setBirthday(new Date());
        student.setName("测试A");
        student.setSex(1);
        studentMapper.save(student);
    }
}
