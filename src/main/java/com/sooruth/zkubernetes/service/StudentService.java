package com.sooruth.zkubernetes.service;

import com.sooruth.zkubernetes.entity.Student;

import java.util.List;

public interface StudentService extends EntityService<Student>{

    List<Student> findAllStudentsOlderThan(Integer age);

    Student findStudentByEmail(String email);
}
