package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Calcious on 1/4/17.
 */
@Controller
class MathController {
    @GetMapping("/add/{first}/and/{second}")
    @ResponseBody
    public String addStuff(@PathVariable int first,@PathVariable int second){
        return "<p>The result is " + (first + second) + "</p>";
    }

    @GetMapping("/sub/{first}/and/{second}")
    @ResponseBody
    public String subStuff(@PathVariable int first,@PathVariable int second){
        return "<p>The result is " + (first - second) + "</p>";
    }

    @GetMapping("/mult/{first}/and/{second}")
    @ResponseBody
    public String multStuff(@PathVariable int first,@PathVariable int second){
        return "<p>The result is " + (first * second) + "</p>";
    }

    @GetMapping("/div/{first}/and/{second}")
    @ResponseBody
    public String divStuff(@PathVariable int first,@PathVariable int second){
        return "<p>The result is " + (first / second) + "</p>";
    }
}
