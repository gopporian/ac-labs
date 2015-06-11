package dd.aclabs.project.data.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dd.aclabs.project.data.Property;
import dd.aclabs.project.data.service.PropertyService;


@Controller
@RequestMapping(value = "/property")
public class PropertyColtroller {


	private final static Logger LOGGER = LoggerFactory.getLogger(PropertyColtroller.class);
	
	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private Iterable<Property> getAllProperties() {
		LOGGER.info("Requested all properties!");
		return propertyService.getAll();
	}

	@RequestMapping(value = "/{propertyId}", method = RequestMethod.GET, produces = "application/json")
	private Property getPropertyById(@PathVariable("propertyId") Long propertyId) {
		LOGGER.info("Requested property with id: " + propertyId);
		return propertyService.get(propertyId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<?> updateProperty(@RequestBody Property property) {
		LOGGER.info("Saving new property : " + property);
		propertyService.save(property);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{propertyId}", method = RequestMethod.DELETE)
	private ResponseEntity<?> deleteProperty(@PathVariable("propertyId") Long propertyId) {
		LOGGER.info("Removing property : " + propertyId);
		propertyService.delete(propertyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
