package org.spring.halloween2;

import java.util.Random;

import org.spring.halloween2.model.User;
import org.spring.halloween2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Initialize implements CommandLineRunner{

    private User user;
    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Random gen = new Random();
        for(int i = 0; i < 5; i++){
            user = new User();
            user.setUsername("Wend" + gen.nextLong(1000));
            user.setPassword("pass" + gen.nextLong(1000));
            repository.save(user);
        }

        for(User u : repository.findAll())
            System.out.println(u);
    }
}
