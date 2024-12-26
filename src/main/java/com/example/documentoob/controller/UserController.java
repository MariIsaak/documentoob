package com.example.documentoob.controller;

import com.example.documentoob.model.UserDtls;
import com.example.documentoob.repository.UserRepository;
import com.example.documentoob.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepo;



    @ModelAttribute
    private void userDetails(Model m, Principal p) {
        String email = p.getName();
        UserDtls user = userRepo.findByEmail(email);

        m.addAttribute("user", user);

    }

    @GetMapping("/")
    public String home() {
        return "user/home";
    }





}

