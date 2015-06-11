package dd.aclabs.project.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.PropertyDetails;
import dd.aclabs.project.data.repository.BaseDAO;

@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class PropertyDetailsServiceImpl extends BaseServiceImpl<PropertyDetails, Long> implements PropertyDetailsService{

	@Autowired
	@Qualifier("propertyDetailsRepository")
	protected BaseDAO<PropertyDetails,Long> propertyDetailsRepository;
	
	@Override
	public BaseDAO<PropertyDetails, Long> getRepository() {
		return propertyDetailsRepository;
	} 
	
}
