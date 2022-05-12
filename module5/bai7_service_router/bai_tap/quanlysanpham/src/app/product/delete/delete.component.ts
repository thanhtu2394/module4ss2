import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router, RouterLink, RouterLinkActive} from '@angular/router';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  private id: number;

  constructor(private service: ProductService, private reactived: ActivatedRoute, private routet: Router) {
  }

  ngOnInit(): void {
    this.id = +this.reactived.snapshot.paramMap.get('id');
    this.service.deleteProduct(this.id);
    this.routet.navigateByUrl('product/list');
  }

}
