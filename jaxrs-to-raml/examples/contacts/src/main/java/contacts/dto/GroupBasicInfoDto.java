package contacts.dto;

public class GroupBasicInfoDto {
	private String groupId;
	private String groupName;
	private String groupPortrait;
	/** 群中用户数量 */
	private Long groupUsersAmount;
	/**群类型*/
	private Integer type;

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

	public Long getGroupUsersAmount() {
		return groupUsersAmount;
	}

	public void setGroupUsersAmount(Long groupUsersAmount) {
		this.groupUsersAmount = groupUsersAmount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
