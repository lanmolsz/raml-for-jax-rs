package contacts.dto;

import java.sql.Timestamp;

public class UserLinkmanDto {

    private Long id;
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 联系人id
     */
    private String friendId;

    /**
     * 联系人名称
     */
    private String friendName;
    /**
     * 好友头像
     */
    private String portrait;

    /**
     * 添加时间
     */
    private Timestamp addedTime;
    /**
     * 用户手机号码
     */
    private String mobilePhone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public Timestamp getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
