package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllBySurnameAndNameAndPatronymic (String surname, String name, String patronymic);

    User findByUsername (String username);
}
