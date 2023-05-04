package mul.cam.a.dto;

import java.io.Serializable;

public class TodoDto implements Serializable{
	
	private int seq;		// sequence 글번호
	private String id;		// 작성자
	
	private String title;
	private String content;
	private String rdate; //약속날짜
	private String wdate;
	
	private int del;
	
	public TodoDto() {
		
	}
	
	public TodoDto(String id, String title, String content, String rdate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
	}

	public TodoDto(int seq, String id, String title, String content, String rdate, String wdate, int del) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.wdate = wdate;
		this.del = del;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "TodoDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", rdate=" + rdate
				+ ", wdate=" + wdate + ", del=" + del + "]";
	}
	
	
	
	

}
