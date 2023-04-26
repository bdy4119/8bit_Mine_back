package mul.cam.a.dto;

import java.io.Serializable;

//명함 앞면
public class BusinessDto implements Serializable{
	private int seq;
	private String id;			
	private String name;		
	private String email;		//이메일 주소
	private String url;			//깃허브, 블로그 주소링크 등
	private String wdate;		//작성일
	private String thumbnail; 	// 아바타 사진 저장경로
	private String introduce;
	private String phoneNum;
	
	public BusinessDto() {
		
	}
	
	
	public BusinessDto(int seq, String id, String name, String email, String url, String wdate,
						String thumbnail, String introduce, String phoneNum) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.email = email;
		this.url = url;
		this.wdate = wdate;
		this.thumbnail = thumbnail;
		this.introduce = introduce;
		this.phoneNum = phoneNum;
	}
	
	
	//외부에서 값받는 생성자
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


	public String getWdate() {
		return wdate;
	}


	public void setWdate(String wdate) {
		this.wdate = wdate;
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
				+ ", wdate=" + wdate + ", thumbnail="
				+ thumbnail + ", introduce=" + introduce + ", phoneNum=" + phoneNum + "]";
	}
	

	
	
	
	
}
