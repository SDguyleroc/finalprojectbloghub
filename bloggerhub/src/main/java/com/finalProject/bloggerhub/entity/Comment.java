package com.finalProject.bloggerhub.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @author Guy-leroc Ossebi
 * Comment Entity.
 */

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length=5000)
    private String content;

    private Date createdAt;

    private String postedBy;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
