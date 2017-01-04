package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Calcious on 1/4/17.
 */
@Controller
class HelloController {

    @GetMapping("/hello/{name}") //path variable being passed into controller method AS the actual URL
    @ResponseBody //Whatever is returned--that is going to be the HTML response that we send back *see line 17*
    public String hello(@PathVariable String name) {
        return "<h1>Hello, " + name + "</h1>";
    }
    @GetMapping("/increment/{number}")
    @ResponseBody
    public String increment(@PathVariable int number){
        return number + 1 + "your number is" + (number + 1);
    }
}