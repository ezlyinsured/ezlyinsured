import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';
//import {Location} from './../common/location'

@Injectable()
export class HomeMapService{

    private url:String = "http://maps.googleapis.com/maps/api/geocode/json?address=";
    constructor (private http: Http) {

    }

    public getLocalPosition( zipCode:String):Promise<any>{
        return this.http.get(this.url+""+zipCode).toPromise().then((res:Response) => res.json());
    }
}