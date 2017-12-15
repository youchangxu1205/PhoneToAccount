package cn.xuchangyou.phonetoaccount.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/14.
 */

public class Account implements Serializable {
    private String accountName;
    private String phone;
    private String accountType;
    private String id;

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
}
