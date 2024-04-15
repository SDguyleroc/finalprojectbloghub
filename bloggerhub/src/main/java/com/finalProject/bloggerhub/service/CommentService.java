package com.finalProject.bloggerhub.service;

import com.finalProject.bloggerhub.entity.Comment;
import com.finalProject.bloggerhub.entity.Post;

import java.util.List;

/**
 * A service interface for managing comments on posts.
 */

public interface CommentService {

     /**
     * Creates a new comment for a post.
     *
     * @param postId    The ID of the post for which the comment is created.
     * @param postedBy  The name of the user who is posting the comment.
     * @param content   The content of the comment.
     * @return The newly created comment.
    */

    Comment createComment(Long postId, String postedBy, String content);

    /**
     * Retrieves all comments for a post based on the post's ID.
     *
     * @param postId The ID of the post for which comments are retrieved.
     * @return A list of comments associated with the post.
     */
    List<Comment> getCommentsByPostId(Long postId);

}
