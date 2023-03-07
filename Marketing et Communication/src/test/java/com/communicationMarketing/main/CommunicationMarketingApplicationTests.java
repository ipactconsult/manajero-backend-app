package com.communicationMarketing.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.communicationMarketing.main.business.businessimpl.ParternershipBusiness;

@SpringBootTest
class CommunicationMarketingApplicationTests {
	
	@Autowired
	ParternershipBusiness  pb; 




	@Test
	public void affichage() {
		pb.getAllParternerships();
	}
	

	


}
