package com.demo.service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    public List<User> getUser(){
        return repository.findAll();
    }

    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String name){
        return repository.findByName(name);
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "product removed..!" + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setNationality(user.getNationality());
        existingUser.setNic(user.getNic());
        return repository.save(existingUser);
    }
}
