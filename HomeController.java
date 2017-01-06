package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Calcious on 1/5/17.
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}
