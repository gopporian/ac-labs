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

import dd.aclabs.project.data.PropertyPositioning;
import dd.aclabs.project.data.service.PropertyPositioningService;


@Controller
@RequestMapping(value = "/propertyPositioning")
public class PropertyPositioningController {


	private final static Logger LOGGER = LoggerFactory.getLogger(PropertyPositioningController.class);
	
	@Autowired
	private PropertyPositioningService propertyPositioningService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private Iterable<PropertyPositioning> getAllPropertyPositionings() {
		LOGGER.info("Requested all property positionings!");
		return propertyPositioningService.getAll();
	}

	@RequestMapping(value = "/{propertyPositioningId}", method = RequestMethod.GET, produces = "application/json")
	private PropertyPositioning getPropertyPositioningById(@PathVariable("propertyPositioningId") Long propertyPositioningId) {
		LOGGER.info("Requested property positioning with id: " + propertyPositioningId);
		return propertyPositioningService.get(propertyPositioningId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<?> updatePropertyPositioning(@RequestBody PropertyPositioning propertyPositioning) {
		LOGGER.info("Saving new property positioning : " + propertyPositioning);
		propertyPositioningService.save(propertyPositioning);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{propertyPositioningId}", method = RequestMethod.DELETE)
	private ResponseEntity<?> deletePropertyPositioning(@PathVariable("propertyPositioningId") Long propertyPositioningId) {
		LOGGER.info("Removing property positioning : " + propertyPositioningId);
		propertyPositioningService.delete(propertyPositioningId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
