package mul.cam.a.dto;

import java.io.Serializable;

public class LoginDto implements Serializable{
	private String id;
	private String email;
	private String name;
	private String regidate;
	private String social;
	private int auth;
	private String cause;
	private String token;
	private String profPic;
	private String profMsg;
	private String job;
	private String birthdate;
	private String address;
	
	public LoginDto() {
		
	}

	public LoginDto(String id, String email, String name, String regidate, String social, int auth, String cause,
			String token, String profPic, String profMsg, String job, String birthdate, String address) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.regidate = regidate;
		this.social = social;
		this.auth = auth;
		this.cause = cause;
		this.token = token;
		this.profPic = profPic;
		this.profMsg = profMsg;
		this.job = job;
		this.birthdate = birthdate;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getProfPic() {
		return profPic;
	}

	public void setProfPic(String profPic) {
		this.profPic = profPic;
	}

	public String getProfMsg() {
		return profMsg;
	}

	public void setProfMsg(String profMsg) {
		this.profMsg = profMsg;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
