import { Component, OnInit } from '@angular/core';;
import {interval} from 'rxjs';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  index = 0;
  invervalID = 0;
  constructor() { }

  ngOnInit(): void {
  }
  loading() {
    this.invervalID = setInterval(() => {
      this.index = +this.index + 1 ;
    }, 1000);
}
reset(){
    this.index = 0;
    clearInterval(this.invervalID);
}
stop() {
  clearInterval(this.invervalID) ;
}
}
