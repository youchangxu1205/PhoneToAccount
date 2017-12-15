package cn.xuchangyou.phonetoaccount.present;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.List;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.xuchangyou.phonetoaccount.entity.Account;
import cn.xuchangyou.phonetoaccount.ui.MainActivity;

/**
 * Created by Administrator on 2017/12/15.
 */

public class PMain extends XPresent<MainActivity> {


    public void loadData() {
        try {
            List<Account> accounts = new ArrayList<>();
            DB db = DBFactory.open(getV(), "account");
            for (String[] batch : db.findKeysIterator("account").byBatch(1)) {
                for (String key : batch) {
                    accounts.add(db.get(key, Account.class));
                }
            }
            getV().initRec(accounts);

        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }
}
