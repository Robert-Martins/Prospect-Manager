import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: () => import("./views/home/home.module").then(m => m.HomeModule)
  },
  {
    path: 'prospects',
    loadChildren: () => import("./views/prospects/prospects.module").then(m => m.ProspectsModule)
  },
  {
    path: 'queue',
    loadChildren: () => import("./views/queue/queue.module").then(m => m.QueueModule)
  },
  {
    path: '**',
    redirectTo: 'home'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
