package mul.cam.a.dto;

import java.io.Serializable;

public class BgmDto implements Serializable{
	
	private int seq;
	private String id;
	private String artist;
	private String title;
	private String url;

	public BgmDto() {
	}
	
	public BgmDto(int seq, String id, String artist, String title, String url) {
		super();
		this.seq = seq;
		this.id = id;
		this.artist = artist;
		this.title = title;
		this.url = url;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
