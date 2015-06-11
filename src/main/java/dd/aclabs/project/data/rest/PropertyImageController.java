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

import dd.aclabs.project.data.PropertyImage;
import dd.aclabs.project.data.service.PropertyImageService;


@Controller
@RequestMapping(value = "/propertyImage")
public class PropertyImageController {


	private final static Logger LOGGER = LoggerFactory.getLogger(PropertyImageController.class);
	
	@Autowired
	private PropertyImageService propertyImageService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private Iterable<PropertyImage> getAllPropertyImages() {
		LOGGER.info("Requested all property images!");
		return propertyImageService.getAll();
	}

	@RequestMapping(value = "/{propertyImageId}", method = RequestMethod.GET, produces = "application/json")
	private PropertyImage getPropertyImageById(@PathVariable("propertyImageId") Long propertyImageId) {
		LOGGER.info("Requested property image with id: " + propertyImageId);
		return propertyImageService.get(propertyImageId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<?> updatePropertyImage(@RequestBody PropertyImage propertyImage) {
		LOGGER.info("Saving new property image : " + propertyImage);
		propertyImageService.save(propertyImage);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{propertyImageId}", method = RequestMethod.DELETE)
	private ResponseEntity<?> deletePropertyImage(@PathVariable("propertyImageId") Long propertyImageId) {
		LOGGER.info("Removing property image : " + propertyImageId);
		propertyImageService.delete(propertyImageId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
