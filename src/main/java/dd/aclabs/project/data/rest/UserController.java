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

import dd.aclabs.project.data.User;
import dd.aclabs.project.data.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	private Iterable<User> getAllUsers() {
		LOGGER.info("Requested all users!");
		return userService.getAll();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
	private User getUserById(@PathVariable("userId") Long userId) {
		LOGGER.info("Requested user with id: " + userId);
		return userService.get(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<?> updateUser(@RequestBody User user) {
		LOGGER.info("Saving new user : " + user);
		userService.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
	private ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId) {
		LOGGER.info("Removing user : " + userId);
		userService.delete(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
