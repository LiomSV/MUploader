package org.vsp.mup.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vsp.mup.helper.StringHelper;

public class StringHelperTest {

	public TrackUploadService trackUploadService = new TrackUploadService();
	
	@Test
	public void deleteSpaces1() {
		String s = "   AAA BBB  CCC    ";		
		assertEquals("AAA BBB  CCC", StringHelper.deleteSpaces(s));
	}
	
	@Test
	public void deleteSpaces2() {
		String s = "AAA BBB  CCC";		
		assertEquals("AAA BBB  CCC", StringHelper.deleteSpaces(s));
	}

	@Test
	public void deleteSpaces3() {
		String s = "       ";		
		assertEquals("", StringHelper.deleteSpaces(s));
	}
	
}
