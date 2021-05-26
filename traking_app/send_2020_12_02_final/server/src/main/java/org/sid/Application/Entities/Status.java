
package org.sid.Application.Entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String shipmentStatusName;
	private Boolean isAnException;
	@JsonIgnore
	@OneToMany(mappedBy="statusId")
	private Collection<Shipment_status> shipmentStatus;
	
	
	
	 @ManyToOne
	 @JoinColumn(name="parent_id") private Status parent;
	 @JsonIgnore
	 @OneToMany(mappedBy="parent", cascade = CascadeType.ALL) private Set<Status>
	 children = new HashSet<Status>();
	 
	
	

	
}
