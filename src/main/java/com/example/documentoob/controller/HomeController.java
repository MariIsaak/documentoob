package com.example.documentoob.controller;


import com.example.documentoob.model.UserDtls;
import com.example.documentoob.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpSession session, Model model) {
        // Извлекаем сообщение из сессии и передаем в модель
        String msg = (String) session.getAttribute("msg");
        model.addAttribute("msg", msg);

        // После этого очищаем сообщение, чтобы оно не отображалось повторно
        session.removeAttribute("msg");

        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session) {

        boolean f = userService.checkEmail(user.getEmail());

        if (f) {
            session.setAttribute("msg", "Email Id already exists");
        } else {
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg", "Registered Successfully");
            } else {
                session.setAttribute("msg", "Something went wrong on server");
            }
        }

        return "redirect:/register";
    }
}
