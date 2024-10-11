package com.example.giuseppeelefante.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    @GetMapping("/")
    public String home(HttpSession session){
        logger.info("Home page accessed");
        if(session.getAttribute("Language") == null){
            session.setAttribute("Language", "English");
        }
        return "homepage";
    }

    @GetMapping("/ChangeLang")
    public String changeLang(HttpSession session, HttpServletRequest request){
        String currentLanguage = (String) session.getAttribute("Language");
        String referer = request.getHeader("Referer");

        if("English".equals(currentLanguage)){
            session.setAttribute("Language", "Italian");
        } else {
            session.setAttribute("Language", "English");
        }
        return "redirect:" + (referer != null ? referer : "/");
    }

    @GetMapping("/projects")
    public String projects() {

        return "projects";
    }

    @GetMapping("/giuseppe")
    public String giuseppe() {
        return "giuseppe";
    }
}
