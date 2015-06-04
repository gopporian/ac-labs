package dd.aclabs.project.data.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.User;

/**
 * Created by Maris Alexandru
 */
@Repository("userRepository")
@Component("userRepository")
@Transactional
public class UserRepository extends BaseRepository<User, Long>{

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}
}
