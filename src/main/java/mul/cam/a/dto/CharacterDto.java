package mul.cam.a.dto;

import java.io.Serializable;

public class CharacterDto implements Serializable{
	private int seq;
	private String thumbnail;

	
	//기본 생성자
	public CharacterDto() {
	}

	
	public CharacterDto(int seq, String thumbnail) {
		super();
		this.seq = seq;
		this.thumbnail = thumbnail;
	}

	

	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	@Override
	public String toString() {
		return "CharacterDto [seq=" + seq + ", thumbnail=" + thumbnail + "]";
	}
	
	
	
}
