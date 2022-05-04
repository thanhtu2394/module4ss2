import { Component, OnInit } from '@angular/core';
import {Istudent1} from '../../model/Istudent';
import {Studentarray} from '../../model/studentarray';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  studentlist: Istudent1[] = Studentarray.array;
student : Istudent1;
chaneDetail : any ;



  constructor() { }

  ngOnInit(): void {
  }

  takeStuden(student1: any) {
    this.student = student1;
  }

  chanedetail(chane : any) {
    this.chaneDetail = chane;
  }
}
