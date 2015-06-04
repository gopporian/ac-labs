package dd.aclabs.project.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.User;
import dd.aclabs.project.data.repository.BaseDAO;

/**
 * Created by Maris Alexandru
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{

	@Autowired
	@Qualifier("userRepository")
	protected BaseDAO<User,Long> userRepository;
	
	@Override
	public BaseDAO<User, Long> getRepository() {
		return userRepository;
	} 
	
}
