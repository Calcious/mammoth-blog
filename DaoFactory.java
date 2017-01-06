package com.codeup;

/**
 * Created by Calcious on 1/5/17.
 */
public class DaoFactory {
    private static Posts postsDao;

    public static Posts getPostsDao(){
        if (postsDao == null){
            postsDao = new ListPosts();
        }
        return postsDao;
    }
}
