package org.sid.Application.Repository;
import org.sid.Application.Entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Countries, Long>{

}
