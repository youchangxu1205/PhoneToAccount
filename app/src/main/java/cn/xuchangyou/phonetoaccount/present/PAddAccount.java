package cn.xuchangyou.phonetoaccount.present;

import android.content.Intent;

import com.scottyab.aescrypt.AESCrypt;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.security.GeneralSecurityException;
import java.util.Date;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.xuchangyou.phonetoaccount.Constants;
import cn.xuchangyou.phonetoaccount.entity.Account;
import cn.xuchangyou.phonetoaccount.ui.AddAccountActivity;

/**
 * Created by xuchangyou on 2017/12/16.
 */

public class PAddAccount extends XPresent<AddAccountActivity> {

    public void addAccount(String accountName, String accountType, String accountPhone, String accountPwd) {
        try {
            DB db = DBFactory.open(getV(), Constants.ACCOUNT_DB_NAME);
            int i = db.countKeys(Constants.ACCOUNT_PREFIX) + 1;
            Account account = new Account();
            account.setAccountName(accountName);
            account.setAccountType(accountType);
            account.setAccountPwd(AESCrypt.encrypt(accountPwd, Constants.PWD_MESSAGE));
            account.setPhone(accountPhone);
            account.setCreateTime(new Date());
            db.put(Constants.ACCOUNT_PREFIX + ":" + i, account);
            db.close();
            Intent intent = new Intent(Constants.ADD_ACCOUNT_ACTION);
            intent.putExtra(Constants.NEW_ACCOUNT_INFO, account);
            getV().setResult(Constants.ADD_ACCOUNT_CODE, intent);
            getV().finish();
        } catch (SnappydbException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
