package com.codeup;
import javax.persistence.*;
/**
 * Created by Calcious on 1/9/17.
 */
@Entity
@Table(name="users")
public class User {
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 500)
    private String email;

    @Column(nullable = false, length = 500)
    private String password;

}
