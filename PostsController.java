package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/register")
    public String register(){
        return "posts/register";
    }

    @GetMapping("/login")
    public String login(){
        return "posts/login";
    }

    @GetMapping("/profile")
    public String profile(){
        return "posts/profile";
    }

    @GetMapping("/main")
    public String home(){
        return "posts/main";
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
        model.addAttribute("posts", DaoFactory.getPostsDao().all());
        return "posts/show";
    }



//    @GetMapping("/posts/{id}/edit")
//    public String showEditForm(Model model){
//        //TODO Use the passed id to find the record in the database
//        Post post = DaoFactory.getPostsDao().find(id);
//        //TODO Add the model
//        model.addAttribute("post", post);
//        return "posts/edit";
//    }
//
//
//    @PostMapping ("/posts/{id}/edit")
//    public String update(@ModelAttribute Post editedPost, @PathVariable long id){
//
//        //TODO Find the existing record in the database with the passed id
//        Post existingPost = DaoFactory.getPostsDao().find(id);
//        //TODO Update the relevant fields
//        String newTitle = editedPost.getTitle();
//        String newDescription = editedPost.getDescription();
//        existingPost.setTitle(newTitle);
//        existingPost.setDescription(newDescription);
//        //TODO Update the existing post
//        DaoFactory.getPostsDao().update(existingPost);
//        return "redirect:/posts/" + existingPost.getId();
//    }


//    @PostMapping ("/posts/{id}/delete")
//    public String create(@ModelAttribute Post post){
//        DaoFactory.getPostsDao().save(post);
//        return "redirect:/posts";
//    }

}
