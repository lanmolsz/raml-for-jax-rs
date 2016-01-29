package contacts.dto;

/**
 * 用户手机通讯录与生意街APP联系人匹配结果
 *
 * @author liyongchun
 */
public class UserPhoneAddressBookMatchDto {
    /**
     * 手机号码
     */
    private String phoneNo;
    /**
     * 手机通讯录中记录的好友名字
     */
    private String phoneLinkmanName;
    /**
     * 通讯录好友在app中的Id
     */
    private String appUserId;
    /**
     * 通讯录好友在app中的名字
     */
    private String appUserName;
    /**
     * 通讯录好友在app中的头像
     */
    private String appUserPortrait;

    /**
     * 匹配结果 0:用户未注册 1:用户已注册并且已经是联系人 2:用户已注册但是不是我的联系人
     */
    // private Integer matchResult;
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneLinkmanName() {
        return phoneLinkmanName;
    }

    public void setPhoneLinkmanName(String phoneLinkmanName) {
        this.phoneLinkmanName = phoneLinkmanName;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getAppUserPortrait() {
        return appUserPortrait;
    }

    public void setAppUserPortrait(String appUserPortrait) {
        this.appUserPortrait = appUserPortrait;
    }
    // public Integer getMatchResult() {
    // return matchResult;
    // }
    //
    // public void setMatchResult(Integer matchResult) {
    // this.matchResult = matchResult;
    // }

}
