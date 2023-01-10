package com.example.demo.services.data;

import com.example.demo.models.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);

    List<Teacher> findAll();

    List<Teacher> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    void deleteAll();

    Teacher findById(Integer id);

    List<Teacher> saveAll(List<Teacher> teachers);
}
