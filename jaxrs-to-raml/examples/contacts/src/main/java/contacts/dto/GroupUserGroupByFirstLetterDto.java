package contacts.dto;

/**
 * 按名字首拼音分组的群成员列表项
 * 
 * @author liyongchun
 *
 */
public class GroupUserGroupByFirstLetterDto {
	private String nameFirstLetter;
	private GroupUserInfoDto[] users;

	public String getNameFirstLetter() {
		return nameFirstLetter;
	}

	public void setNameFirstLetter(String nameFirstLetter) {
		this.nameFirstLetter = nameFirstLetter;
	}

	public GroupUserInfoDto[] getUsers() {
		return users;
	}

	public void setUsers(GroupUserInfoDto[] users) {
		this.users = users;
	}
}
