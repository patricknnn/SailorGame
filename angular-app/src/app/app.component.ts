import {Component, OnInit} from '@angular/core';
import {fadeAnimation} from "./animations";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [
    fadeAnimation
  ]
})
export class AppComponent implements OnInit {
  title = 'Sailor Game';

  constructor() {}

  ngOnInit(): void {}

  public getRouterOutletState(outlet) {
    return outlet.isActivated ? outlet.activatedRoute : '';
  }

}
