import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TranslateComponent} from './translate/translate.component';
import {DetailComponent} from './detail/detail.component';


const routes: Routes = [
  {
    path: 'translate/:name',
    component: DetailComponent},
  // {path: 'timelines', component: DetailComponent},
 {
  path: '' ,
  component: TranslateComponent
}
];
// const routes: Routes = [{
//   path: '',
//   component: TranslateComponent
// }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
