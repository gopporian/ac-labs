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

import dd.aclabs.project.data.PropertyDetails;
import dd.aclabs.project.data.service.PropertyDetailsService;


@Controller
@RequestMapping(value = "/propertyDetails")
public class PropertyDetailsController {


	private final static Logger LOGGER = LoggerFactory.getLogger(PropertyDetailsController.class);
	
	@Autowired
	private PropertyDetailsService propertyDetailsService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private Iterable<PropertyDetails> getAllPropertyDetails() {
		LOGGER.info("Requested all property details!");
		return propertyDetailsService.getAll();
	}

	@RequestMapping(value = "/{propertyDetailsId}", method = RequestMethod.GET, produces = "application/json")
	private PropertyDetails getPropertyDetailsById(@PathVariable("propertyDetailsId") Long propertyDetailsId) {
		LOGGER.info("Requested property details with id: " + propertyDetailsId);
		return propertyDetailsService.get(propertyDetailsId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<?> updatePropertyDetails(@RequestBody PropertyDetails propertyDetails) {
		LOGGER.info("Saving new property detail : " + propertyDetails);
		propertyDetailsService.save(propertyDetails);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{propertyDetailsId}", method = RequestMethod.DELETE)
	private ResponseEntity<?> deletePropertyDetails(@PathVariable("propertyDetailsId") Long propertyDetailsId) {
		LOGGER.info("Removing property detail : " + propertyDetailsId);
		propertyDetailsService.delete(propertyDetailsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
