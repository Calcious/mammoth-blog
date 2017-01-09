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

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id, Model model){
        Post post = DaoFactory.getPostsDao().fetchPost(id);
        model.addAttribute("post", post);
        return "posts/show";
    }



    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model){
        Post post = DaoFactory.getPostsDao().fetchPost(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }


    @PostMapping ("/posts/{id}/edit")
    public String update(@ModelAttribute Post editedPost, @PathVariable int id){

        Post existingPost = DaoFactory.getPostsDao().fetchPost(id);
        String newTitle = editedPost.getTitle();
        String newDescription = editedPost.getDescription();
        existingPost.setTitle(newTitle);
        existingPost.setDescription(newDescription);
        DaoFactory.getPostsDao().update(existingPost);
        return "redirect:/posts/" + existingPost.getId();
    }


    @GetMapping ("/posts/{id}/delete")
    public String delete(@PathVariable int id){
        DaoFactory.getPostsDao().deletePost(id);
        return "redirect:/posts";
    }

}
