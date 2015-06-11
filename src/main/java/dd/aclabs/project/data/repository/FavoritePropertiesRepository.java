package dd.aclabs.project.data.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.FavoriteProperties;

@Repository("favoritePropertyRepository")
@Component("favoritePropertyRepository")
@Transactional

public class FavoritePropertiesRepository extends BaseRepository<FavoriteProperties, Long>{
	@Override
	protected Class<FavoriteProperties> getDomainClass() {
		return FavoriteProperties.class;
	}
}
