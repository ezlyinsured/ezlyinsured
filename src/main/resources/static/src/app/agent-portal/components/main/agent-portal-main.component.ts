import {Component, Input,Output} from '@angular/core';
import { Router, ActivatedRoute}   from '@angular/router';
import { AngularFire,FirebaseObjectObservable,FirebaseListObservable  } from 'angularfire2';
import {HomeMapService} from './../../services/home-map.service'
//import { LoginService} from './login.service';
import { User} from '../../../shared/model/user';

@Component({
    selector: 'agent-portal-main',
    styleUrls:['./styles/main.css'],
    templateUrl: './templates/main.html',
    
    

})

export class AgentPortalMainComponent{
  @Input() @Output() userName:String;
  @Input() @Output() userPhoto:String;
  @Input() @Output() yourIconUrl:String;
  @Input() @Output() points:any[]=[];
  @Output() clients:Number=0;

  userInfo:FirebaseObjectObservable<any>;
  clientsInfo:FirebaseListObservable<any[]>;

  title: string = 'My first angular2-google-maps project';
  lat: number = 0;
  lng: number = 0;


  private user ={};
  constructor(public af:AngularFire, private router: Router, private homeMapService:HomeMapService ){
       var aut = af.auth.subscribe(
           user => this.updateInfoUser(user),
           error => console.trace(error)
       );       
       this.yourIconUrl = "/assets/imgs/home-location-marker.png";
       
       //this.points.push({lat:42.2575459,lng:-71.1665028});
  } 

  updateInfoUser(user:any){
        console.log(user);
        this.userInfo = this.af.database.object('agents/'+user.uid);
        this.clientsInfo = this.af.database.list('activeUsers');
        this.clientsInfo.subscribe(snapshot=>{this.updatePoints(snapshot)});
        this.userInfo.subscribe(snapshot=>{this.updateAgentLocation(snapshot)});
        this.userName = user.auth.displayName;
        this.userPhoto = user.auth.photoURL;
  }

  logout(event){
      this.userInfo.remove();
      this.af.auth.logout().then((any)=>{this.router.navigateByUrl("agent-portal/login/1");});
  }

  mostrar(obj){
    let location = obj.results[0].geometry.location;
    this.lng = location.lng;
    this.lat = location.lat;
    this.points.push({lat:42.2575459,lng:-71.1665028});
    //this.points.length
    //console.log(this.points);
  }
  showPoints(obj){
    let location = obj.results[0].geometry.location;
    this.points.push({lat:location.lat,lng:location.lng});
    //this.points.length
    //console.log(this.points);
  }
  updateAgentLocation(result:any){
      this.homeMapService.getLocalPosition(result.zipcode).then(value=>this.mostrar(value));
  }

  updatePoints(users:any[]){
      this.points = [];
      users.forEach(item=>{
        this.homeMapService.getLocalPosition(item.zipcode).then(value=>this.showPoints(value));      
      })
      
      console.log(users);
  }
}