package contacts.dto;

public class GroupUserDetailDto {
	private String userId;
	private String userName;
	private String userPortrait;
	/** 在群中的名称 */
	private String userNameInGroup;
	private String location;
	private Integer groupUserType;
	private GroupBasicInfoDto[] groupsOfUser;
	private boolean myLinkman;

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

	public String getUserPortrait() {
		return userPortrait;
	}

	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait;
	}

	public String getUserNameInGroup() {
		return userNameInGroup;
	}

	public void setUserNameInGroup(String userNameInGroup) {
		this.userNameInGroup = userNameInGroup;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getGroupUserType() {
		return groupUserType;
	}

	public void setGroupUserType(Integer groupUserType) {
		this.groupUserType = groupUserType;
	}

	public GroupBasicInfoDto[] getGroupsOfUser() {
		return groupsOfUser;
	}

	public void setGroupsOfUser(GroupBasicInfoDto[] groupsOfUser) {
		this.groupsOfUser = groupsOfUser;
	}

	public boolean isMyLinkman() {
		return myLinkman;
	}

	public void setMyLinkman(boolean myLinkman) {
		this.myLinkman = myLinkman;
	}

}
