package com.windy.medivh.common.entity;

import java.io.Serializable;

/**
 * Created by liukegang on 17/1/3.
 */

public class MessageReceiver implements Serializable{
    public static final long serialVersionUID = 776607543411920451L;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 钉钉号
     */
    private String dingdingUserId;
    /**
     * acura系统中User表员工ID（推荐使用）
     * 包涵了maybach中admin表中adminId
     */
    private String staffId;
    /**
     * maybach中admin表中adminId
     * 已废弃，推荐使用staffId字段
     */
    @Deprecated
    private Long adminId;

    public MessageReceiver() {
    }

    @Deprecated
    public MessageReceiver(String mobile, String mail, Long adminId) {
        this.mobile = mobile;
        this.mail = mail;
        this.adminId = adminId;
    }

    public MessageReceiver(String mobile, String mail,String dingdingUserId) {
        this.mobile = mobile;
        this.mail = mail;
        this.dingdingUserId = dingdingUserId;
    }

    public MessageReceiver(String staffId){
        this.staffId = staffId;
    }

    @Deprecated
    public MessageReceiver(Long adminId){
        this.adminId = adminId;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Deprecated
    public Long getAdminId() {
        return adminId;
    }

    @Deprecated
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getDingdingUserId() {
        return dingdingUserId;
    }

    public void setDingdingUserId(String dingdingUserId) {
        this.dingdingUserId = dingdingUserId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
