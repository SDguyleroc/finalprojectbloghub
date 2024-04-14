import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL= 'http://localhost:8080/';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  createNewpost(data:any):Observable<any>{

    return this.http.post(BASIC_URL + `api/post`, data);
  }

  getAllPost():Observable<any>{

    return this.http.get(BASIC_URL + `api/post`);
  }

  getPostById(postId:number):Observable<any>{
    return this.http.get(BASIC_URL + `api/post/${postId}`);
  }

  likePost(postId:number):Observable<any>{
    return this.http.put(BASIC_URL + `api/post/${postId}/like`, {});
  }

  searchPostByName(postName:string):Observable<any>{
    return this.http.get(BASIC_URL + `api/post/search/${postName}`);
  }


}
