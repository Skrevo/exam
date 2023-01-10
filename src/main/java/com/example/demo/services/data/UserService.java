package com.example.demo.services.data;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    List<User> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic);

    void deleteAll();

    User findById(Integer id);

    List<User> saveAll(List<User> users);
}
