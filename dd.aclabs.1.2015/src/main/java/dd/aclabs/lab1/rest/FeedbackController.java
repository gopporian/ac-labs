package dd.aclabs.lab1.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dd.aclabs.lab1.data.Feedback;
import dd.aclabs.lab1.data.repository.FeedbackRepository;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	private final static Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

	@Autowired
	private FeedbackRepository feedbackRepository;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private Iterable<Feedback> getAllFeedbacks() {
		LOGGER.info("Requested all feedbacks!");
		return feedbackRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	private ResponseEntity<?> addFeedback(@RequestBody Feedback feedback) {
		LOGGER.info("Saving new feedback : " + feedback);
		feedbackRepository.save(feedback);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
