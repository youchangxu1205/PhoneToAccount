package cn.xuchangyou.phonetoaccount.present;

import android.content.Intent;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.xuchangyou.phonetoaccount.Constants;
import cn.xuchangyou.phonetoaccount.entity.Account;
import cn.xuchangyou.phonetoaccount.ui.MainActivity;

/**
 * Created by Administrator on 2017/12/15.
 */

public class PMain extends XPresent<MainActivity> {


    public void loadData() {
        try {
            List<Account> accounts = new ArrayList<>();
            DB db = DBFactory.open(getV(), Constants.ACCOUNT_DB_NAME);
            String[] keys = db.findKeys(Constants.ACCOUNT_PREFIX);
                for (String key : keys) {
                    accounts.add(db.get(key, Account.class));
            }
            Collections.sort(accounts);
            getV().initRec(accounts);

        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    public void refreshData(Intent data) {
        Account account = (Account) data.getSerializableExtra(Constants.NEW_ACCOUNT_INFO);
        getV().refreshRec(account);

    }
}
