package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 增加一个新学生
     * @param student
     */
    void save(Student student);

    /**
     * 通过id删除一个学生
     * @param id
     */
    void delete(int id);

    /**
     * 根据id修改学生
     * @param student
     */
    void update(Student student);

    /**
     * 查询所有学生
     * @return 学生
     */
    List<Student> findAll();

    /**
     * 通过id查询学生
     * @param id
     * @return 学生
     */
    Student findById(int id);
}
