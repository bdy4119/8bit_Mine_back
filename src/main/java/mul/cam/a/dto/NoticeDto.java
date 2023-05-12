package mul.cam.a.dto;

import java.io.Serializable;

public class NoticeDto implements Serializable{
	
	private int seq;
	private String id;
	private int minenotice;
	private int guestnotice;
	
	
	public NoticeDto() {
		
	}


	public NoticeDto(int seq, String id, int minenotice, int guestnotice) {
		super();
		this.seq = seq;
		this.id = id;
		this.minenotice = minenotice;
		this.guestnotice = guestnotice;
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


	public int getMinenotice() {
		return minenotice;
	}


	public void setMinenotice(int minenotice) {
		this.minenotice = minenotice;
	}


	public int getGuestnotice() {
		return guestnotice;
	}


	public void setGuestnotice(int guestnotice) {
		this.guestnotice = guestnotice;
	}


	@Override
	public String toString() {
		return "NoticeDto [seq=" + seq + ", id=" + id + ", minenotice=" + minenotice + ", guestnotice=" + guestnotice
				+ "]";
	}
}
