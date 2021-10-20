import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { Blog } from '../blog-list/blog.interface';
import { Comment } from '../blog-list/comment.interface';

export type EntityResponseType = HttpResponse<string>;
export type EntityArrayResponseType = HttpResponse<string>;


@Injectable({
  providedIn: 'root',
})
export class BlogService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/comments');

  private blogs : Blog[]  = [
    {
      id: "1",
      img: 'content/images/garden party.jpeg',
      alt: 'Nature',
      title: 'Que peut bien faire une société de décoration en période de confinement ?',
      subtitle:
        "L'arrivée du Covid a secoué nos habitudes nous poussant dans nos derniers retranchements. Décor'moi a décidé de vous raconter son confinement.",
    },
    {
      id: "2",
      img: 'content/images/tourettaxi.jpeg',
      alt: 'Nature',
      title: 'Vous avez raté le Salon du Mariage de Tour&Taxi 2019, Décor’moi vous raconte.',
      subtitle: '2000 couples, 115 exposants et 4 défilés sur le site de Tour&Taxi, des chiffres qui font de ce salon un incontournable.',
    },
    {
      id: "3",
      img: 'content/images/salon-du-mariage-africain.jpeg',
      alt: 'Nature',
      title: 'Le tout premier Salon du Mariage Africain de Bruxelles',
      subtitle: 'Un tout nouveau salon a vu le jour à Bruxelles en 2016 et ce fût le salon du mariage africain au Thon Hôtel Bristol Stéphanie avenue Louise',
    },
  ];

  constructor(protected http: HttpClient,protected applicationConfigService: ApplicationConfigService) {}


  getBlogs() : Blog[] {
      return this.blogs;
  }

  getBlog(id : string | null | undefined) : Blog | undefined{
    return this.blogs.find(blog => blog.id === id);
  }


  create(comment : Comment) {
    
    return this.http.post<Comment>(this.resourceUrl, comment, { observe: 'response' });
  }

  
  query(id:string){
    return this.http.get<Comment[]>(`${this.resourceUrl}/${id}`, {  observe: 'response' });
  }

 

  
}
