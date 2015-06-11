package dd.aclabs.project.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.PropertyImage;
import dd.aclabs.project.data.repository.BaseDAO;

@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class PropertyImageServiceImpl extends BaseServiceImpl<PropertyImage, Long> implements PropertyImageService{

	@Autowired
	@Qualifier("propertyImageRepository")
	protected BaseDAO<PropertyImage,Long> propertyImageRepository;
	
	@Override
	public BaseDAO<PropertyImage, Long> getRepository() {
		return propertyImageRepository;
	} 
	
}
