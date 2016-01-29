package contacts.dto;

import java.sql.Timestamp;

public class LinkmanRequestDto {
    private Long invitationId;
    /**
     * 向谁请求
     */
    private String inviteeId;
    /**
     * 请求人Id
     */
    private String inviterId;
    /**
     * 请求人名称
     */
    private String inviterName;
    /**
     * 请求人头像
     */
    private String inveterPortrait;
    /**
     * 从那个群中发起请求（可为空）
     */
    private String fromGroupId;
    /**
     * 群名称
     */
    private String fromGroupName;
    /**
     * 请求时间
     */
    private Timestamp inviteTime;
    /**
     * 请求状态 1:未处理 2:接受请求 4：请求被拒绝 8:被忽略（用户使用了清空功能）
     */
    private Integer status;
    /**
     * 处理时间，根据请求状态的不同可能为接受请求时间，拒绝时间，忽略时间等
     */
    private Timestamp handleTime;
    /**
     * 发起请求时，对方的请求信息
     */
    private String invitationMessage;
    /**
     * 邀请类型 1:好友请求 2：来自群的邀请
     */
    private Integer type;

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long id) {
        invitationId = id;
    }

    public String getInviteeId() {
        return inviteeId;
    }

    public void setInviteeId(String inviteeId) {
        this.inviteeId = inviteeId;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName;
    }

    public String getInveterPortrait() {
        return inveterPortrait;
    }

    public void setInveterPortrait(String inveterPortrait) {
        this.inveterPortrait = inveterPortrait;
    }

    public String getFromGroupId() {
        return fromGroupId;
    }

    public void setFromGroupId(String fromGroupId) {
        this.fromGroupId = fromGroupId;
    }

    public String getFromGroupName() {
        return fromGroupName;
    }

    public void setFromGroupName(String fromGroupName) {
        this.fromGroupName = fromGroupName;
    }

    public Timestamp getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Timestamp inviteTime) {
        this.inviteTime = inviteTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Timestamp handleTime) {
        this.handleTime = handleTime;
    }

    public String getInvitationMessage() {
        return invitationMessage;
    }

    public void setInvitationMessage(String invitationMessage) {
        this.invitationMessage = invitationMessage;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
