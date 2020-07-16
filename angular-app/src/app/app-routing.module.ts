import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WelcomeComponent} from "./component/welcome/welcome.component";
import {GameComponent} from "./component/game/game.component";
import {StatsComponent} from "./component/stats/stats.component";
import {GuessComponent} from "./component/guess/guess.component";
import {WonComponent} from "./component/won/won.component";
import {PageNotFoundComponent} from "./component/page-not-found/page-not-found.component";

const routes: Routes = [
  {path: '', redirectTo: 'welcome', pathMatch: 'full'},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'game', component: GameComponent},
  {path: 'guess', component: GuessComponent},
  {path: 'stats', component: StatsComponent},
  {path: 'won', component: WonComponent},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
