package contacts.dto;

public class UserInfoWithIsMyLinkmanDto {
	private String userId;
	private String userName;
	private String portrait;
	/**
	 * 找到的用户跟我的关系 1：是我的联系人 2：陌生人 0：本人
	 */
	private int myRelation;
	private String phoneNo;
	private Integer sex;

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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public int getMyRelation() {
		return myRelation;
	}

	public void setMyRelation(int myRelation) {
		this.myRelation = myRelation;
	}

}
