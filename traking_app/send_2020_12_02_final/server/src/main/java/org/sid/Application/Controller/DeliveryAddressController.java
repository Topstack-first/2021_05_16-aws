package org.sid.Application.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.sid.Application.Entities.DeliveryAddress;
import org.sid.Application.Repository.DeliveryAddressRepository;
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
public class DeliveryAddressController {

	@Autowired
	private DeliveryAddressRepository deliveryAddressRepository;

	@PostMapping(value = "/addDeliveryAddress")
	public ResponseEntity<DeliveryAddress> addDeliveryAddress(@RequestBody DeliveryAddress newDeliveryAddress) {
		DeliveryAddress deliveryAddressAdded = deliveryAddressRepository.save(newDeliveryAddress);

		if (deliveryAddressAdded == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(deliveryAddressAdded.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/addresses")
	public ResponseEntity<List<DeliveryAddress>> getAllAddresses() {
		List<DeliveryAddress> addresses = deliveryAddressRepository.findAll();
		if (addresses.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(addresses, HttpStatus.OK);
	}

	@GetMapping(value = "/getAddressById/{id}")
	public ResponseEntity<DeliveryAddress> getAddressById(@PathVariable long id) {

		Optional<DeliveryAddress> address = deliveryAddressRepository.findById(id);
		if (address.isPresent())
			return new ResponseEntity<>(address.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping(value = "/updateAddress/{id}")
	public ResponseEntity<DeliveryAddress> updateAddress(@PathVariable long id,
			@RequestBody DeliveryAddress newAddress) {

		Optional<DeliveryAddress> address = deliveryAddressRepository.findById(id);
		if (!address.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		DeliveryAddress updateAddress = address.get();

		if (newAddress.getCompanyName() != null) {
			updateAddress.setCompanyName(newAddress.getCompanyName());
		}
		if (newAddress.getLastName() != null) {
			updateAddress.setLastName(newAddress.getLastName());
		}

		if (newAddress.getFirstName() != null) {
			updateAddress.setFirstName(newAddress.getFirstName());
		}
		if (newAddress.getAddress1() != null) {
			updateAddress.setAddress1(newAddress.getAddress1());
		}
		if (newAddress.getAddress2() != null) {
			updateAddress.setAddress2(newAddress.getAddress2());
		}

		/*
		 * if (newAddress.getAddress3() != null) {
		 * updateAddress.setAddress3(newAddress.getAddress3()); }
		 */
		if (newAddress.getPostCode() != null) {
			updateAddress.setPostCode(newAddress.getPostCode());
		}
		if (newAddress.getCity() != null) {
			updateAddress.setCity(newAddress.getCity());
		}
		if (newAddress.getPhone() != null) {
			updateAddress.setPhone(newAddress.getPhone());
		}
		if (newAddress.getPhone() != null) {
			updateAddress.setPhone(newAddress.getPhone());
		}

		if (newAddress.getOther() != null) {
			updateAddress.setOther(newAddress.getOther());
		}
		if (newAddress.getDateAdded() != null) {
			updateAddress.setDateAdded(newAddress.getDateAdded());
		}
		if (newAddress.getUpdateDate() != null) {
			updateAddress.setUpdateDate(newAddress.getUpdateDate());
		}

		deliveryAddressRepository.save(updateAddress);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/deleteAdrress/{id}")
	public ResponseEntity<HttpStatus> deleteAddress(@PathVariable long id) {
		try {
			deliveryAddressRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
