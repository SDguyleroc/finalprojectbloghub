package com.finalProject.bloggerhub.service;

import com.finalProject.bloggerhub.entity.Comment;
import com.finalProject.bloggerhub.entity.Post;
import com.finalProject.bloggerhub.repository.CommentRepository;
import com.finalProject.bloggerhub.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment createComment(Long postId, String postedBy, String content){
        Optional<Post> optionalPost= postRepository.findById(postId);

        if(optionalPost.isPresent()){
            Comment comment = new Comment();
            comment.setPost(optionalPost.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());


            return commentRepository.save(comment);
        }
        throw new EntityNotFoundException("Post not found");

    }

    /**
     * param postId the ID of the post to retrieve comments for
     * return a list of comments associate with the specified postID
     */
    public List<Comment> getCommentsByPostId(Long postId){
        return commentRepository.findByPostId(postId);
    }


}
