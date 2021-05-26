package org.sid.Application.Repository;
import org.sid.Application.Entities.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long>{

}
