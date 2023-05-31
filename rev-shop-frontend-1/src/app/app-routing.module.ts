import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { ItemPageComponent } from './pages/item-page/item-page.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products/item', component: ItemPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
