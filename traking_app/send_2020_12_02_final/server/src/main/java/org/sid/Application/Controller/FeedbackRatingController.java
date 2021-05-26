package org.sid.Application.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.sid.Application.Entities.Feedback_rating;
import org.sid.Application.Repository.FeedbackRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FeedbackRatingController {

	@Autowired
	private FeedbackRatingRepository FeedbackRatingRepository;

	@PostMapping(value = "/addFeedback")
	public ResponseEntity<Feedback_rating> addFeedback(@RequestBody Feedback_rating newFeedback) {
		Feedback_rating feedbackAdded = FeedbackRatingRepository.save(newFeedback);

		if (feedbackAdded == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(feedbackAdded.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/feedback")
	public ResponseEntity<List<Feedback_rating>> getAllFeedback() {
		List<Feedback_rating> feedbacks = FeedbackRatingRepository.findAll();
		if (feedbacks.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(feedbacks, HttpStatus.OK);
	}

	@GetMapping(value = "/getFeedbackById/{id}")
	public ResponseEntity<Feedback_rating> getFeedbackById(@PathVariable long id) {

		Optional<Feedback_rating> feedback = FeedbackRatingRepository.findById(id);
		if (feedback.isPresent())
			return new ResponseEntity<>(feedback.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/deleteFeedback/{id}")
	public ResponseEntity<HttpStatus> deleteFeedback(@PathVariable long id) {
		try {
			FeedbackRatingRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
