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

import dd.aclabs.project.data.FavoriteProperties;
import dd.aclabs.project.data.service.FavoritePropertiesService;


@Controller
@RequestMapping(value = "/favoriteProperty")
public class FavoritePropertiesController {


	private final static Logger LOGGER = LoggerFactory.getLogger(FavoritePropertiesController.class);
	
	@Autowired
	private FavoritePropertiesService favoritePropertiesService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private Iterable<FavoriteProperties> getAllFavoriteProperties() {
		LOGGER.info("Requested all favorite properties!");
		return favoritePropertiesService.getAll();
	}

	@RequestMapping(value = "/{favoritePropertiesId}", method = RequestMethod.GET, produces = "application/json")
	private FavoriteProperties getFavoritePropertiesById(@PathVariable("favoritePropertiesId") Long favoritePropertiesId) {
		LOGGER.info("Requested favorite properties with id: " + favoritePropertiesId);
		return favoritePropertiesService.get(favoritePropertiesId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<?> updateFavoriteProperties(@RequestBody FavoriteProperties favoriteProperties) {
		LOGGER.info("Saving new favorite property : " + favoriteProperties);
		favoritePropertiesService.save(favoriteProperties);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{favoritePropertiesId}", method = RequestMethod.DELETE)
	private ResponseEntity<?> deleteFavoriteProperties(@PathVariable("favoritePropertiesId") Long favoritePropertiesId) {
		LOGGER.info("Removing favorite property : " + favoritePropertiesId);
		favoritePropertiesService.delete(favoritePropertiesId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
