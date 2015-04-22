package dd.aclabs.lab1.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dd.aclabs.lab1.data.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

}
