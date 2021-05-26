import * as $ from 'jquery' ;
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rate-page',
  templateUrl: './rate-page.component.html',
  styleUrls: ['./rate-page.component.scss']
})
export class RatePageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $("#rate-form").hide();
  }
  public closeTypeform()
  {
    $("#rate-form").hide();
  }
  public openTypeform()
  {
    $("#rate-form").show();
    $("#spinner").show();
    $("#rate-info").hide();
    setTimeout(function(){
      $("#spinner").hide();
      $("#rate-info").show();
    },2000);
    
  }
}
