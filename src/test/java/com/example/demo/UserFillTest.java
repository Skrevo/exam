package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.services.data.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class UserFillTest {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Test
    public void userFillTest() {
        User student = new User(0,"s","s","s","s", passwordEncoder.encode("s"),"s@mail",null, User.Role.STUDENT );
        User student2 = new User(0,"s2","s2","s2","s2", passwordEncoder.encode("s2"),"s2@mail",null, User.Role.STUDENT );
        User teacher = new User(0,"t","t","t","t", passwordEncoder.encode("t"),"t@mail",null, User.Role.TEACHER );

        userService.save(student);
        userService.save(student2);
        userService.save(teacher);
    }
}
