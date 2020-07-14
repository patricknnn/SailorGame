import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-actions',
  templateUrl: './card-actions.component.html',
  styleUrls: ['./card-actions.component.css']
})
export class CardActionsComponent implements OnInit {
  @Input() card: string;

  constructor() { }

  ngOnInit(): void {
  }

}
