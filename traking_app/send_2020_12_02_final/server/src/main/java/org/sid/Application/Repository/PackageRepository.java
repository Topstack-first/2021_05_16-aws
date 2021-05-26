package org.sid.Application.Repository;

import java.util.List;

import org.sid.Application.Entities.Pakage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PackageRepository extends JpaRepository<Pakage, Long>{
	
      public List<Pakage> findByidSupplier(long idSupplier);
}
