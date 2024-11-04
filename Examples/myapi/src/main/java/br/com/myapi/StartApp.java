package br.com.myapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.myapi.model.User;
import br.com.myapi.service.UserService;

@Component
public class StartApp implements CommandLineRunner{

    @Autowired
    UserService service;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("Gravando no banco de dados...");
        
        User user = new User();
        user.setName("Wenderson");
        service.saveUser(user);

        for(User u : service.findAllUsers())
            System.out.println(u);

        System.out.println();
    }

}
