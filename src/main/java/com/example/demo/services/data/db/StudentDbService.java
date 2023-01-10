package com.example.demo.services.data.db;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.data.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDbService implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return studentRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }
}
