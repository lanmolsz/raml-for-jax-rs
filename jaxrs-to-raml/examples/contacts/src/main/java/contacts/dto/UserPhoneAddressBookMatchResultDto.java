package contacts.dto;

public class UserPhoneAddressBookMatchResultDto {
    private UserPhoneAddressBookMatchDto[] registedAndMyLinkmen;
    private UserPhoneAddressBookMatchDto[] registedButNotMyLinkmen;
    private UserPhoneAddressBookMatchResultGroupByFirstLetterDto[] noRegistedFriends;

    public UserPhoneAddressBookMatchDto[] getRegistedAndMyLinkmen() {
        return registedAndMyLinkmen;
    }

    public void setRegistedAndMyLinkmen(UserPhoneAddressBookMatchDto[] registedAndMyLinkmen) {
        this.registedAndMyLinkmen = registedAndMyLinkmen;
    }

    public UserPhoneAddressBookMatchDto[] getRegistedButNotMyLinkmen() {
        return registedButNotMyLinkmen;
    }

    public void setRegistedButNotMyLinkmen(UserPhoneAddressBookMatchDto[] registedButNotMyLinkmen) {
        this.registedButNotMyLinkmen = registedButNotMyLinkmen;
    }

    public UserPhoneAddressBookMatchResultGroupByFirstLetterDto[] getNoRegistedFriends() {
        return noRegistedFriends;
    }

    public void setNoRegistedFriends(UserPhoneAddressBookMatchResultGroupByFirstLetterDto[] noRegistedFriends) {
        this.noRegistedFriends = noRegistedFriends;
    }

}
