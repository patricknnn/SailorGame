import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-card-actions',
  templateUrl: './card-actions.component.html',
  styleUrls: ['./card-actions.component.css']
})
export class CardActionsComponent {
  @Input() play = true;
  @Input() stats = true;
  @Input() exit = true;

  constructor() { }

}
