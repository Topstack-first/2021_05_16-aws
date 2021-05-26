
  package org.sid.Application.Repository;
  
  import java.util.Date;
import java.util.List;

import org.sid.Application.Entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
  
  @RepositoryRestResource 
  public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
        
	  public Shipment findByourTrackingNumber(String tracking_number);
	  @Query(value = "SELECT *FROM SHIPMENT WHERE ID_CUSTOMER = ?1", nativeQuery = true)
	  public List<Shipment> findByidCustomer(long idCustomer);
	  @Query(value = "SELECT *FROM Shipment WHERE ID_CARRIER = ?1", nativeQuery = true)
	  public List<Shipment> findByidCarrier(long idCarrier);
	  @Query(value = "SELECT *FROM Shipment WHERE ID_CUSTOMER = ?1 AND DATE_ADDED BETWEEN ?2 AND ?3", nativeQuery = true)
	  public List<Shipment> findByIdCustomerAndDate(long idCustomer, Date dateFrom, Date dateTo);
	  @Query(value = "SELECT *FROM Shipment WHERE ID_CARRIER = ?1 AND DATE_ADDED >= ?2 AND DATE_ADDED <= ?3", nativeQuery = true)
	  public List<Shipment> findByIdCarrierAndDate(long idCarrier, Date dateFrom, Date dateTo);
	  
	  
	 
  }
 