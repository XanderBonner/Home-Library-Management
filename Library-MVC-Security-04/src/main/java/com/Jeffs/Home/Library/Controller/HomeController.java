package com.Jeffs.Home.Library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api") // base mapping
public class HomeController {

    @GetMapping("/home")
    public String homePage() {
        return "Home/home-page"; // This should match the home-page.html file location
    }
}
