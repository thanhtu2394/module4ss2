import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Istudent1} from '../../model/Istudent';

@Component({
  selector: 'app-demo-angular',
  templateUrl: './demo-angular.component.html',
  styleUrls: ['./demo-angular.component.css']
})
export class DemoAngularComponent implements OnInit {
  @Input() std: Istudent1;
 @Output() onchanstd: EventEmitter<any> = new EventEmitter<any>();
  constructor() {
  }

  ngOnInit(): void {
    this.onchanstd.emit("ccccccc");
  }

}
