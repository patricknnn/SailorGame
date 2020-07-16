import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MaterialModule} from './module/material/material.module';
import {StatsComponent} from './component/stats/stats.component';
import {GameComponent} from './component/game/game.component';
import {AppRoutingModule} from './app-routing.module';
import {WelcomeComponent} from './component/welcome/welcome.component';
import {GuessComponent} from './component/guess/guess.component';
import {WonComponent} from './component/won/won.component';
import {CardActionsComponent} from './component/card-actions/card-actions.component';
import { LoadingComponent } from './component/loading/loading.component';

@NgModule({
  declarations: [
    AppComponent,
    StatsComponent,
    GameComponent,
    WelcomeComponent,
    GuessComponent,
    WonComponent,
    CardActionsComponent,
    LoadingComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
