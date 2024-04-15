import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PostService } from '../../service/post.service';

import { ActivatedRoute } from '@angular/router';
import { error } from 'console';
import { Router } from '@angular/router';
import { CommentService } from '../../service/comment.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { response } from 'express';

@Component({
  selector: 'app-view-post',
  templateUrl: './view-post.component.html',
  styleUrl: './view-post.component.scss'
})
export class ViewPostComponent {

  postId = this.activatedRouter.snapshot.params['id'];
  postData:any;
  comments:any;


  commentForm!: FormGroup;



  constructor(private snackBar:MatSnackBar, private postService:PostService, private activatedRouter:ActivatedRoute,
    private commentService:CommentService, private fb:FormBuilder, private router:Router ){}

  ngOnInit(){
    console.log(this.postId);
    this.getpostById();

    this.commentForm = this.fb.group({
      postedBy:[null, Validators.required],
      content: [null, Validators.required],

    })
  }

  publishComment(){
    const postedBy = this.commentForm.get('postedBy')?.value;
    const content = this.commentForm.get('content')?.value;

    this.commentService.createComment(this.postId, postedBy, content).subscribe(res=>{
      this.snackBar.open("Comment posted Successfully", "Ok");
  //    this.router.navigateByUrl("/view-post");
      this.getCommentsByPost();
    }, error=>{
      this.snackBar.open("Something went Wrong!", "Ok")
    })
  }

  getCommentsByPost(){
    this.commentService.getAllCommentsByPost(this.postId).subscribe(res=>{
      this.comments =res.sort((a: any, b: any) => b.id - a.id);;
    }, error=>{
      this.snackBar.open("Something went Wrong!", "Ok")
    })
  }

  getpostById(){
    this.postService.getPostById(this.postId).subscribe(res=>{
      this.postData= res;
      this.getCommentsByPost();
      console.log(res);
    }, error=>{
      this.snackBar.open("Something went Wrong!", "OK")
    })
  }

  likePost(){
    this.postService.likePost(this.postId).subscribe((response)=>{
      this.snackBar.open("Liked", "Ok");
      this.getpostById();
    }, (error)=>{this.snackBar.open("Something went wrong", "ok")})
  }

}
