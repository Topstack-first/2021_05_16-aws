package org.sid.Application.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Countries {
   
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String countryName;
	private String isoCode;
	private String callPrefix;
	@JsonIgnore
	@OneToMany(mappedBy="countryId")
	private List<DeliveryAddress> DeliveryAddress;
	
	
}
