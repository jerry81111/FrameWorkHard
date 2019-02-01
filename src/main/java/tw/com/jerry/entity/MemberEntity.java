package tw.com.jerry.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MEMBER")
public class MemberEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private String account;
	private String password;
	private String role;
	private String mema;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMema() {
		return mema;
	}
	public void setMema(String mema) {
		this.mema = mema;
	}
	
	
}
