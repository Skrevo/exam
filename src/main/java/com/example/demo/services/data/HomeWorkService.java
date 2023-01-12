package com.example.demo.services.data;

import com.example.demo.models.HomeWork;
import com.example.demo.models.User;

import java.util.List;

public interface HomeWorkService {
    HomeWork save(HomeWork homeWork);

    List<HomeWork> findAll();

    HomeWork findById(Integer id);
}
