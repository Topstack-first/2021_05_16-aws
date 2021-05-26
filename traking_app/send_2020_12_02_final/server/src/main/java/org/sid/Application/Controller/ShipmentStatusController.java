package org.sid.Application.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.sid.Application.Entities.Shipment_status;
import org.sid.Application.Repository.Shipment_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class ShipmentStatusController {
  
	@Autowired
	private Shipment_statusRepository ShipmentStatusRepository;
	
	@PostMapping(value = "/addShipmentStatus")
	 public ResponseEntity<Shipment_status> addShipmentStatus(@RequestBody Shipment_status newShipmentStatus) {
		Shipment_status shipmentStatusAdded =  ShipmentStatusRepository.save(newShipmentStatus);

	        if (shipmentStatusAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(shipmentStatusAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	}
	 
	@GetMapping(value = "/getShipmentStatusById/{id}")
	 public ResponseEntity<Shipment_status> getShipmentStatusById(@PathVariable long id){
		 
		 Optional<Shipment_status> shipmentStatus = ShipmentStatusRepository.findById(id);
		 if(shipmentStatus.isPresent())
			 return new ResponseEntity<>(shipmentStatus.get(), HttpStatus.OK);
		 else
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 @PatchMapping(value = "/updateShipmentStatus/{id}")
		public ResponseEntity<Shipment_status> updateShipmentStatus(@PathVariable long id, @RequestBody Shipment_status newShipmentStatus) {
			
			Optional<Shipment_status> shipmentStatus = ShipmentStatusRepository.findById(id);
			if(!shipmentStatus.isPresent()) {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			}
			Shipment_status updateShipmentStatus = shipmentStatus.get();
			
			if(newShipmentStatus.getUpdateDateAndTime() != null ) {
				updateShipmentStatus.setUpdateDateAndTime(newShipmentStatus.getUpdateDateAndTime());
			}

			ShipmentStatusRepository.save(updateShipmentStatus);
			 
			return ResponseEntity.noContent().build();
	 }
	 @DeleteMapping(value = "/deleteShipmentStatus/{id}")
	 public ResponseEntity<HttpStatus> deleteShipmentStatus(@PathVariable long id){
		 try {
		      ShipmentStatusRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}
