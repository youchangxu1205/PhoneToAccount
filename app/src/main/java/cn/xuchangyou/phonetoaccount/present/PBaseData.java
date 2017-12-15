package cn.xuchangyou.phonetoaccount.present;

import android.os.Handler;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.xuchangyou.phonetoaccount.Constants;
import cn.xuchangyou.phonetoaccount.ui.SplashActivity;

/**
 * Created by Administrator on 2017/12/15.
 */

public class PBaseData extends XPresent<SplashActivity> {
    /**
     * 初始化账号类型
     * QQ
     * 微信等
     */
    public void initAccountTypeData() {
        try {
            DB db = DBFactory.open(getV(), Constants.ACCOUNT_DB_NAME);
//            if (db.exists(Constants.IS_INITED)) {
//                boolean is_init = db.getBoolean(Constants.IS_INITED);
//                if (is_init) {
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            getV().toMainActivity();
//                        }
//                    },2000);
//                    return;
//                }
//            }
            getV().progressBarChange();
            String[] acountType = {"QQ"};
            db.put(Constants.ACCOUNT_TYPE, acountType);
            db.putBoolean(Constants.IS_INITED, true);
        } catch (SnappydbException e) {
            e.printStackTrace();

        }
    }
}
