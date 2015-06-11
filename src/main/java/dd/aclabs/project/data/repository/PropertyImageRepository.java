package dd.aclabs.project.data.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.PropertyImage;

@Repository("propertyImageRepository")
@Component("propertyImageRepository")
@Transactional

public class PropertyImageRepository extends BaseRepository<PropertyImage, Long>{
	@Override
	protected Class<PropertyImage> getDomainClass() {
		return PropertyImage.class;
	}
}
