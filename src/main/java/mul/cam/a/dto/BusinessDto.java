package mul.cam.a.dto;

import java.io.Serializable;

public class BusinessDto implements Serializable{
	private int seq;
	private String id;			
	private String name;		
	private String email;		//이메일 주소
	private String url;			//깃허브, 블로그 주소링크 등
	private String historydate;	//업적..?
	private String wdate;		//작성일
	private String content;		
	private String thumbnail; 	// 아바타 사진 저장경로
	private String introduce;
	private String phoneNum;
	
	public BusinessDto() {
		
	}

	
	
	public BusinessDto(int seq, String id, String name, String email, String url, String histroydate, String wdate,
			String content, String thumbnail, String introduce, String phoneNum) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.email = email;
		this.url = url;
		this.historydate = histroydate;
		this.wdate = wdate;
		this.content = content;
		this.thumbnail = thumbnail;
		this.introduce = introduce;
		this.phoneNum = phoneNum;
	}
	
	
	
	public BusinessDto(String id, String name, String email, String url,
						String thumbnail, String introduce, String phoneNum) {

		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.url = url;
		this.thumbnail = thumbnail;
		this.introduce = introduce;
		this.phoneNum = phoneNum;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getHistroydate() {
		return historydate;
	}


	public void setHistroydate(String histroydate) {
		this.historydate = histroydate;
	}


	public String getWdate() {
		return wdate;
	}


	public void setWdate(String wdate) {
		this.wdate = wdate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getIntroduce() {
		return introduce;
	}
	
	
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	@Override
	public String toString() {
		return "BusinessDto [seq=" + seq + ", id=" + id + ", name=" + name + ", email=" + email + ", url=" + url
				+ ", historydate=" + historydate + ", wdate=" + wdate + ", content=" + content + ", thumbnail="
				+ thumbnail + ", introduce=" + introduce + ", phoneNum=" + phoneNum + "]";
	}
	

	
	
	
	
}
