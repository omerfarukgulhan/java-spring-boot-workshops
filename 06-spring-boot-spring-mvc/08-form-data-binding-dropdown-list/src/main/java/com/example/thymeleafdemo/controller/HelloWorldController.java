package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
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
        String result = "Hello 1, " + name;
        model.addAttribute("message", result);

        return "helloworld";
    }

    @GetMapping("/processFormV3")
    public String processFromV3(@RequestParam("studentName") String name, HttpServletRequest request, Model model) {
        name = name.toUpperCase();
        String result = "Hello 2, " + name;
        model.addAttribute("message", result);

        return "helloworld";
    }
}
