package com.pranavd.foody.Service;

import com.pranavd.foody.Model.User;
import com.pranavd.foody.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }

    public void deleteUserById(Long id){
        userRepository.delete(getUserById(id));
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers(User user){
        return userRepository.findAll();
    }

}
