package org.sid.Application.Repository;

import org.sid.Application.Entities.Feedback_rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FeedbackRatingRepository extends JpaRepository<Feedback_rating, Long>{

}
