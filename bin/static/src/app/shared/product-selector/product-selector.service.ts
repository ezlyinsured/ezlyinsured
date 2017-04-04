import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { TypedJSON } from 'typedjson-npm/src/typed-json';

import { ProductSelector } from './product-selector';

@Injectable()
export class ProductSelectorService {
        
 constructor(private http: Http) { }

    
 getProductSelector(productId:number): Promise<ProductSelector> {
    return this.http.get('/product-selector/'+productId).toPromise()
        .then(response =>  
            TypedJSON.parse(response.json(), ProductSelector)
        )
        .catch(this.handleError);
 }
  
 private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
 }

}