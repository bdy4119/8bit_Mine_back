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
	
	public LoginDto() {
		
	}

	public LoginDto(String id, String email, String name, String regidate, String social, int auth, String cause, String token) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.regidate = regidate;
		this.social = social;
		this.auth = auth;
		this.cause = cause;
		this.token = token;
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

	@Override
	public String toString() {
		return "LoginDto [id=" + id + ", email=" + email + ", name=" + name + ", regidate=" + regidate 
				+ ", social=" + social + ", auth=" + auth + ", cause=" + cause + ", token=" + token + "]";
	}
	
	
}
