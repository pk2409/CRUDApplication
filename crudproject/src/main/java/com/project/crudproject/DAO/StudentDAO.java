package com.project.crudproject.DAO;

import com.project.crudproject.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student thestudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastname(String lastname);

    void update(Student theStudent);

    void delete(Integer id);
}
