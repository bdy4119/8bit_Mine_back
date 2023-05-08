package mul.cam.a.dto;

import java.io.Serializable;

public class SocialDto implements Serializable{
	
	private int seq;
	private String owner;
	private String friend;
	private String memo;
	private String regdate;
	
	public SocialDto() {
	}

	public SocialDto(int seq, String owner, String friend, String memo, String regdate) {
		super();
		this.seq = seq;
		this.owner = owner;
		this.friend = friend;
		this.memo = memo;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


}
