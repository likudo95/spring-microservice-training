package com.brownfield.pss.baggage.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

import com.brownfield.pss.baggage.entity.Baggage;
import com.brownfield.pss.baggage.repository.BaggageRepository;

@EnableFeignClients
@RefreshScope
@Component
public class BaggageComponent {
	private static final Logger logger = LoggerFactory.getLogger(BaggageComponent.class);
    
	@Autowired
	private CheckInServiceProxy checkInServiceProxy;

	@Autowired
	private BaggageRepository baggageRepository;
	
	@Autowired
	private Sender sender;
	
	public Baggage save(Baggage baggage) {
		
		CheckInRecord checkInRecord = checkInServiceProxy.getCheckInRecord(baggage.getCheckinId());
		
		if (checkInRecord != null) {
			logger.info("Save baggage.......");
			return baggageRepository.save(baggage);
		}
		return null;
	}
	
	public Baggage getById(long id) {
		return baggageRepository.findOne(id);
	} 
	
}

