package org.vsp.mup.dao;

import java.util.List;

import org.vsp.mup.domain.Tag;

public interface TagDAO {
	public List<Tag> getPopularTags(Integer n);
	public List<Tag> getAllTags();
	public void upgateTag(Tag tag);
	public void saveTag(Tag tag);
	public Tag getTagByTagname(String tagname);
	public Tag getTagById(Integer id);
}
