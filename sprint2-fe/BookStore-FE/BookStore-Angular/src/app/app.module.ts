import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {APP_BASE_HREF} from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {SecurityModule} from './security/security.module';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {JWT_OPTIONS, JwtHelperService} from '@auth0/angular-jwt';
import {authInterceptorProviders} from './helpers/auth.interceptor';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {BookListComponent} from './book/book-list/book-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        SecurityModule,
        RouterModule,
        HttpClientModule,
        AngularFireModule.initializeApp(environment.firebaseConfig),
        FormsModule,
        ReactiveFormsModule,
        NgxPaginationModule
    ],
  providers: [authInterceptorProviders,
    JwtHelperService,
    {provide: JWT_OPTIONS, useValue: JWT_OPTIONS},
    {provide: APP_BASE_HREF, useValue : '/' }] ,
  bootstrap: [AppComponent]
})
export class AppModule { }
