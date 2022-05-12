import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, ParamMap, Router, RouterLink} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  productForm: FormGroup;
  id: number;
  constructor(private service: ProductService,
              private active: ActivatedRoute, private router: Router) {
      this.id = +this.active.snapshot.paramMap.get('id');
      const product = this.getProduct(this.id);
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
      });
    }
  ngOnInit(): void {
  }
  getProduct(id: number) {
    return this.service.findById(id);
  }

  updateProduct(id: number) {
    const product = this.productForm.value;
    this.service.updateProduct(id, product);
    this.router.navigateByUrl('/product/list');
  }
}
