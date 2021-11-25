import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { AproposComponent } from './components/apropos/apropos.component';
import { BlogListComponent } from './components/blog-list/blog-list.component';
import { SingleBlogComponent } from './components/blog-list/single-blog/single-blog.component';
import { ConditionsGeneraleComponent } from './components/conditions-generale/conditions-generale.component';
import { ContactComponent } from './components/contact/contact.component';
import { FaqComponent } from './components/faq/faq.component';
import { GalerieComponent } from './components/galerie/galerie.component';
import { MentionLegaleComponent } from './components/mention-legale/mention-legale.component';



@NgModule({
  imports: [
    RouterModule.forChild(
      [
        
        { path: 'acceuil', component: AcceuilComponent },

        { path: 'faq', component: FaqComponent },
        { path: 'mentionlegale', component: MentionLegaleComponent },
        { path: 'conditionsgenerale', component: ConditionsGeneraleComponent },

        { path: 'blog-list', component: BlogListComponent },
        { path: 'blog-list/:id', component: SingleBlogComponent },

        { path: 'galerie', component: GalerieComponent },
        { path: 'apropos', component: AproposComponent },
        { path: 'contact', component: ContactComponent },
      ]
    ),
  ],
  exports: [RouterModule],
})
export class SharedRoutingModule { }
