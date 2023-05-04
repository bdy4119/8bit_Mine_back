package mul.cam.a.dto;

import java.io.Serializable;

public class KakaoToken implements Serializable{
	private String id;
	private String connected_at;
	private KakaoAccount kakao_account;
	
	public KakaoToken() {
		
	}

	public KakaoToken(String id, String connected_at, KakaoAccount kakao_account) {
		super();
		this.id = id;
		this.connected_at = connected_at;
		this.kakao_account = kakao_account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConnected_at() {
		return connected_at;
	}

	public void setConnected_at(String connected_at) {
		this.connected_at = connected_at;
	}

	public KakaoAccount getKakao_account() {
		return kakao_account;
	}

	public void setKakao_account(KakaoAccount kakao_account) {
		this.kakao_account = kakao_account;
	}

	@Override
	public String toString() {
		return "KakaoToken [id=" + id + ", connected_at=" + connected_at + ", kakao_account=" + kakao_account + "]";
	}
	
	
}
