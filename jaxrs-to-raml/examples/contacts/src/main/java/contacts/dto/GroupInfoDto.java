package contacts.dto;

public class GroupInfoDto {
    private String groupId;
    private String groupName;
    private String groupPortrait;
    private GroupUserInfoDto owner;
    private GroupUserInfoDto[] admins;
    private String introduction;
    private String proclamation;
    private Integer type;
    private boolean open;
    /**
     * 用户是否已经加入该群
     */
    private boolean joined;
    private Integer catalogId;
    /**
     * 分类名称
     */
    private String catalogName;
    private GroupUserInfoDto[] members;
    private String province;
    private String city;
    private String county;
    private String addressText;

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getProclamation() {
        return proclamation;
    }

    public void setProclamation(String proclamation) {
        this.proclamation = proclamation;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public GroupUserInfoDto[] getMembers() {
        return members;
    }

    public void setMembers(GroupUserInfoDto[] members) {
        this.members = members;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

}
