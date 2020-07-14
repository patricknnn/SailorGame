import {trigger, animate, transition, style, query} from '@angular/animations';

export const fadeAnimation = trigger('fadeAnimation', [
  transition('* => *', [
    query(':enter mat-card',
      [
        style({opacity: 0}),
        animate('0.25s', style({opacity: 1}))
      ],
      {optional: true}
    )
  ])
]);
