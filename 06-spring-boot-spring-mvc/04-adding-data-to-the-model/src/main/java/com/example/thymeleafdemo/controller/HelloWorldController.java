package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }


    @RequestMapping("/processFormV2")
    public String processFromV2(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");

        name = name.toUpperCase();
        String result = "Hello, " + name;
        model.addAttribute("message", result);

        return "helloworld";
    }
}
