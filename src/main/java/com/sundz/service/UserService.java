package com.sundz.service;

import com.sundz.jpa.entity.User;
import com.sundz.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @description:
 * @author: Sundz
 * @version: V1.0
 * @date: 2020/9/27 14:23
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(new User());
    }
}
