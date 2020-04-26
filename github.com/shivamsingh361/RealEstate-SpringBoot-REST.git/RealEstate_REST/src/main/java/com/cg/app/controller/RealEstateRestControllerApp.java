package com.cg.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ImageBanner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cg.app.dao.PropertyImageRepository;
import com.cg.app.dto.InterestLog;
import com.cg.app.dto.Property;
import com.cg.app.dto.PropertyImage;
import com.cg.app.dto.User;
import com.cg.app.exceptions.NoImageFoundException;
import com.cg.app.exceptions.PropertyException;
import com.cg.app.exceptions.UserAlreadyExistException;
import com.cg.app.exceptions.UserException;
import com.cg.app.exceptions.UserNotFoundException;
import com.cg.app.services.PropertyService;
import com.cg.app.services.UserService;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /api (after Application path)
public class RealEstateRestControllerApp {

	@Autowired			// This means to get the bean called userRepository
	private UserService userService;
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private PropertyImageRepository imageRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/deleteUser/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable("userId") String userId) {		
		try {
			userService.deleteUser(userId);
			return new ResponseEntity<Object>(
					"User Deleted!", HttpStatus.ACCEPTED);
		} catch (UserException e) {
			return new ResponseEntity<Object>(
					"Invalid Request!" , HttpStatus.BAD_REQUEST);
		}
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateuser")
	public User updateUser(@RequestBody User updateUser) throws UserException {
		return userService.updateUser(updateUser);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public User newUser(@RequestBody User newUser) throws UserAlreadyExistException, UserException {
		return userService.addUser(newUser);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/alluserids")
	public @ResponseBody Iterable<String> getAllUserIds() throws UserException {
		return userService.getAllUserIds();
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/login",
	produces = "application/json")
	public @ResponseBody User checkCredentials(@NonNull @RequestBody  Map<String, String> obj) throws UserException {
		return userService.checkCredentials(obj.get("userId"), obj.get("pass"));
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/allproperties",
	headers = "Accept=application/json",
	produces = "application/json")
	public @ResponseBody Iterable<Property>  getAllPropertyList() throws PropertyException{
		return propertyService.getAllProperty();
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value= "/getproperty/{propId}")
	public Optional<Property> getPropertyById(@PathVariable("propId") String id) throws NumberFormatException, PropertyException {
		return propertyService.getPropertyById(Integer.parseInt(id));
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value= "/getpropertybytype/{propType}")
	public List<Property> getPropertyByPropType(@PathVariable("propType") String propType) throws PropertyException {
		return propertyService.getPropertyByType(propType);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addproperty")
	public Property newProperty(@RequestBody Property newProperty) throws PropertyException {
		return  propertyService.addProperty(newProperty);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/deleteproperty/{propId}")
	public ResponseEntity<Object> deleteProperty(@PathVariable("propId") int propId) {
		try {
			propertyService.deleteProperty(propId);
			return new ResponseEntity<Object>(
					"The Record has been deleted!", HttpStatus.ACCEPTED);
		} catch (PropertyException e) {
			return new ResponseEntity<Object>(
					"ID dosen't exist. Deletion failed!" , HttpStatus.NOT_FOUND);
		}
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addinterest")
	public @ResponseBody void addInterest(@RequestBody InterestLog interest) {
		userService.addInterest(interest);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allinterest")
	public @ResponseBody Iterable<InterestLog> getAllInterestList() {
		return userService.getInterestLists();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/upload/{propId}")
	public @ResponseBody PropertyImage uplaodImage(@RequestParam("myFile") MultipartFile file, @PathVariable("propId") long propId) throws IOException, PropertyException {
		try {
			propertyService.getPropertyById((int)propId).get();
		}catch(NoSuchElementException e) {
			throw new PropertyException("Given property Dosen't exist!");	
		}

		PropertyImage img = new PropertyImage( file.getOriginalFilename(),file.getContentType(),file.getBytes(), propId);
		final PropertyImage savedImage = imageRepository.save(img);
		System.out.println("Image saved");
		return savedImage;

	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getImage/{id}")
	public @ResponseBody PropertyImage getImage(@PathVariable("id") long id) {
		PropertyImage images;
		images=imageRepository.getOne(id); 	//Testing by adding one image only.
		return images;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getImageByPropId/{propId}")
	public @ResponseBody List<PropertyImage > getImageByPropId(@PathVariable("propId") long propId) throws NoImageFoundException {	
		System.out.println("getImageByPropId() for Prop_ID: "+propId);
		List<PropertyImage> images = new ArrayList<PropertyImage>();
		images=imageRepository.findPropertyImageByPropId(propId); 	//Testing by adding one image only.
		if(images.size() == 0)
			throw new NoImageFoundException("No image exist for this propID.");
		//		System.out.println("Success! Returned Images ="+images.size());
		return images;		
	}
}
