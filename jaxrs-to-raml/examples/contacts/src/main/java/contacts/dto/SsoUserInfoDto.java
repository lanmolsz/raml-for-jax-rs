package contacts.dto;

public class SsoUserInfoDto {
	private Long id;
	private String phone;
	private Integer phoneValidStatus;
	private String name;
	private String portrait;
	private Integer userType;
	private Integer userRole;
	private String email;
	private Integer emailValidStatus;
	private String nickname;
	private String account;
	private Integer accountValidStatus;
	private Integer sex;
	private String qq;
	private String city;

	public Long getId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.id = userId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phoneNo) {
		this.phone = phoneNo;
	}

	public Integer getPhoneValidStatus() {
		return phoneValidStatus;
	}

	public void setPhoneValidStatus(Integer phoneValidStatus) {
		this.phoneValidStatus = phoneValidStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String userPortrait) {
		this.portrait = userPortrait;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmailValidStatus() {
		return emailValidStatus;
	}

	public void setEmailValidStatus(Integer emailValidStatus) {
		this.emailValidStatus = emailValidStatus;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAccountValidStatus() {
		return accountValidStatus;
	}

	public void setAccountValidStatus(Integer accountValidStatus) {
		this.accountValidStatus = accountValidStatus;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
