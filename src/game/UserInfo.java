package game;

import java.io.Serializable;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String pw;
	private String email;
	private boolean gender;
	int win;//추후 사용할 전적
	
	public UserInfo() {//데이터 로드시 가져올 생성자
		
	}
	
	public UserInfo(String id, String name, String pw, String email) {//계정 생성시 사용할 생성자
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getPw() {
		return pw;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {//문자열로 전환이 필요할 경우 사용
		return "User{" + "id=" + id + ", pw='" + pw + '\'' + ", name='" + name + '\'' + ", email='" + email + '}';
	}

}
