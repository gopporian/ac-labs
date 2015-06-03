package dd.aclabs.project.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import dd.aclabs.project.data.User;
import dd.aclabs.project.data.repository.UserRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> {

	@Autowired
	protected UserRepository userRepository;
	
	@Override
	public CrudRepository<User, Long> getRepository() {
		return userRepository;
	} 
	
}
