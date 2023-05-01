package mul.cam.a.dto;

import java.io.Serializable;

public class CharacterMainDto implements Serializable{
	private int seq;
	private String hair; 
	private String eyes;
	private String nose;
	private String eyebrow;
	private String mouth;
	
	public CharacterMainDto() {
		
	}

	public CharacterMainDto(int seq, String hair, String eyes, String nose, String eyebrow, String mouth) {
		super();
		this.seq = seq;
		this.hair = hair;
		this.eyes = eyes;
		this.nose = nose;
		this.eyebrow = eyebrow;
		this.mouth = mouth;
	}
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getEyes() {
		return eyes;
	}

	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	public String getNose() {
		return nose;
	}

	public void setNose(String nose) {
		this.nose = nose;
	}

	public String getEyebrow() {
		return eyebrow;
	}

	public void setEyebrow(String eyebrow) {
		this.eyebrow = eyebrow;
	}

	public String getMouth() {
		return mouth;
	}

	public void setMouth(String mouth) {
		this.mouth = mouth;
	}

	@Override
	public String toString() {
		return "CharacterMainDto [seq=" + seq + ", hair=" + hair + ", eyes=" + eyes + ", nose=" + nose + ", eyebrow="
				+ eyebrow + ", mouth=" + mouth + "]";
	}
	
	
	
}
