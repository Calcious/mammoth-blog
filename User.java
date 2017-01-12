package com.codeup;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Calcious on 1/9/17.
 */
@Entity
@Table(name="users")
public class User {

    public User(User user) {
        id = user.id;
        email = user.email;
        username = user.username;
        password = user.password;
    }

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public int getid() {
        return id;
    }

    public void setid(int userid) {
        this.id = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 500, unique = true)
    private String email;

    @Column(nullable = false, length = 500)
    private String password;

}
