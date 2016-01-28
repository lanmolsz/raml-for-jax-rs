package contacts.dto;

public class UserWithinGroupsDto {

	private String groupId;
	private String groupName;
	private String groupPortrait;
	private String userId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupPortrait() {
		return groupPortrait;
	}

	public void setGroupPortrait(String groupPortrait) {
		this.groupPortrait = groupPortrait;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
