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
public class Pakage {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long idPacking;
	private String packingRef;
	private int quantity;
	private Boolean active;
	private Boolean delete;
	private double height;
	private double width;
	private double depth;
	private double weight;
	private double tapeLength;
	private int tapeNumber;
	private String supplierReference;
	private long idSupplier;
	@JsonIgnore
	@OneToMany(mappedBy="packageId")
	private List<Shipment> shipment;
	
	

}
