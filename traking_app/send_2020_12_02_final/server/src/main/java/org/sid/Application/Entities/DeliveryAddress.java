package org.sid.Application.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {
     
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 private String companyName;
	 private String lastName;
	 private String firstName;
	 private String address1;
	 private String Address2;
	 private String postCode;
	 private String city;
	 private String phone;
	 private String other;
	 private Date dateAdded;
	 private Date updateDate;
	 @JsonIgnore
	 @OneToMany(mappedBy = "deliveryAddressId")
	 private List<Shipment> shipment;
	 @ManyToOne
	 @JoinColumn(name = "countryId")
	 private Countries countryId;
}
