package com.finalProject.bloggerhub.service;

import com.finalProject.bloggerhub.entity.Post;

import java.util.List;

public interface PostService {

    Post savePost(Post post);
    List<Post> getAllposts();
    Post getPostById(Long postId);
    void likePost(Long postId);
    List<Post> searchByName(String name);

}
