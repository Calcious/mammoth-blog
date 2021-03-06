package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Calcious on 1/4/17.
 */
@Controller
class HelloController {

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String hello(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}