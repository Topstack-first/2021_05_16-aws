
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
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date dateAdded;
	private Date updateDate;
	private String ourTrackingNumber;
	private String carrierTrackingNumber;
	private String carrierTrackingLink;
	private double weight;
	private Boolean deliverySigned;
	private Boolean isOutOfFormat;
	private Boolean addressErros;
	private Boolean isAReturn;
	private long idDeliveryMethod;
	private long idCustomer;
	private long idCarrier;
	private double shipmentSellingPrice;
	private double shipmentBuyingPrice;
	private Boolean advaloremWarranty;
	private double declaredValue;
	private double capAmount;
	private int numberOfArticles;
	private long idInvoice;
	private String carrierName;
	@ManyToOne
	@JoinColumn(name = "packageId")
	private Pakage packageId;
	@JsonIgnore
	@OneToMany(mappedBy="shipmentId")
	private List<Shipment_status> shipmentStatus;
	@OneToOne(mappedBy = "shipmentId", cascade = CascadeType.ALL, orphanRemoval = true)
	private Feedback_rating feedBack;
	@ManyToOne
	@JoinColumn(name = "deliveryAddressId")
	private DeliveryAddress deliveryAddressId; 
	
	

	
	



	

	
}
