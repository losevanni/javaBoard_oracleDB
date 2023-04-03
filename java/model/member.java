package model;

public class member {
	private String id;
	private String pw;
	private String name;
	private java.sql.Date memberdate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw=pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public java.sql.Date getMemberdate() {
		return memberdate;
	}
	public void setMemberdate(String id) {
		this.memberdate=memberdate;
	}
}
