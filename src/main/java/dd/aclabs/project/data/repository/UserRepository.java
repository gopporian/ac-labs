package dd.aclabs.project.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dd.aclabs.project.data.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
