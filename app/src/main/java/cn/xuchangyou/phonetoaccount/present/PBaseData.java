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
    private DB db;

    /**
     * 初始化账号类型
     * QQ
     * 微信等
     */
    public void initAccountTypeData() {
        try {
            db = DBFactory.open(getV(), Constants.ACCOUNT_DB_NAME);
            if (db.exists(Constants.IS_INITED)) {
                boolean is_init = db.getBoolean(Constants.IS_INITED);
                if (is_init) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getV().toMainActivity();
                        }
                    },2000);
                    return;
                }
            }
            getV().progressBarChange();
            String[] acountType = {"QQ"};
            db.put(Constants.ACCOUNT_TYPE, acountType);
            db.putBoolean(Constants.IS_INITED, true);

            db.close();

        } catch (SnappydbException e) {
            e.printStackTrace();

        }
    }


    public void onDestroy() {

        if(db!=null){
            try {
                db.destroy();
            } catch (SnappydbException e) {
                e.printStackTrace();
            }
        }
        db = null;
    }
}
