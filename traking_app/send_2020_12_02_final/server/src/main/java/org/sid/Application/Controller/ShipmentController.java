package org.sid.Application.Controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sid.Application.Entities.Shipment;
import org.sid.Application.Entities.Shipment_status;
import org.sid.Application.Repository.ShipmentRepository;
import org.sid.Application.Repository.Shipment_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ShipmentController {

	@Autowired
	private ShipmentRepository ShipmentRepository;
	@Autowired
	private Shipment_statusRepository ShipmentStatusRepository;
    
	
	@PostMapping(value = "/addShipment")
	public ResponseEntity<Shipment> addPackage(@RequestBody Shipment newShipment) {
		Shipment shipmentAdded = ShipmentRepository.save(newShipment);

		if (shipmentAdded == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(shipmentAdded.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/shipments")
	public ResponseEntity<List<Shipment>> getAllshipments() {
		List<Shipment> shipments = ShipmentRepository.findAll();
		if (shipments.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(shipments, HttpStatus.OK);
	}

	@GetMapping(value = "/getShipmentById/{id}")
	public ResponseEntity<Shipment> getShipmentById(@PathVariable long id) {

		Optional<Shipment> shipment = ShipmentRepository.findById(id);
		if (shipment.isPresent())
			return new ResponseEntity<>(shipment.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	/*****************/
	/*    The function retrieve the list of statuses of each shipment which are sorted by their date of addition, giving as parameter the ourTrackingNumber    */
	/*    Example :  http://localhost:8081/GetShipmentStatus/OH4444444444     */
	/*****************/
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/GetShipmentStatus/{ourTrackingNumber}")
	public ResponseEntity<List<Shipment_status>> getShipmentStatus(@PathVariable String ourTrackingNumber) {
		Shipment shipment = ShipmentRepository.findByourTrackingNumber(ourTrackingNumber);
		if(shipment == null)
		{
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		long shipmentId = shipment.getId();
		List<Shipment_status> shipmentStatus = ShipmentStatusRepository.findStatusShipmentByIdOrderByDate(shipmentId);
		if (!shipmentStatus.isEmpty())
			return new ResponseEntity<>(shipmentStatus, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getShipmentByTrackingLink/{ourTrackingNumber}")
	public ResponseEntity<String> getShipmentByTrackingLink(@PathVariable String ourTrackingNumber) {

		Optional<String> TrackingLink = Optional
				.of(ShipmentRepository.findByourTrackingNumber(ourTrackingNumber).getCarrierTrackingLink());
		if (TrackingLink.isPresent())
			return new ResponseEntity<>(TrackingLink.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getShipmentByCustomer/{idCustomer}")
	public ResponseEntity<List<Shipment>> getShipmentByIdCustomer(@PathVariable long idCustomer) {
		List<Shipment> shipment = ShipmentRepository.findByidCustomer(idCustomer);
		if (!shipment.isEmpty())
			return new ResponseEntity<>(shipment, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getShipmentByCarrier/{idCarrier}")
	public ResponseEntity<List<Shipment>> getShipmentByCarrier(@PathVariable long idCarrier) {
		List<Shipment> shipment = ShipmentRepository.findByidCarrier(idCarrier);
		if (!shipment.isEmpty())
			return new ResponseEntity<>(shipment, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getShipmentByOurTrackingNumber/{ourTrackingNumber}")
	public ResponseEntity<Shipment> getShipmentByOurTrackingNumber(@PathVariable String ourTrackingNumber) {
		Optional<Shipment> shipment = Optional.of(ShipmentRepository.findByourTrackingNumber(ourTrackingNumber));
		if (shipment.isPresent())
			return new ResponseEntity<>(shipment.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getShipmentByCustomerAndByDate/{idCustomer}")
	@ResponseBody
	public ResponseEntity<List<Shipment>> getShipmentByCustomerAndByDate(@PathVariable long idCustomer, 
		@RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom, 
    	@RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo) {
		
		List<Shipment> shipments = ShipmentRepository.findByIdCustomerAndDate(idCustomer, dateFrom, dateTo);
		if (!shipments.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(shipments, HttpStatus.OK);
	}

	@GetMapping(value = "/getShipmentByCarrierAndByDate/{idCarrier}")
	@ResponseBody
	public ResponseEntity<List<Shipment>> getShipmentByCarrierAndByDate(@PathVariable long idCarrier,
			@RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom,
			@RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo) {
		List<Shipment> shipments = ShipmentRepository.findByIdCarrierAndDate(idCarrier, dateFrom, dateTo);
		if (!shipments.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(shipments, HttpStatus.OK);
	}

	@PatchMapping(value = "/updateShipment/{id}")
	public ResponseEntity<Shipment> updateShipment(@PathVariable long id, @RequestBody Shipment newShipment) {

		Optional<Shipment> shipment = ShipmentRepository.findById(id);
		if (!shipment.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		Shipment updateShipment = shipment.get();

		if (newShipment.getDateAdded() != null) {
			updateShipment.setDateAdded(newShipment.getDateAdded());
		}
		if (newShipment.getUpdateDate() != null) {
			updateShipment.setUpdateDate(newShipment.getUpdateDate());
		}
		if (newShipment.getOurTrackingNumber() != null) {
			updateShipment.setOurTrackingNumber(newShipment.getOurTrackingNumber());
		}
		if (newShipment.getCarrierTrackingLink() != null) {
			updateShipment.setCarrierTrackingLink(newShipment.getCarrierTrackingLink());
		}
		if (newShipment.getCarrierTrackingNumber() != null) {
			updateShipment.setCarrierTrackingNumber(newShipment.getCarrierTrackingNumber());
		}
		if (newShipment.getWeight() > 0) {
			updateShipment.setWeight(newShipment.getWeight());
		}
		if (newShipment.getDeliverySigned() != null) {
			updateShipment.setDeliverySigned(newShipment.getDeliverySigned());
		}
		if (newShipment.getIsOutOfFormat() != null) {
			updateShipment.setIsOutOfFormat(newShipment.getIsOutOfFormat());
		}
		if (newShipment.getAddressErros() != null) {
			updateShipment.setAddressErros(newShipment.getAddressErros());
		}
		if (newShipment.getIsAReturn() != null) {
			updateShipment.setIsAReturn(newShipment.getIsAReturn());
		}
		if (newShipment.getPackageId() != null) {
			updateShipment.setPackageId(newShipment.getPackageId());
		}
		if (newShipment.getIdDeliveryMethod() > 0) {
			updateShipment.setIdDeliveryMethod(newShipment.getIdDeliveryMethod());
		}
		if (newShipment.getIdCustomer() > 0) {
			updateShipment.setIdCustomer(newShipment.getIdCustomer());
		}
		if (newShipment.getIdCarrier() > 0) {
			updateShipment.setIdCarrier(newShipment.getIdCarrier());
		}
		if (newShipment.getShipmentBuyingPrice() > 0) {
			updateShipment.setShipmentBuyingPrice(newShipment.getShipmentBuyingPrice());
		}
		if (newShipment.getShipmentSellingPrice() > 0) {
			updateShipment.setShipmentSellingPrice(newShipment.getShipmentSellingPrice());
		}
		if (newShipment.getDeclaredValue() > 0) {
			updateShipment.setDeclaredValue(newShipment.getDeclaredValue());
		}
		if (newShipment.getCapAmount() > 0) {
			updateShipment.setCapAmount(newShipment.getCapAmount());
		}
		if (newShipment.getNumberOfArticles() > 0) {
			updateShipment.setNumberOfArticles(newShipment.getNumberOfArticles());
		}
		if (newShipment.getAdvaloremWarranty() != null) {
			updateShipment.setAdvaloremWarranty(newShipment.getAdvaloremWarranty());
		}
		if(newShipment.getCarrierName() != null) {
			updateShipment.setCarrierName(newShipment.getCarrierName());
		}

		/*
		 * if(newShipment.getCarrierTrackUrl() != null) {
		 * updateShipment.setCarrierTrackUrl(newShipment.getCarrierTrackUrl()); }
		 *///github.com/ouachani-Isslam/01_service_shipment.git

		ShipmentRepository.save(updateShipment);

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(value = "/deleteShipment/{id}")
	public ResponseEntity<HttpStatus> deletePackage(@PathVariable long id) {
		try {
			ShipmentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//for rate
	@CrossOrigin(value= "http://localhost:4200")
	@PostMapping(value = "/start-submission")
	public ResponseEntity<String> startSubmission() {
		String resp = "{\"signature\":\"20906f73717576667576663365313675707a766f73717576796864336b356d79696f34313339363936363463366336363533373434333536343134353337366237613339343233303664373236613737353935613431363436393336343833313336333033363338333033353333333433336563633361393131653961326665323230366533393562376162663165343763663731313333383365663263633363663638363431333239323566663738383831363036383035333433\",\"submission\":{\"response_id\":\"osquvfuvf3e16upzvosquvyhd3k5myio\",\"type\":\"started\",\"form_id\":\"zMGD7b\",\"landed_at\":1606805343,\"metadata\":{\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36\",\"platform\":\"other\",\"referer\":\"\",\"network_id\":\"41dede5aa9\",\"ip\":\"188.43.136.32\",\"browser\":\"default\"}}}";
		return new ResponseEntity<>(resp,HttpStatus.OK);
		
	}
	//for rate
	@CrossOrigin(value= "http://localhost:4200")
	@PostMapping(value = "/complete-submission")
	public ResponseEntity<String> completeSubmission() {
		String resp = "{\"response_id\":\"rc7htj93dw50ny22errc7htnerssm2fq\",\"type\":\"completed\",\"form_id\":\"zMGD7b\",\"landed_at\":1606809145,\"submitted_at\":1606809167,\"metadata\":{\"user_agent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36\",\"platform\":\"other\",\"referer\":\"https://cubyn.typeform.com/to/zMGD7b?tracking_number=CUB254229128\\u0026typeform-embed=popup-classic\\u0026typeform-embed-id=whtan\",\"network_id\":\"41dede5aa9\",\"ip\":\"188.43.136.32\",\"browser\":\"default\"},\"hidden\":[{\"key\":\"tracking_number\",\"value\":\"CUB254229128\"}],\"answers\":[{\"type\":\"number\",\"field\":{\"type\":\"rating\",\"id\":\"21246536\"},\"number\":4},{\"type\":\"number\",\"field\":{\"type\":\"rating\",\"id\":\"21246537\"},\"number\":4},{\"type\":\"number\",\"field\":{\"type\":\"rating\",\"id\":\"21246538\"},\"number\":4},{\"type\":\"number\",\"field\":{\"type\":\"rating\",\"id\":\"21246539\"},\"number\":4},{\"type\":\"number\",\"field\":{\"type\":\"rating\",\"id\":\"21246540\"},\"number\":4},{\"type\":\"number\",\"field\":{\"type\":\"rating\",\"id\":\"21246541\"},\"number\":4},{\"type\":\"text\",\"field\":{\"type\":\"long_text\",\"id\":\"21246542\"},\"text\":\"ddsd\"}]}";
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
}
