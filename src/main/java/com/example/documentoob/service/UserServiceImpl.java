package com.example.documentoob.service;

import com.example.documentoob.model.UserDtls;
import com.example.documentoob.repository.UserRepository;
import com.example.documentoob.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Users usersRepository;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    public UserServiceImpl( UserRepository userRepo, BCryptPasswordEncoder passwordEncode) {
        this.userRepo= userRepo;
        this.passwordEncode = passwordEncode;
    }



    @Override
    public UserDtls createUser(UserDtls user) {

        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.setRole("ROLE_USER");

        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {

        return userRepo.existsByEmail(email);
    }

    public List<UserDtls> getAllUsers() {return userRepo.findAll();}

    public void updateUser(UserDtls user) {
        userRepo.save(user);
    }

    public void addUser(UserDtls user) {
        userRepo.save(user);
    }


    public void deleteUserById(Integer id) {
        userRepo.deleteById(id);
    }

    public UserDtls getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

}