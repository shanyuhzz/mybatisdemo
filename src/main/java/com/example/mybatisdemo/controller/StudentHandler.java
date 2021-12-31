package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.Student;
import com.example.mybatisdemo.mapper.StudentMapper;
import com.example.mybatisdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class StudentHandler {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") int id){
        return studentMapper.findById(id);
    }

    @PutMapping("/save")
    public void save(@RequestBody Student student){
        studentMapper.save(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentMapper.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        studentMapper.delete(id);
    }

}
