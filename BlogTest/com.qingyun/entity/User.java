package entity;

public class User {
	private String username;
	private String pwd;
	private String nickname;
	private String email;
	public User() {}
	
	public User(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	public User(String username, String pwd, String nickname, String email) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.nickname = nickname;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
