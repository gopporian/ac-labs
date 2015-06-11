package dd.aclabs.project.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.PropertyPositioning;
import dd.aclabs.project.data.repository.BaseDAO;

@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class PropertyPositioningServiceImpl extends BaseServiceImpl<PropertyPositioning, Long> implements PropertyPositioningService{

	@Autowired
	@Qualifier("propertyPositioningRepository")
	protected BaseDAO<PropertyPositioning,Long> propertyPositioningRepository;
	
	@Override
	public BaseDAO<PropertyPositioning, Long> getRepository() {
		return propertyPositioningRepository;
	} 
	
}
