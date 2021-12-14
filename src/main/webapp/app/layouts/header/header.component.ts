import {Component, OnInit} from '@angular/core';

import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import {SessionStorageService} from 'ngx-webstorage';
import {LANGUAGES} from 'app/config/language.constants';
import {Account} from 'app/core/auth/account.model';
import {AccountService} from 'app/core/auth/account.service';
import {LoginService} from 'app/login/login.service';
import {ProfileService} from 'app/layouts/profiles/profile.service';
import { EventService } from 'app/entities/event/service/event.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  inProduction?: boolean;
  languages = LANGUAGES;
  openAPIEnabled?: boolean;
  account: Account | null = null;
  soldOut:any;
  messages?:string = "";


  constructor(
    private loginService: LoginService,
    private translateService: TranslateService,
    private sessionStorageService: SessionStorageService,
    private accountService: AccountService,
    private profileService: ProfileService,
    private router: Router,
    private eventService : EventService
  ) {}

  ngOnInit(): void {
    this.profileService.getProfileInfo().subscribe(profileInfo => {
      this.inProduction = profileInfo.inProduction;
      this.openAPIEnabled = profileInfo.openAPIEnabled;
    });
    this.accountService.getAuthenticationState().subscribe(account => {
      if(account){
        this.account = account;
        this.eventService.findWithPercentage().subscribe((res: any) => {
          this.soldOut = res.body;
          let messageResult = "";
          let produitSoldOut = "";
          Object.keys(this.soldOut).forEach(key => {
           
            const map: any = this.soldOut[key]?.mapPourcentage;
            const mapQuantity: any = this.soldOut[key]?.mapQuantity;
            
            if(map){
              Object.keys(map).forEach(k => {
                if(map[k]< 10){
                  if(mapQuantity){
                    const qty = mapQuantity[k] as number;
                    if(qty<=0){
                      produitSoldOut+=`Il ne reste plus de ${k.toLowerCase()} en stock<br />`;
                    }else{
                      produitSoldOut+=`Il reste ${qty} ${k.toLowerCase()}(s)<br />`;
                    }
                  }
                }
              })
            }
            if(produitSoldOut.length !== 0){
              messageResult+=`Pour la date du <b>${key}</b>, les articles suivants sont inférieurs à 10%: <br />`;
              messageResult+= `<b>${produitSoldOut}</b>`;
            }

            produitSoldOut = "";

          });
          this.messages = messageResult;

        })
       
      }
      
    });
  }

  changeLanguage(languageKey: string): void {
    this.sessionStorageService.store('locale', languageKey);
    this.translateService.use(languageKey);
  }

  login(): void {
    this.router.navigate(['/login']);
  }

  logout(): void {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }
}
