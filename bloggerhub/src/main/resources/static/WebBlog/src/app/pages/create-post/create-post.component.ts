import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { PostService } from '../../service/post.service';
import { error } from 'console';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})
export class CreatePostComponent implements OnInit {
  postForm!: FormGroup;
  tags: string[] = [];

  constructor(private fb: FormBuilder, private router: Router, private snackBar: MatSnackBar, private postService: PostService) {}

  //
  ngOnInit(): void {
    this.postForm = this.fb.group({
      name: [null, Validators.required],
      content: [null, [Validators.required, Validators.maxLength(5000)]],
      img: [null, Validators.required],
      postedBy: [null, Validators.required]
    });
  }
// adding tags in the tags array
  add(event: any): void {
    const value = (event.value || '').trim();
    if (value) {
      this.tags.push(value);
    }
    event.chipInput!.clear();
  }
//removing tag in tags
  remove(tag: any): void {
    const index = this.tags.indexOf(tag);
    if (index >= 0) {
      this.tags.splice(index, 1);
    }
  }

  //method to call the api

  createPost(){
    const data = this.postForm.value;
    data.tags= this.tags;

    this.postService.createNewpost(data).subscribe(res=>{
      this.snackBar.open("Post Created Successfully!!", "Ok");
      this.router.navigateByUrl("/view-all");
    }, error=>{
      this.snackBar.open("Something Went Wrong!", "Ok")

    })
  }
}
