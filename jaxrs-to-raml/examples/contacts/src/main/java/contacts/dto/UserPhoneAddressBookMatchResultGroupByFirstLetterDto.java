package contacts.dto;

public class UserPhoneAddressBookMatchResultGroupByFirstLetterDto {

	private String nameFirstLetter;
	private UserPhoneAddressBookMatchDto[] matchedResults;

	public String getNameFirstLetter() {
		return nameFirstLetter;
	}

	public void setNameFirstLetter(String nameFirstLetter) {
		this.nameFirstLetter = nameFirstLetter;
	}

	public UserPhoneAddressBookMatchDto[] getMatchedResults() {
		return matchedResults;
	}

	public void setMatchedResults(UserPhoneAddressBookMatchDto[] matchedResults) {
		this.matchedResults = matchedResults;
	}
}
