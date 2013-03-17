package org.vsp.mup.helper;

public class TrackInfo {
	private boolean liked;
	
	private Integer likes;
	
	private Integer views;

	public boolean isLiked() {
		return liked;
	}

	public Integer getLikes() {
		return likes;
	}

	public Integer getViews() {
		return views;
	}

	public void setLiked(boolean isLiked) {
		this.liked = isLiked;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public void setViews(Integer views) {
		this.views = views;
	}
	
}
