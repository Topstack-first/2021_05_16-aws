package org.sid.Application.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.sid.Application.Entities.Countries;
import org.sid.Application.Repository.CountryRepository;
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
public class CountryController {

	@Autowired
	private CountryRepository countriesRepository;

	@PostMapping(value = "/addCountry")
	public ResponseEntity<Countries> addCountry(@RequestBody Countries newCountry) {
		Countries countryAdded = countriesRepository.save(newCountry);

		if (countryAdded == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(countryAdded.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/countries")
	public ResponseEntity<List<Countries>> getAllCountries() {
		List<Countries> countries = countriesRepository.findAll();
		if (countries.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

	@GetMapping(value = "/getCountryById/{id}")
	public ResponseEntity<Countries> getCountryById(@PathVariable long id) {

		Optional<Countries> country = countriesRepository.findById(id);
		if (country.isPresent())
			return new ResponseEntity<>(country.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping(value = "/updateCountry/{id}")
	public ResponseEntity<Countries> updateCountry(@PathVariable long id, @RequestBody Countries newCountry) {

		Optional<Countries> country = countriesRepository.findById(id);
		if (!country.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		Countries updateCountry = country.get();

		if (newCountry.getCountryName() != null) {
			updateCountry.setCountryName(newCountry.getCountryName());
			;
		}
		if (newCountry.getIsoCode() != null) {
			updateCountry.setIsoCode(newCountry.getIsoCode());
			;
		}

		countriesRepository.save(updateCountry);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/deleteCountry/{id}")
	public ResponseEntity<HttpStatus> deleteCountry(@PathVariable long id) {
		try {
			countriesRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
