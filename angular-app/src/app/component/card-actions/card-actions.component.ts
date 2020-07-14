import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-actions',
  templateUrl: './card-actions.component.html',
  styleUrls: ['./card-actions.component.css']
})
export class CardActionsComponent {
  @Input() play: boolean = true;
  @Input() stats: boolean = true;
  @Input() exit: boolean = true;

  constructor() { }

}
