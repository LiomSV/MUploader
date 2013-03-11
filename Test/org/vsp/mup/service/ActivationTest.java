package org.vsp.mup.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vsp.mup.domain.User;

public class ActivationTest {

	@Test
    public void generateActivationCode() {
	    User user = new User();
		user.setUsername("LioN");
	    String code = "21182423";	 	 
	    assertEquals(code, Activation.generateActivationCode(user));
	}
	
	@Test
    public void decodeActivationCode() {
		String username = "lion";
	    String code = "21182423";	 	 
	    assertEquals(username, Activation.decodeActivationCode(code));
	}
	
}
