package com.example.demo.repositories;

import com.example.demo.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findAllBySurnameAndNameAndPatronymic (String surname, String name, String patronymic);
}
