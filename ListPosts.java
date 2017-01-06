package com.codeup;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calcious on 1/5/17.
 */
public class ListPosts implements Posts {
    private List<Post> posts;

    public ListPosts() {
        posts = new ArrayList<>();
    }

    @Override
    public List<Post> all(){
        return posts;
    }

    @Override
    public void save(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
    }

}
