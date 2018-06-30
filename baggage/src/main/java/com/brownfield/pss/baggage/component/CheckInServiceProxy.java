package com.brownfield.pss.baggage.component;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="checkin-service")
public interface CheckInServiceProxy {
	
	@RequestMapping(value = "checkin/get/{id}", method=RequestMethod.GET)
	CheckInRecord getCheckInRecord(@PathVariable("id") long id);
}