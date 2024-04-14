import { Component } from '@angular/core';
import { PostService } from '../../service/post.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { error } from 'console';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrl: './view-all.component.scss'
})
export class ViewAllComponent {

  allPosts:any;
//Snackbar used for messages. postservice is for calling api
  constructor(private postService:PostService, private snackBar:MatSnackBar){}

//call getAllposts when the component loads
  ngOnInit(){
    this.getAllPosts();
  }

  //method to call the api
  getAllPosts() {
    this.postService.getAllPost().subscribe(
      (res) => {
        // Sort posts by ID in descending order
        this.allPosts = res.sort((a: any, b: any) => b.id - a.id);
      },
      (error) => {
        this.snackBar.open('Something went wrong!', 'Ok');
      }
    );
  }
}
