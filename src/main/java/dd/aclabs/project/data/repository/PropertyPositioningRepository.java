package dd.aclabs.project.data.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.PropertyPositioning;

@Repository("propertyPositioningRepository")
@Component("propertyPositioningRepository")
@Transactional

public class PropertyPositioningRepository extends BaseRepository<PropertyPositioning, Long>{
	@Override
	protected Class<PropertyPositioning> getDomainClass() {
		return PropertyPositioning.class;
	}
}
