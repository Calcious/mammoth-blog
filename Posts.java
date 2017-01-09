package com.codeup;

import java.util.List;

/**
 * Created by Calcious on 1/5/17.
 */
public interface Posts {

    List<Post> all();

    void save(Post post);

    Post fetchPost(int id);

    void update(Post post);

    void deletePost(int id);
}
