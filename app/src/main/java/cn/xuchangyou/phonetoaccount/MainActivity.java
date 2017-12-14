package cn.xuchangyou.phonetoaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yuyh.easydao.DB;
import com.yuyh.easydao.base.BaseEntity;
import com.yuyh.easydao.exception.DBException;
import com.yuyh.easydao.interfaces.IDAO;
import com.yuyh.easydao.interfaces.IDBListener;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.log.XLog;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.xuchangyou.phonetoaccount.entity.Account;

public class MainActivity extends XActivity {
    @BindView(R.id.btn_open_to_finger)
    Button btnOpen;


    @Override
    public void initData(Bundle savedInstanceState) {
        try {
            IDAO<Account> account = DB.getInstance(this).getDatabase(1, "account", new IDBListener<Account>() {
                @Override
                public void onUpdate(IDAO<Account> dao, int oldVersion, int newVersion) {

                }
            });
            if(!account.isTableExist("ACCOUNT")) {
                XLog.d("table exist");
                account.createTable(Account.class, "ACCOUNT");
            }
            account.initTable("ACCOUNT",Account.class);
            Account account1 = new Account();
            account1.setAccountName("598968602");
            account1.setAccountType("QQ");
            account1.setPhone("18039211881");
            account.save(account1);

            XLog.d("account",account.findAll().get(0).getAccountName());
        } catch (DBException e) {
            e.printStackTrace();
        }
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FingerActivity.class));
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }


}
