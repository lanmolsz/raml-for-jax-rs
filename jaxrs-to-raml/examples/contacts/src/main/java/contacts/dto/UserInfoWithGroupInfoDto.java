package contacts.dto;

public class UserInfoWithGroupInfoDto {
	private String userId;
	private String userName;
	private String protrait;
	private String phone;
	private GroupBasicInfoDto[] groups;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProtrait() {
		return protrait;
	}

	public void setProtrait(String protrait) {
		this.protrait = protrait;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public GroupBasicInfoDto[] getGroups() {
		return groups;
	}

	public void setGroups(GroupBasicInfoDto[] groups) {
		this.groups = groups;
	}

}
