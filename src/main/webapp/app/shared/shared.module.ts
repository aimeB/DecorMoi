import { NgModule } from '@angular/core';

import { SharedLibsModule } from './shared-libs.module';
import { FindLanguageFromKeyPipe } from './language/find-language-from-key.pipe';
import { TranslateDirective } from './language/translate.directive';
import { AlertComponent } from './alert/alert.component';
import { AlertErrorComponent } from './alert/alert-error.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';
import { DurationPipe } from './date/duration.pipe';
import { FormatMediumDatetimePipe } from './date/format-medium-datetime.pipe';
import { FormatMediumDatePipe } from './date/format-medium-date.pipe';
import { SortByDirective } from './sort/sort-by.directive';
import { SortDirective } from './sort/sort.directive';
import { ItemCountComponent } from './pagination/item-count.component';
import { SharedRoutingModule } from './shared-routing.module';

import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { FaqComponent } from './components/faq/faq.component';
import { BlogListComponent } from './components/blog-list/blog-list.component';
import { ContactComponent } from './components/contact/contact.component';
import { MentionLegaleComponent } from './components/mention-legale/mention-legale.component';
import { ConditionsGeneraleComponent } from './components/conditions-generale/conditions-generale.component';
import { GalerieComponent } from './components/galerie/galerie.component';
import { AproposComponent } from './components/apropos/apropos.component';
import { SingleBlogComponent } from './components/blog-list/single-blog/single-blog.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [SharedLibsModule, SharedRoutingModule, FormsModule],
  declarations: [
    FindLanguageFromKeyPipe,
    TranslateDirective,
    AlertComponent,
    AlertErrorComponent,
    HasAnyAuthorityDirective,
    DurationPipe,
    FormatMediumDatetimePipe,
    FormatMediumDatePipe,
    SortByDirective,
    SortDirective,
    ItemCountComponent,
    AcceuilComponent,
    FaqComponent,
    BlogListComponent,
    ContactComponent,
    MentionLegaleComponent,
    ConditionsGeneraleComponent,
    GalerieComponent,
    AproposComponent,
    SingleBlogComponent
  ],
  exports: [
    SharedLibsModule,
    FindLanguageFromKeyPipe,
    TranslateDirective,
    AlertComponent,
    AlertErrorComponent,
    HasAnyAuthorityDirective,
    DurationPipe,
    FormatMediumDatetimePipe,
    FormatMediumDatePipe,
    SortByDirective,
    SortDirective,
    ItemCountComponent
  ],
})
export class SharedModule {}
