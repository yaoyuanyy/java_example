package com.yy.mybatis_generator.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 管家评价租客表
 *
 * @author 
 */
public class ButlerEvaluateUser implements Serializable {
    /**
     * 自增主键
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private Long id;

    /**
     * 管家_id
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private Long butler_id;

    /**
     * 管家公司名称
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private String business_name;

    /**
     * 用户名
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private String user_name;

    /**
     * 手机号
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private String mobile;

    /**
     * 头像url
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private String avatar_url;

    /**
     * 备注
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private String remark;

    /**
     * 评价时间
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private Date ctime;

    /**
     * 更新时间
     *
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private Date mtime;

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column butler_evaluate_user.id
     *
     * @return the value of butler_evaluate_user.id
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.id
     *
     * @param id the value for butler_evaluate_user.id
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.butler_id
     *
     * @return the value of butler_evaluate_user.butler_id
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public Long getButler_id() {
        return butler_id;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withButler_id(Long butler_id) {
        this.setButler_id(butler_id);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.butler_id
     *
     * @param butler_id the value for butler_evaluate_user.butler_id
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setButler_id(Long butler_id) {
        this.butler_id = butler_id;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.business_name
     *
     * @return the value of butler_evaluate_user.business_name
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public String getBusiness_name() {
        return business_name;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withBusiness_name(String business_name) {
        this.setBusiness_name(business_name);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.business_name
     *
     * @param business_name the value for butler_evaluate_user.business_name
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.user_name
     *
     * @return the value of butler_evaluate_user.user_name
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withUser_name(String user_name) {
        this.setUser_name(user_name);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.user_name
     *
     * @param user_name the value for butler_evaluate_user.user_name
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.mobile
     *
     * @return the value of butler_evaluate_user.mobile
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withMobile(String mobile) {
        this.setMobile(mobile);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.mobile
     *
     * @param mobile the value for butler_evaluate_user.mobile
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.avatar_url
     *
     * @return the value of butler_evaluate_user.avatar_url
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public String getAvatar_url() {
        return avatar_url;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withAvatar_url(String avatar_url) {
        this.setAvatar_url(avatar_url);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.avatar_url
     *
     * @param avatar_url the value for butler_evaluate_user.avatar_url
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.remark
     *
     * @return the value of butler_evaluate_user.remark
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.remark
     *
     * @param remark the value for butler_evaluate_user.remark
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.ctime
     *
     * @return the value of butler_evaluate_user.ctime
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withCtime(Date ctime) {
        this.setCtime(ctime);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.ctime
     *
     * @param ctime the value for butler_evaluate_user.ctime
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * This method returns the value of the database column butler_evaluate_user.mtime
     *
     * @return the value of butler_evaluate_user.mtime
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public Date getMtime() {
        return mtime;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public ButlerEvaluateUser withMtime(Date mtime) {
        this.setMtime(mtime);
        return this;
    }

    /**
     * This method sets the value of the database column butler_evaluate_user.mtime
     *
     * @param mtime the value for butler_evaluate_user.mtime
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", butler_id=").append(butler_id);
        sb.append(", business_name=").append(business_name);
        sb.append(", user_name=").append(user_name);
        sb.append(", mobile=").append(mobile);
        sb.append(", avatar_url=").append(avatar_url);
        sb.append(", remark=").append(remark);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ButlerEvaluateUser other = (ButlerEvaluateUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getButler_id() == null ? other.getButler_id() == null : this.getButler_id().equals(other.getButler_id()))
            && (this.getBusiness_name() == null ? other.getBusiness_name() == null : this.getBusiness_name().equals(other.getBusiness_name()))
            && (this.getUser_name() == null ? other.getUser_name() == null : this.getUser_name().equals(other.getUser_name()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAvatar_url() == null ? other.getAvatar_url() == null : this.getAvatar_url().equals(other.getAvatar_url()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()));
    }

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getButler_id() == null) ? 0 : getButler_id().hashCode());
        result = prime * result + ((getBusiness_name() == null) ? 0 : getBusiness_name().hashCode());
        result = prime * result + ((getUser_name() == null) ? 0 : getUser_name().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAvatar_url() == null) ? 0 : getAvatar_url().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        return result;
    }
}