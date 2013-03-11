package org.vsp.mup.service;

public class AddressBuilder {
	
		private StringBuffer line;
	
		public AddressBuilder(String prefix){
			this.line = new StringBuffer(prefix);
		}
		
		public void addArgument(String argument){
			if (line.indexOf("?") < 0){
				line.append('?');				
			} else {
				line.append('&');
			}			
			line.append(argument);
		}
		
		public String getAddress(){
			return new String(line);
		}
}
