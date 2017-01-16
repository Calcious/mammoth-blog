package com.codeup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Calcious on 1/5/17.
 */

@Controller
public class PostsController extends BaseController{

    @Autowired
    Posts postsDao;

    @GetMapping("/posts")
    public String index(Model model){
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/profile")
    public String profile(Model m){
        m.addAttribute("user", loggedInUser());
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
    public String create(@Valid Post post, Errors validation, Model model){

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }
        post.setUser(loggedInUser());
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id, Model model){
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }



    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model){
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }


    @PostMapping ("/posts/{id}/edit")
    public String update(@ModelAttribute Post editedPost, @PathVariable int id){

        Post existingPost = postsDao.findById(id);
        String newTitle = editedPost.getTitle();
        String newDescription = editedPost.getDescription();
        existingPost.setTitle(newTitle);
        existingPost.setDescription(newDescription);
        postsDao.save(existingPost);
        return "redirect:/posts/" + existingPost.getId();
    }


    @GetMapping ("/posts/{id}/delete")
    public String delete(@PathVariable int id){
        Post post = postsDao.findById(id);
        postsDao.delete(post);
        return "redirect:/posts";
    }

}
