package dd.aclabs.project.data.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.Property;

@Repository("propertyRepository")
@Component("propertyRepository")
@Transactional

public class PropertyRepository extends BaseRepository<Property, Long>{
	@Override
	protected Class<Property> getDomainClass() {
		return Property.class;
	}
}
