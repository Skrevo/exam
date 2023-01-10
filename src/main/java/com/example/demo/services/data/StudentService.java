package com.example.demo.services.data;

import com.example.demo.models.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> findAll();

    List<Student> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    void deleteAll();

    Student findById(Integer id);

    List<Student> saveAll(List<Student> students);
}
