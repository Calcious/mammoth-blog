package com.codeup;



import javax.persistence.*;

/**
 * Created by Calcious on 1/5/17.
 */
@Entity
@Table(name="posts")
public class Post {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;


    @Column(nullable = false, length = 500)
    private String description;


}
