package dd.aclabs.project.data.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.PropertyDetails;

@Repository("propertyDetailsRepository")
@Component("propertyDetailsRepository")
@Transactional

public class PropertyDetailsRepository extends BaseRepository<PropertyDetails, Long>{
	@Override
	protected Class<PropertyDetails> getDomainClass() {
		return PropertyDetails.class;
	}
}
