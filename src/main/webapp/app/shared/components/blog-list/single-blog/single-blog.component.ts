import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Account } from 'app/core/auth/account.model';
import { AccountService } from 'app/core/auth/account.service';
import { Blog } from '../blog.interface';
import { Comment } from '../comment.interface';
import { BlogService } from '../blog.service';

@Component({
  selector: 'jhi-app-single-blog',
  templateUrl: './single-blog.component.html',
  styleUrls: ['./single-blog.component.scss']
})
export class SingleBlogComponent implements OnInit  {

  id: string | null | undefined;
  blog: Blog | undefined;
  account!:Account;
  comments!: Comment[];

  message?:string;

  constructor(private route: ActivatedRoute, private blogService : BlogService, private accountService : AccountService) {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.id = params.get('id');
    })
  }
  ngOnInit(): void {
    this.blog = this.blogService.getBlog(this.id);
    this.accountService.identity().subscribe(account => {
      if (account) {
        this.account = account;
      }
    });

    this.loadComments();
  
  }

  loadComments(){
    this.blogService.query(this.id!).subscribe((comments : any) => {
      this.comments = comments.body;
    })
  }

  send(){
    const comment: Comment = {
      content:this.message!,
      blogId: window.parseInt(this.id!),
      user:this.account
    }
    this.blogService.create(comment).subscribe(() => {
     this.message = "";
     this.loadComments();
    })
  }


  

}
