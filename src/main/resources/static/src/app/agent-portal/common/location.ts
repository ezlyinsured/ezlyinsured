import { Input, Output }     from '@angular/core';

export class Location{
    private _lng:String;
    private _lat:String;

    set lng(lng:String){
        this._lng = lng;
    }

    get lng():String{
        return this._lng;
    }


    set lat(lat:String){
        this._lat = lat;
    }

    get lat():String{
        return this._lat;
    }
}