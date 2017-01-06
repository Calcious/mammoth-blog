package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Calcious on 1/5/17.
 */

@Controller
public class PostsController {

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> posts = DaoFactory.getPostsDao().all();
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping ("/posts/create")
    public String create(@ModelAttribute Post post){
        DaoFactory.getPostsDao().save(post);
        return "redirect:/posts";
    }

    @GetMapping("/show")
    public String viewPost(Model model){
        List<Post> posts = DaoFactory.getPostsDao().all();
        model.addAttribute("posts", posts);
        return "posts/show";
    }



//    @GetMapping("/posts/{id}/edit")
//    public String showEditForm


//    @PostMapping ("/posts/{id}/edit")
//    public String create(@ModelAttribute Post post){
//        DaoFactory.getPostsDao().save(post);
//        return "redirect:/posts";
//    }


//    @PostMapping ("/posts/{id}/delete")
//    public String create(@ModelAttribute Post post){
//        DaoFactory.getPostsDao().save(post);
//        return "redirect:/posts";
//    }

}
