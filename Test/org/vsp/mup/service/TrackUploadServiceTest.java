package org.vsp.mup.service;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.vsp.mup.domain.Tag;

public class TrackUploadServiceTest {

	public TrackUploadService trackUploadService = new TrackUploadService();
	
	@Test
	public void deleteSpaces1() {
		String s = "   AAA BBB  CCC    ";		
		assertEquals("AAA BBB  CCC", trackUploadService.deleteSpaces(s));
	}
	
	@Test
	public void deleteSpaces2() {
		String s = "AAA BBB  CCC";		
		assertEquals("AAA BBB  CCC", trackUploadService.deleteSpaces(s));
	}

	@Test
	public void deleteSpaces3() {
		String s = "       ";		
		assertEquals("", trackUploadService.deleteSpaces(s));
	}
	
}
