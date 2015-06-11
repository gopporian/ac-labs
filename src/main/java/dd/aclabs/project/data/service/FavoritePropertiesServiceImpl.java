package dd.aclabs.project.data.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.FavoriteProperties;
import dd.aclabs.project.data.repository.BaseDAO;

@Service
@Transactional(rollbackFor = { RuntimeException.class })
public class FavoritePropertiesServiceImpl extends BaseServiceImpl<FavoriteProperties, Long> implements FavoritePropertiesService{

	@Autowired
	@Qualifier("favoritePropertiesRepository")
	protected BaseDAO<FavoriteProperties,Long> favoritePropertiesRepository;
	
	@Override
	public BaseDAO<FavoriteProperties, Long> getRepository() {
		return favoritePropertiesRepository;
	} 
	
}
