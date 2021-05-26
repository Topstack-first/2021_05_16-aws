package org.sid.Application.Repository;

import org.sid.Application.Entities.Shipment_status;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface Shipment_statusRepository extends JpaRepository<Shipment_status, Long>{
	
	public List<Shipment_status> findByShipmentIdContains(long idShipment);
	@Query(value = "SELECT *FROM Shipment_status WHERE SHIPMENT_ID = ?1 order by UPDATE_DATE_AND_TIME", nativeQuery = true)
	List<Shipment_status> findStatusShipmentByIdOrderByDate(long shipment_id);
	
	
}
