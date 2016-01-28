package contacts.dto;

public class UserLinkmanFormattedDto {
	private String friendNameFirstLetter;
	private UserLinkmanDto[] friends;

	public String getFriendNameFirstLetter() {
		return friendNameFirstLetter;
	}

	public void setFriendNameFirstLetter(String friendNameFirstLetter) {
		this.friendNameFirstLetter = friendNameFirstLetter;
	}

	public UserLinkmanDto[] getFriends() {
		return friends;
	}

	public void setFriends(UserLinkmanDto[] friends) {
		this.friends = friends;
	}

}
