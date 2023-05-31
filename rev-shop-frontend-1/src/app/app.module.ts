import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { ItemPageComponent } from './pages/item-page/item-page.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';






@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ItemPageComponent,
    NavBarComponent,
    
  
  
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
