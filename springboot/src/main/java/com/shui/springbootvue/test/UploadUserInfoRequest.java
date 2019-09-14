package com.shui.springbootvue.test;


import java.util.List;

/**
 * @version 1.0
 * @Description
 * @Date 2019/5/23 14:10
 * @Author vnaLc
 */
public class UploadUserInfoRequest {
    /**
     * 用户库数据集
     */
    public List<BaseUser> baseUserList;

    /**
     * 等级信息
     */
    public List<BaseLevel> baseLevelList;

    /**
     * 渠道信息
     */
    public List<BaseChannel> baseChannelList;

    private String notify_url;

    public List<BaseUser> getBaseUserList() {
        return baseUserList;
    }

    public void setBaseUserList(List<BaseUser> baseUserList) {
        this.baseUserList = baseUserList;
    }

    public List<BaseLevel> getBaseLevelList() {
        return baseLevelList;
    }

    public void setBaseLevelList(List<BaseLevel> baseLevelList) {
        this.baseLevelList = baseLevelList;
    }

    public List<BaseChannel> getBaseChannelList() {
        return baseChannelList;
    }

    public void setBaseChannelList(List<BaseChannel> baseChannelList) {
        this.baseChannelList = baseChannelList;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }
}
