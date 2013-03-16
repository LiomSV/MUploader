package org.vsp.mup.helper;

import java.util.ArrayList;
import java.util.List;

import org.vsp.mup.domain.Tag;

public class TagValueList {
	private List<Integer> tagIdList = new ArrayList<Integer>();
	
	private List<String> tagnameList = new ArrayList<String>();
	
	private List<Integer> values = new ArrayList<Integer>();
	
	public List<Integer> getTagIdList() {
		return tagIdList;
	}

	public List<String> getTagnameList() {
		return tagnameList;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setTagIdList(List<Integer> tagIdList) {
		this.tagIdList = tagIdList;
	}

	public void setTagnameList(List<String> tagnameList) {
		this.tagnameList = tagnameList;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public void addTag(Tag tag){
		if (tagIdList.contains(tag.getIdTag())){
			values.set(tagIdList.indexOf(tag.getIdTag()), values.get(tagIdList.indexOf(tag.getIdTag())) + 1);
		} else {
			tagIdList.add(tag.getIdTag());
			tagnameList.add(tag.getTagname());
			values.add(1);
		}	
	}
	
	public String getTagnames(){
		StringBuffer buffer = new StringBuffer("[");
		for(String tagname : tagnameList){
			buffer.append("\"%%.% - " + tagname + "\", ");
		}
		buffer.delete(buffer.length()-2, buffer.length());
		buffer.append("]");
		return new String(buffer);
	}
	
	public String getHrefs(){
		StringBuffer buffer = new StringBuffer("[");
		for(Integer id : tagIdList){
			buffer.append("\"tag/" + id + "\", ");
		}
		buffer.delete(buffer.length()-2, buffer.length());
		buffer.append("]");
		return new String(buffer);
	}
	
}
