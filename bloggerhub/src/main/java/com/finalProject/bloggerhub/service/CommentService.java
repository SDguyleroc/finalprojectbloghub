package com.finalProject.bloggerhub.service;

import com.finalProject.bloggerhub.entity.Comment;
import com.finalProject.bloggerhub.entity.Post;

import java.util.List;

public interface CommentService {

    Comment createComment(Long postId, String postedBy, String content);
    List<Comment> getCommentsByPostId(Long postId);

}
