package com.codeup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Created by Calcious on 1/10/17.
 */
@Controller
public class UsersController {
    @Autowired
    Users users;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/register")
    public String register(){
        return "posts/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model){
        String plainTextPassword = user.getPassword();
        String hashedPassword = passwordEncoder.encode(plainTextPassword);
        user.setPassword(hashedPassword);

        users.save(user);
        model.addAttribute("user", user);
        return "login";
    }


}
