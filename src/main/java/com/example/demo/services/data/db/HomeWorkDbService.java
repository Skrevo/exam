package com.example.demo.services.data.db;

import com.example.demo.models.HomeWork;
import com.example.demo.repositories.HomeWorkRepository;
import com.example.demo.services.data.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeWorkDbService implements HomeWorkService {

    @Autowired
    private HomeWorkRepository homeWorkRepository;

    @Override
    public HomeWork save(HomeWork homeWork) {
        return homeWorkRepository.save(homeWork);
    }

    @Override
    public List<HomeWork> findAll() {
        return homeWorkRepository.findAll();
    }

    @Override
    public HomeWork findById(Integer id) {
        return homeWorkRepository.findById(id).get();
    }
}
