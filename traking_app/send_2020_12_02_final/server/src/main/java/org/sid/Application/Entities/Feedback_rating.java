package org.sid.Application.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback_rating {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int rate;
	private Date feedbackDate;
	@OneToOne
	@JoinColumn(name = "shipmentId")
	private Shipment shipmentId;

}
