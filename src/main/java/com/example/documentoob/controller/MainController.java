package com.example.documentoob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index"; // Возвращает шаблон index.html
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Добро пожаловать домой!");
        return "home"; // Возвращает шаблон home.html
    }
}
