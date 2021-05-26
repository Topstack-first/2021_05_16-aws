
  package org.sid.Application.Repository;
  
  import java.util.List;

import org.sid.Application.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

  
  @RepositoryRestResource 
  public interface StatusRepository extends JpaRepository<Status, Long>{
 
  }
 