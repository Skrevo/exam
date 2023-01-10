package com.example.demo.services.data.db;

import com.example.demo.models.Teacher;
import com.example.demo.repositories.TeacherRepository;
import com.example.demo.services.data.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherDbService implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return teacherRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }

    @Override
    public void deleteAll() {
        teacherRepository.deleteAll();
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> saveAll(List<Teacher> teachers) {
        return teacherRepository.saveAll(teachers);
    }
}
