package arc.mirim.domain;

import java.util.Date;

public class LoginDTO {

	private String loginId;
	private String loginPw;
	private String loginCookie;
	
	
	
	@Override
	public String toString() {
		return "LoginDTO [loginId=" + loginId + ", loginPw=" + loginPw + ", loginCookie=" + loginCookie + "]";
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}
	public String getLoginCookie() {
		return loginCookie;
	}
	public void setLoginCookie(String loginCookie) {
		this.loginCookie = loginCookie;
	}
    
	
	

}
