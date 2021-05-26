import * as $ from 'jquery' ;
import { Component, OnInit, ViewChild,ViewChildren,ComponentFactoryResolver, ViewContainerRef, ComponentFactory, ComponentRef, ElementRef } from '@angular/core';
import { HttpClient} from '@angular/common/http';



@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.scss'],
  providers: [ HttpClient]
})

export class PagesComponent implements OnInit { 
  //define variables
  private REST_API_SERVER = "http://localhost:8081";
  public  shipmentStatuses = [];

  public  labelShipment_number:string="Shipment Number";
  public  trackingNumber:string = ""; 

  public labelFollowYourShipment:string = "FOLLOW YOUR SHIPMENT";
  public followYourShipmentStatus:string = "delivered";

  public progShippingInfomationReceived:string = "Order being fulfilled";
  public prgInTransit:string = "In transit";
  public progOutForDelivery:string = "In delivering";
  public progRelayPoint:string = "Relay point";
  public progDelivered:string = "Delivered";

  public statusMessage:string = "Delivered at";
  public statusDate:string = "Tuesday, June 23";
  public statusTime:string = "9:34 AM";
  public statusErrorMessage:string = "Unfortunately, no shipment was found with this number. Check your input and try again."

  public isOutForDelivery:boolean = true;

  public days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];

  public hideDetails = true;

  public labelHideShowDetails:string = "Show details";

  public languageMap = new Map();
  public languageSetting:string = "en-BE";

  public carrierTrackButtonText:string = "Shipment tracking";
  public carrierTrackText:string = "Click here to track your shipment on the shipment provider's website";
  public rateButtonText:string = "Rate your shipment";
  public rateText:string = "Once delivered, you will be able to rate the delivery of your shipment as well as the quality of the packaging";

  public carrierUrl:string = "#";
  public isDelivered:boolean = false;

  constructor(private factoryResolver: ComponentFactoryResolver,
              private https: HttpClient)
  { 

    this.languageMap.set("Shipment tracking","Suivi transporteur");
    this.languageMap.set("Click here to track your shipment on the shipment provider's website","Cliquez ici pour suivre votre colis sur le site du transporteur");
    this.languageMap.set("Rate your shipment","Notez votre expédition");
    this.languageMap.set("Once delivered, you will be able to rate the delivery of your shipment as well as the quality of the packaging","Une fois livré, vous aurez la possibilité de noter la livraison et l'emballage de votre colis");

    this.languageMap.set("Show details","Afficher les détails");
    this.languageMap.set("Hide details","Masquer les détails");
    
    this.languageMap.set("Monday","Lundi");
    this.languageMap.set("Tuesday","Mardi");
    this.languageMap.set("Wednesday","Mercredi");
    this.languageMap.set("Thursday","Jeudi");
    this.languageMap.set("Friday","Vendredi");
    this.languageMap.set("Saturday","Samedi");
    this.languageMap.set("Sunday","Dimanche");

    this.languageMap.set("Delivered","livré");
    this.languageMap.set("FOLLOW YOUR SHIPMENT","SUIVEZ VOTRE ENVOI");
    this.languageMap.set("Shipment Number","Numéro de suivi");
    this.languageMap.set("Order being fulfilled","Colis en cours de préparation");
    this.languageMap.set("In transit","En cours d'acheminement");
    this.languageMap.set("In delivering","En cours de livraison");
    this.languageMap.set("Relay point","Point relais");
    this.languageMap.set("Available at Point Relais","Disponible au Point Relais");
    this.languageMap.set("Out for delivery","En cours de livraison");
    this.languageMap.set("Delivered at","LIVRÉ À");
    this.languageMap.set("Unfortunately, no shipment was found with this number. Check your input and try again.","Aucune expédition trouvée avec ce numéro. vérifiez votre entrée et essayer à nouveau.");

    this.languageMap.set("There was a problem with your shipment before it was delivered to the partner carrier. X informs you in real time by e-mail","Il y'a eu un problème avec votre envoi avant sa remise au transporteur partenaire. X vous en informe en temps réels par e-mail");
    this.languageMap.set("Incorrect address","Adresse incorrecte");
    this.languageMap.set("Content received damaged","Contenu reçu endommagé");
    this.languageMap.set("Off-format content","Contenus hors format");
    this.languageMap.set("Shipment ready to be picked up by","Colis prêt à être pris en charge par");
    this.languageMap.set("The shipment was sent by X","Le colis a été expédié par X");
    this.languageMap.set("Your shipment has arrived at its distribution site","Votre colis est arrivé sur son site de distribution");
    this.languageMap.set("Your shipment is ready for delivery and awaiting delivery","Votre colis est prêt à être livré et en attente de livraison");
    this.languageMap.set("There is a problem during the delivery of the shipment","Il y a un problème durant l'acheminement du colis");
    this.languageMap.set("Wrong / incomplete address","Adresse erronée/incomplète");
    this.languageMap.set("Damaged package","Colis endommagé");
    this.languageMap.set("Return request issued","Demande de retour émise");
    this.languageMap.set("Missing customs documents","Documents de douanes manquants");
    this.languageMap.set("Your shipment is available at a collection point. Find his address in your carrier tracking","Votre colis est disponible en point de retrait. Retrouvez son adresse dans votre suivi transporteur");
    this.languageMap.set("Delivery to recipient failed","La livraison au destinataire a échoué");
    this.languageMap.set("The address is incorrect / inaccessible","L'adresse est incorrecte/inaccessible");
    this.languageMap.set("The recipient is absent","Le destinataire est absent");
    this.languageMap.set("No mention of the recipient's name is made at the address indicated","Aucune mention du nom du destinataire n'est faite à l'adresse indiquée");
  }
  ngOnInit()
  {
    this.hideAll();
    var lan = localStorage.getItem("lan");
    if(lan == null)
    {
      this.languageSetting = "en-BE";
      localStorage.setItem("lan",this.languageSetting);
    }
    else{
      this.languageSetting = lan;
    }
    if(this.languageSetting == "en-BE")
    {
      $("#en-1").attr("style","color:gray;");
      $("#en-2").attr("style","color:gray;");
      $("#fr-1").attr("style","color:black;");
      $("#fr-2").attr("style","color:black;");
    }
    else{
      $("#en-1").attr("style","color:black;");
      $("#fr-1").attr("style","color:gray;");
      $("#en-2").attr("style","color:black;");
      $("#fr-2").attr("style","color:gray;");
    }
    this.changeAllStrings();
    
  }
  //change language
  public changeLanguageToEN()
  {
    this.changeLanguage("en-BE");
  }
  public changeLanguageToFR()
  {
    this.changeLanguage("fr-BE");
  }
  private changeLanguage(lan:string)
  {
    this.languageSetting = lan;
    localStorage.setItem("lan",this.languageSetting);
    if(this.languageSetting == "en-BE")
    {
      $("#en-1").attr("style","color:gray;");
      $("#en-2").attr("style","color:gray;");
      $("#fr-1").attr("style","color:black;");
      $("#fr-2").attr("style","color:black;");
    }
    else{
      $("#en-1").attr("style","color:black;");
      $("#fr-1").attr("style","color:gray;");
      $("#en-2").attr("style","color:black;");
      $("#fr-2").attr("style","color:gray;");
    }
    this.changeAllStrings();
    if(this.trackingNumber == "")
    {
      this.hideAll();
      return;
    }
    if(this.shipmentStatuses.length > 0)
    {
      this.showShipmentStatus();
    }
    else{
      this.showErrorTrackingNumber();
    }
    
  }
  public changeAllStrings()
  {
    this.labelShipment_number = this.getMapString(this.labelShipment_number);
    this.labelFollowYourShipment = this.getMapString(this.labelFollowYourShipment);
    this.followYourShipmentStatus = this.getMapString(this.followYourShipmentStatus);
    this.progShippingInfomationReceived = this.getMapString(this.progShippingInfomationReceived);
    this.prgInTransit = this.getMapString(this.prgInTransit);
    this.progOutForDelivery = this.getMapString(this.progOutForDelivery);
    this.progRelayPoint = this.getMapString(this.progRelayPoint);
    this.progDelivered = this.getMapString(this.progDelivered);
    this.statusMessage = this.getMapString(this.statusMessage);
    this.statusErrorMessage = this.getMapString(this.statusErrorMessage);
    this.labelHideShowDetails = this.getMapString(this.labelHideShowDetails);
    this.carrierTrackButtonText = this.getMapString(this.carrierTrackButtonText);
    this.carrierTrackText = this.getMapString(this.carrierTrackText);
    this.rateButtonText = this.getMapString(this.rateButtonText);
    this.rateText = this.getMapString(this.rateText);

    if(this.shipmentStatuses.length > 0)
    {
      this.showShipmentStatus();
    }
  }
  //convert en->fr, fr->en
  public getMapString(str:string)
  {
    var result:any = "";
    result = this.languageMap.get(str);
    if(result != "" && result != null )
    {
      if(this.languageSetting == "fr-BE")
      {
        return result;
      }
      else{
        return str;
      }
    }
    result = str;
    this.languageMap.forEach((val:string,key:string)=>{
        if(str == val)
        {
          result = key;
        }
      });
      if(this.languageSetting == "fr-BE")
      {
        return str;
      }
      else{
        return result;
      }
  }
  public getShipmentStatuses()
  {
    
    this.https.get(this.REST_API_SERVER+"/GetShipmentStatus/"+this.trackingNumber).subscribe((data: any[])=>{
      if(data == null)
      {
        this.showErrorTrackingNumber();
      }
      else{
        this.shipmentStatuses = data;
        this.showShipmentStatus();
      }
    });
  }
  public hideAll()
  {
    $("#progressbar").hide();
    $("#progressbar-label").hide();
    $("#status-msg").hide();
    $("#details").attr("class","");
    $("#status-error").hide();
    $("#trackrate").hide();
  }
  //there is no traking number
  public showErrorTrackingNumber()
  {
    $("#progressbar").hide();
    $("#progressbar-label").hide();
    $("#status-msg").hide();
    $("#details").attr("class","");
    $("#status-error").show();
    $("#trackrate").hide();
  }
  public hideShowDetails()
  {
    if(!this.hideDetails)
    {
      $("#hide-details-button").attr("class","styles__toggle-button___1uwMe styles__details-shown___2RLer");
      $("#details-list").show();
      this.labelHideShowDetails = this.getMapString("Hide details");
    }
    else{
      $("#hide-details-button").attr("class","styles__toggle-button___1uwMe");
      $("#details-list").hide();
      this.labelHideShowDetails = this.getMapString("Show details");
    }
    this.hideDetails = !this.hideDetails;
  }
  
  //shows all shipment info
  public showShipmentStatus()
  {
    //init add-items
    $("div[id=added-item]").remove();

    //progress bar status
    this.followYourShipmentStatus = this.getMapString(this.shipmentStatuses[this.shipmentStatuses.length-1].statusId.shipmentStatusName);
    
    //set carrier button link
    this.carrierUrl = this.shipmentStatuses[this.shipmentStatuses.length-1].shipmentId.carrierTrackingLink;
    this.isDelivered = false;
    
    //define progress item's id
    var announceId = 1;
    var inTransitId = 8;
    var outForDeliveryId = 16;
    var relayPointId = 17;
    var deliveredId = 22;

    //initiate progress bar
    $("#shipping-info-received div:first").attr("class","styles__icon___5io2w");
    $("#in-transit div:first").attr("class","styles__icon___5io2w");
    $("#in-transit-line").attr("class","styles__line___rtDSs");
    $("#out-for-delivery div:first").attr("class","styles__icon___5io2w");
    $("#out-for-delivery-line").attr("class","styles__line___rtDSs");
    //$("#relay-point div:first").attr("class","styles__icon___5io2w");
    //$("#relay-point-line").attr("class","styles__line___rtDSs");
    //$("#relay-point").hide();
    $("#delivered div:first").attr("class","styles__icon___5io2w");
    $("#delivered-line").attr("class","styles__line___rtDSs");

    //shows progress
    
    var maxId = 0;
    this.shipmentStatuses.forEach((shipmentStatus:any,index:Number,shipments)=>{
      maxId = maxId > shipmentStatus.statusId.id ? maxId : shipmentStatus.statusId.id;
      
    });
    var relayPointExist = false;
    if(this.shipmentStatuses[0].shipmentId.idDeliveryMethod == 3)
    {
      relayPointExist = true;
      this.progOutForDelivery = this.getMapString("Available at Point Relais");
      $("#out-for-delivery-svg").html('<path d="M10,1.375c-3.17,0-5.75,2.548-5.75,5.682c0,6.685,5.259,11.276,5.483,11.469c0.152,0.132,0.382,0.132,0.534,0c0.224-0.193,5.481-4.784,5.483-11.469C15.75,3.923,13.171,1.375,10,1.375 M10,17.653c-1.064-1.024-4.929-5.127-4.929-10.596c0-2.68,2.212-4.861,4.929-4.861s4.929,2.181,4.929,4.861C14.927,12.518,11.063,16.627,10,17.653 M10,3.839c-1.815,0-3.286,1.47-3.286,3.286s1.47,3.286,3.286,3.286s3.286-1.47,3.286-3.286S11.815,3.839,10,3.839 M10,9.589c-1.359,0-2.464-1.105-2.464-2.464S8.641,4.661,10,4.661s2.464,1.105,2.464,2.464S11.359,9.589,10,9.589"></path>');
    }
    else{
      this.progOutForDelivery = this.getMapString("Out for delivery");
      $("#out-for-delivery-svg").html('<path d="M18.94 8.948v-.1c.005-2.5.007-5.086-1.758-6.856C15.844.652 13.672 0 10.547 0 7.42 0 5.25.65 3.912 1.992 2.147 3.762 2.15 6.346 2.154 8.846v.078C.874 9.226 0 10.4 0 11.934c0 1.795.972 2.898 2.69 3.094 1.393 4.22 4.233 6.628 7.857 6.628 2.015 0 3.853-.792 5.315-2.292 1.342-1.377 2.115-3.053 2.55-4.364C20.04 14.793 21 13.68 21 11.934c0-1.497-.83-2.65-2.06-2.986zm-1.527.242c0 .752-.124 1.027-.176 1.11-.027.042-.044.067-.187.067-.41 0-1.12-.276-1.872-.568-1.278-.498-2.868-1.117-4.63-1.117s-3.353.62-4.632 1.116c-.753.29-1.462.567-1.87.567-.146 0-.162-.025-.188-.067-.054-.083-.176-.358-.176-1.11v-.16c.612-.06 1.347-.298 2.182-.566 1.318-.424 2.957-.95 4.683-.95s3.367.526 4.684.95c.835.267 1.57.503 2.183.564v.162zM4.99 3.07C6.03 2.034 7.847 1.53 10.547 1.53s4.517.505 5.554 1.543c1.217 1.22 1.308 3.158 1.313 5.25-.525-.065-1.202-.28-1.967-.527-1.365-.438-3.063-.984-4.9-.984-1.836 0-3.534.544-4.9.983-.764.246-1.44.462-1.966.527.003-2.092.095-4.03 1.31-5.25zm12.847 10.436h-.574l-.16.55c-.41 1.425-2.098 6.07-6.556 6.07-4.32 0-6.02-4.23-6.55-6.046l-.16-.55h-.573c-1.234 0-1.736-.463-1.736-1.6 0-.567.212-1.21.772-1.456.253.943.837 1.42 1.746 1.42.695 0 1.497-.313 2.425-.673 1.22-.473 2.603-1.01 4.08-1.01 1.474 0 2.856.537 4.076 1.01.928.363 1.73.673 2.425.673.896 0 1.475-.462 1.736-1.38.498.27.688.878.688 1.418-.003 1.09-.507 1.576-1.637 1.576zm-10.22-1.74c-.577 0-1.044.468-1.044 1.045 0 .578.467 1.045 1.044 1.045.576 0 1.044-.467 1.044-1.044 0-.576-.467-1.043-1.043-1.043zm5.752 0c-.578 0-1.045.468-1.045 1.045 0 .578.467 1.045 1.044 1.045.576 0 1.043-.467 1.043-1.044 0-.576-.467-1.043-1.044-1.043z"></path>');
    }
    if(maxId >= announceId)
    {
      $("#shipping-info-received div:first").attr("class","styles__icon___5io2w styles__active___1A2BM");
    }
    if(maxId >= inTransitId)
    {
      $("#in-transit div:first").attr("class","styles__icon___5io2w styles__active___1A2BM");
      $("#in-transit-line").attr("class","styles__line___rtDSs styles__filled___BV_vL");
    }
    if(maxId >= outForDeliveryId && !relayPointExist)
    {
      $("#out-for-delivery div:first").attr("class","styles__icon___5io2w styles__active___1A2BM");
      $("#out-for-delivery-line").attr("class","styles__line___rtDSs styles__filled___BV_vL");
      
    }
    else if(maxId >= relayPointId && relayPointExist)
    {
      $("#out-for-delivery div:first").attr("class","styles__icon___5io2w styles__active___1A2BM");
      $("#out-for-delivery-line").attr("class","styles__line___rtDSs styles__filled___BV_vL");
      
    }
    if(maxId >= deliveredId)
    {
      $("#delivered div:first").attr("class","styles__icon___5io2w styles__active___1A2BM");
      $("#delivered-line").attr("class","styles__line___rtDSs styles__filled___BV_vL");
      
      this.isDelivered = true;
    }
    

    //current status message
    this.statusMessage = this.getMapString(this.shipmentStatuses[this.shipmentStatuses.length-1].statusId.shipmentStatusName);
    var date = new Date(this.shipmentStatuses[this.shipmentStatuses.length-1].updateDateAndTime);
    this.statusDate = this.getMapString(this.days[date.getDay()])+", "+(date.getMonth()+1)+"/"+ date.getDate()+"/"+date.getFullYear();
    this.statusTime = date.getHours()+":"+date.getMinutes();

    //shows detail info
    this.hideDetails = true;
    this.hideShowDetails();
    //construct detail list
    for(var index = 1; index < 23;index++)
    {
      $("#detail-"+index).attr("style","content-visibility:hidden");
    }
    var prev_statusId = 0;
    for(var index = 0; index < this.shipmentStatuses.length; index++)
    {
      var statusId = this.shipmentStatuses[index].statusId.id;
      var parent = this.shipmentStatuses[index].statusId.parent;
      var updateDateAndTime = this.shipmentStatuses[index].updateDateAndTime;
      var shipmentStatusName = this.shipmentStatuses[index].statusId.shipmentStatusName;
      shipmentStatusName = this.getMapString(shipmentStatusName);
      if(statusId == 6)
      {
        shipmentStatusName = shipmentStatusName+" <b>"+this.shipmentStatuses[index].shipmentId.carrierName+"</b>";
      }
      var date = new Date(updateDateAndTime);
      updateDateAndTime = this.getMapString(this.days[date.getDay()])+", "+(date.getMonth()+1)+"/"+ date.getDate()+" " +date.getHours()+":"+date.getMinutes();
      
      
      //parent Exist?
      var parentExist = false;
      this.shipmentStatuses.forEach((shipmentStatus,index,arr)=>{
        if(parent != null && shipmentStatus.statusId.id == parent.id)
        {
          parentExist = true;
        }
      });
      if(parentExist)
      {
        shipmentStatusName = this.getMapString(parent.shipmentStatusName)+"<br><b>"+shipmentStatusName+"</b>"
      }
      //repeat Element
      //if(prev_statusId == statusId)
      //{
      var newElement = $("#detail-"+statusId).clone(true);
      var children = newElement.children();
      children[1].innerHTML = shipmentStatusName;
      children[2].innerText = updateDateAndTime;
      newElement.attr("id","added-item");
      if(index == 0)
      {
        $("#detail-1").after(newElement);
      }
      else if(index == this.shipmentStatuses.length-1)
      {
        $("#detail-22").before(newElement);
      }
      else{
        $("#detail-22").after(newElement);
      }
      
      newElement.attr("style","");
        
      //}
      //else{
      //  $("#detail-"+statusId).attr("style","");
      //  $("#detail-"+statusId+" div:nth-of-type(2)").html(shipmentStatusName);
      //  $("#detail-"+statusId+" div:nth-of-type(3)").text(updateDateAndTime);
      //}
      prev_statusId = statusId;
    }

    $("#progressbar").show();
    $("#progressbar-label").show();
    $("#status-msg").show();
    $("#details").attr("class","styles__shown___1rRlv");
    $("#status-error").hide();
    $("#trackrate").show();

    
  }
  public showRateForm()
  {
    if(!this.isDelivered)
    {
      return;
    }
    $("#rate-form").show();
    $("#spinner").show();
    $("#rate-info").hide();
    if(this.languageSetting == "en-BE")
    {
      $("#iframe").attr("src","/assets/libs/track-and-trace/rate_en.html");
    }
    else{
      $("#iframe").attr("src","/assets/libs/track-and-trace/rate_fr.html");
    }
    setTimeout(function(){
      $("#spinner").hide();
      $("#rate-info").show();
    },2000);
    
  }
  
}
