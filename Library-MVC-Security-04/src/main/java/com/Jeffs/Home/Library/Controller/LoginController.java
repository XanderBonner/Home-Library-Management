package com.Jeffs.Home.Library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api") //base mapping
public class LoginController {

    @GetMapping("/login")
    public String showMyLoginPage(){

        return "Home/fancy-login";
    }

    //Request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){

        return "Home/access-denied";
    }

}
