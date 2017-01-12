package com.codeup;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Calcious on 1/10/17.
 */
public interface Users extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}