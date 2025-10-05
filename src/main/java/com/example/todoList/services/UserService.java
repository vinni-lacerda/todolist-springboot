package com.example.todoList.services;

import com.example.todoList.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todoList.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User saveUser(User user){
       return userRepository.save(user);
    }

    public void deleteUserById(Long id){
         userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userInfo){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        user.setName(userInfo.getName());
        user.setEmail(userInfo.getEmail());

        return userRepository.save(user);
    }
}
