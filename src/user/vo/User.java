package user.vo;

import java.sql.Date;

public class User {
	private String uid; // 아이디
	private String pw; // 비밀번호
	private String uname; // 이름
	private String nickname; // 별명
	private int age; // 나이
	private char gender; // 성별
	private String email; // 이메일
	private String phone; // 전화번호
	private String address; // 주소
	private Date join_date; // 가입날짜
	private int point; // 포인트
	private char type; // 회원 종류

	public User() {
		
	}

public User(String uid,String pw,String uname,String nickname,int age,char gender,String email,String phone,String address,Date join_date,int point,char type) {
		this.uid=uid;
		this.pw=pw;
		this.uname=uname;
		this.nickname=nickname;
		this.age=age;
		this.gender=gender;
		this.email=email;
		this.phone=phone;
		this.address=address;
		this.join_date=join_date;
		this.point=point;
		this.type=type;
	}

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public String getPw() {
	return pw;
}

public void setPw(String pw) {
	this.pw = pw;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public char getGender() {
	return gender;
}

public void setGender(char gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Date getJoin_date() {
	return join_date;
}

public void setJoin_date(Date join_date) {
	this.join_date = join_date;
}

public int getPoint() {
	return point;
}

public void setPoint(int point) {
	this.point = point;
}

public char getType() {
	return type;
}

public void setType(char type) {
	this.type = type;
}

@Override
public String toString() {
	return "User [uid=" + uid + ", pw=" + pw + ", uname=" + uname + ", nickname=" + nickname + ", age=" + age
			+ ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", join_date="
			+ join_date + ", point=" + point + ", type=" + type + "]";
}


}
