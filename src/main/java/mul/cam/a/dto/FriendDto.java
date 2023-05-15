package mul.cam.a.dto;

import java.io.Serializable;

public class FriendDto implements Serializable{
	
	private int seq;
	private String id;
	private String friendid;
	private String friendname;
	private String regdate;
	
	private int start;
	private int end;
	private int rnum;
	
	public FriendDto() {
	}
	
	public FriendDto(int seq, String id, String friendid, String friendname, String regdate, int start, int end,
			int rnum) {
		super();
		this.seq = seq;
		this.id = id;
		this.friendid = friendid;
		this.friendname = friendname;
		this.regdate = regdate;
		this.start = start;
		this.end = end;
		this.rnum = rnum;
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

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "FriendDto [seq=" + seq + ", id=" + id + ", friendid=" + friendid + "]";
	}
	
}
