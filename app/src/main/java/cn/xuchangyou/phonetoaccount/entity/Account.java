package cn.xuchangyou.phonetoaccount.entity;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by Administrator on 2017/12/14.
 */

public class Account implements Serializable ,Comparable<Account> {
    //账号
    private String accountName;
    //手机号
    private String phone;
    //账号类型
    private String accountType;
    //主键
    private String id;
    //账号密码
    private String accountPwd;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int compareTo(@NonNull Account o) {
        return o.getCreateTime().compareTo(this.getCreateTime());

    }
}
