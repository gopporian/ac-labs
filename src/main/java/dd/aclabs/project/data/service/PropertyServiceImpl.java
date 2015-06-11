package dd.aclabs.project.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.Property;
import dd.aclabs.project.data.repository.BaseDAO;

@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class PropertyServiceImpl extends BaseServiceImpl<Property, Long> implements PropertyService{

	@Autowired
	@Qualifier("propertyRepository")
	protected BaseDAO<Property,Long> propertyRepository;
	
	@Override
	public BaseDAO<Property, Long> getRepository() {
		return propertyRepository;
	} 
	
}
