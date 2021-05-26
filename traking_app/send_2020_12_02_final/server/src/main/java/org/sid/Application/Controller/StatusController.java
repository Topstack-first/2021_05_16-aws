package org.sid.Application.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.sid.Application.Entities.Status;
import org.sid.Application.Repository.StatusRepository;
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
public class StatusController {
   
	@Autowired
	private StatusRepository StatusRepository;
	
	@PostMapping(value = "/addStatus")
	 public ResponseEntity<Status> addPackage(@RequestBody Status newStatus) {
		Status statusAdded =  StatusRepository.save(newStatus);

	        if (statusAdded == null)
	            return ResponseEntity.noContent().build();

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(statusAdded.getId())
	                .toUri();

	        return ResponseEntity.created(location).build();
	}
	@GetMapping(value = "/status")
		public ResponseEntity<List<Status>> getAllStatus(){
			 List<Status> status = StatusRepository.findAll();
			  if(status.isEmpty())
				  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  return new ResponseEntity<>(status, HttpStatus.OK);  
	}
	@GetMapping(value = "/getStatusById/{id}")
	 public ResponseEntity<Status> getStatusById(@PathVariable long id){
		 
		 Optional<Status> status = StatusRepository.findById(id);
		 if(status.isPresent())
			 return new ResponseEntity<>(status.get(), HttpStatus.OK);
		 else
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 @PatchMapping(value = "/updateStatus/{id}")
		public ResponseEntity<Status> updateStatus(@PathVariable long id, @RequestBody Status newStatus) {
			
			Optional<Status> status = StatusRepository.findById(id);
			if(!status.isPresent()) {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			}
			Status updateStatus = status.get();
			
			if(newStatus.getShipmentStatusName() != null ) {
				updateStatus.setShipmentStatusName(newStatus.getShipmentStatusName());
			}

			StatusRepository.save(updateStatus);
			 
			return ResponseEntity.noContent().build();
	 }
	 @DeleteMapping(value = "/deleteStatus/{id}")
	 public ResponseEntity<HttpStatus> deleteStatus(@PathVariable long id){
		 try {
		      StatusRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}
