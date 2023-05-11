package mul.cam.a.dto;

import java.io.Serializable;

public class FriendDto implements Serializable{
	
	private int seq;
	private String id;
	private String friendid;
	
	public FriendDto() {
		
	}

	public FriendDto(int seq, String id, String friendid) {
		super();
		this.seq = seq;
		this.id = id;
		this.friendid = friendid;
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

	public String getFriendid() {
		return friendid;
	}

	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}

	@Override
	public String toString() {
		return "FriendDto [seq=" + seq + ", id=" + id + ", friendid=" + friendid + "]";
	}
	
}
