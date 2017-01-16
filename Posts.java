package com.codeup;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Calcious on 1/5/17.
 */
public interface Posts extends CrudRepository<Post, Long>{

    public Post findByUser(User user);

    public Post findById(int id);

    List<Post> findAll();

//    void save(Post post);
}
