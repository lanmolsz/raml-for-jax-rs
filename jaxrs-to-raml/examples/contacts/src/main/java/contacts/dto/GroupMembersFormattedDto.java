package contacts.dto;

public class GroupMembersFormattedDto {
	private GroupUserInfoDto owner;
	private GroupUserInfoDto[] admins;
	private GroupUserGroupByFirstLetterDto[] members;

	public GroupUserInfoDto getOwner() {
		return owner;
	}

	public void setOwner(GroupUserInfoDto owner) {
		this.owner = owner;
	}

	public GroupUserInfoDto[] getAdmins() {
		return admins;
	}

	public void setAdmins(GroupUserInfoDto[] admins) {
		this.admins = admins;
	}

	public GroupUserGroupByFirstLetterDto[] getMembers() {
		return members;
	}

	public void setMembers(GroupUserGroupByFirstLetterDto[] members) {
		this.members = members;
	}
}
