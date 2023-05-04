package mul.cam.a.dto;

import java.io.Serializable;

public class KakaoAccount implements Serializable{
	private boolean has_email;
    private boolean email_needs_agreement;
    private boolean is_email_valid;
    private boolean is_email_verified;
    private String email;
    
    public KakaoAccount() {
    	
	}

	public KakaoAccount(boolean has_email, boolean email_needs_agreement, boolean is_email_valid,
			boolean is_email_verified, String email) {
		super();
		this.has_email = has_email;
		this.email_needs_agreement = email_needs_agreement;
		this.is_email_valid = is_email_valid;
		this.is_email_verified = is_email_verified;
		this.email = email;
	}

	public boolean isHas_email() {
		return has_email;
	}

	public void setHas_email(boolean has_email) {
		this.has_email = has_email;
	}

	public boolean isEmail_needs_agreement() {
		return email_needs_agreement;
	}

	public void setEmail_needs_agreement(boolean email_needs_agreement) {
		this.email_needs_agreement = email_needs_agreement;
	}

	public boolean isIs_email_valid() {
		return is_email_valid;
	}

	public void setIs_email_valid(boolean is_email_valid) {
		this.is_email_valid = is_email_valid;
	}

	public boolean isIs_email_verified() {
		return is_email_verified;
	}

	public void setIs_email_verified(boolean is_email_verified) {
		this.is_email_verified = is_email_verified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "KakaoAccount [has_email=" + has_email + ", email_needs_agreement=" + email_needs_agreement
				+ ", is_email_valid=" + is_email_valid + ", is_email_verified=" + is_email_verified + ", email=" + email
				+ "]";
	}
    
    
}
