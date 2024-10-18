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
	int win;//���� ����� ����
	
	public UserInfo() {//������ �ε�� ������ ������
		
	}
	
	public UserInfo(String id, String name, String pw, String email) {//���� ������ ����� ������
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
	public String toString() {//���ڿ��� ��ȯ�� �ʿ��� ��� ���
		return "User{" + "id=" + id + ", pw='" + pw + '\'' + ", name='" + name + '\'' + ", email='" + email + '}';
	}

}
