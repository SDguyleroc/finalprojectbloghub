package com.finalProject.bloggerhub;

import com.finalProject.bloggerhub.entity.Post;
import com.finalProject.bloggerhub.repository.PostRepository;
import com.finalProject.bloggerhub.service.PostService;
import com.finalProject.bloggerhub.service.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PostServiceImplTest {

    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        postService = new PostServiceImpl(postRepository);
    }

    @Test
    public void testSavePost() {
        Post post = new Post();
        when(postRepository.save(post)).thenReturn(post);

        Post savedPost = postService.savePost(post);

        assertEquals(post, savedPost);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void testGetAllposts() {
        postService.getAllposts();

        verify(postRepository, times(1)).findAll();
    }

    @Test
    public void testGetPostById() {
        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);
        Optional<Post> optionalPost = Optional.of(post);
        when(postRepository.findById(postId)).thenReturn(optionalPost);

        Post retrievedPost = postService.getPostById(postId);

        assertEquals(post, retrievedPost);
        assertEquals(1, post.getViewCount());
        verify(postRepository, times(1)).findById(postId);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void testGetPostByIdNotFound() {
        Long postId = 1L;
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        try {
            postService.getPostById(postId);
        } catch (EntityNotFoundException e) {
            assertEquals("Post not found", e.getMessage());
        }

        verify(postRepository, times(1)).findById(postId);
    }

    @Test
    public void testLikePost() {
        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);
        Optional<Post> optionalPost = Optional.of(post);
        when(postRepository.findById(postId)).thenReturn(optionalPost);

        postService.likePost(postId);

        assertEquals(1, post.getLikeCount());
        verify(postRepository, times(1)).findById(postId);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void testLikePostNotFound() {
        Long postId = 1L;
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        try {
            postService.likePost(postId);
        } catch (EntityNotFoundException e) {
            assertEquals("Post not found with Id: " + postId, e.getMessage());
        }

        verify(postRepository, times(1)).findById(postId);
    }
}
