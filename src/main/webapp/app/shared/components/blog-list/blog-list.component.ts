import { Component, OnInit } from '@angular/core';
import { Blog } from './blog.interface';
import { BlogService } from './blog.service';

@Component({
  selector: 'jhi-app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.scss']
})
export class BlogListComponent implements OnInit{

  blogs:Blog[] = [];
  constructor(private blogService : BlogService){}



  ngOnInit(): void {
    this.blogs = this.blogService.getBlogs();
  }

}
