package cn.xuchangyou.phonetoaccount.entity;

import com.yuyh.easydao.annotation.Column;
import com.yuyh.easydao.base.BaseEntity;

/**
 * Created by Administrator on 2017/12/14.
 */

public class Account extends BaseEntity{
    @Column
    private String accountName;
    @Column
    private String phone;
    @Column
    private String accountType;


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
}
