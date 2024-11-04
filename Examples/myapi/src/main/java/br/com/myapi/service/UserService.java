package br.com.myapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myapi.model.User;
import br.com.myapi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public void saveUser(User user){
        repository.save(user);
    }

    public User findUserById(long id){
        return repository.findById(id).get();
    }

    public List<User> findAllUsers(){
        return repository.findAll();
    }
}
