package com.brownfield.pss.baggage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brownfield.pss.baggage.component.BaggageComponent;
import com.brownfield.pss.baggage.entity.Baggage;

@RestController
@CrossOrigin
@RequestMapping("/baggage")
public class BaggageController {
	
	@Autowired
	private BaggageComponent baggageComponent;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Baggage> getData(@PathVariable("id") long id) {
		Baggage baggage = baggageComponent.getById(id);
		return baggage != null ? new ResponseEntity<Baggage>(baggage, HttpStatus.OK)
				: new ResponseEntity<Baggage>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Baggage> checkinBaggage(@RequestBody Baggage baggage) {
		baggage = baggageComponent.save(baggage);
		
		return baggage != null ? new ResponseEntity<>(baggage, HttpStatus.CREATED)
				: new ResponseEntity<Baggage>(HttpStatus.BAD_REQUEST);
	}

}
