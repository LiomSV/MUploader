package org.vsp.mup.helper;

import org.springframework.stereotype.Service;

@Service
public class StringHelper {
	
	/**
	 * Method deletes spaces at beginning and end of string.   
	 * @param s
	 * @return
	 */
	public static String deleteSpaces(String s){
		int first;
		for(first = 0; (first < s.length()) && (s.charAt(first) == ' '); ++first);
		int last;
		for(last = s.length()-1; (last > -1) && (s.charAt(last) == ' ') && (last > first); --last);		
		return s.substring(first, last+1);
	}
	
	/**
	 * 	Method returns first letter in upper case, if it is contained in pattern,
	 * and returns notLetter otherwise.
	 * Default pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".
	 * Default notLetter = "#".
	 * @param s
	 * @return
	 */
	public static String getFirstLetter(String s){
		if (pattern.contains(s.subSequence(0, 1))){
			return s.toUpperCase().substring(0, 1);
		}
		return notLetter;
	}
	
	private static final String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String notLetter = "#";
}
