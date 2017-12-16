package cn.xuchangyou.phonetoaccount.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.xuchangyou.phonetoaccount.R;
import cn.xuchangyou.phonetoaccount.present.PAddAccount;

/**
 * Created by xuchangyou on 2017/12/16.
 */

public class AddAccountActivity extends XActivity<PAddAccount> {
    @BindView(R.id.tool_bar)
    Toolbar toolbar;

    @BindView(R.id.et_account_name)
    EditText accountNameEt;
    @BindView(R.id.et_account_type)
    EditText accountTypeEt;
    @BindView(R.id.et_account_phone)
    EditText accountPhoneEt;
    @BindView(R.id.et_account_pwd)
    EditText accountPwdEt;

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @OnClick(R.id.btn_save)
    public void save(){
        String accountName = accountNameEt.getText().toString().trim();
        String accountType = accountTypeEt.getText().toString().trim();
        String accountPhone = accountPhoneEt.getText().toString().trim();
        String accountPwd = accountPwdEt.getText().toString().trim();

        getP().addAccount(accountName,accountType,accountPhone,accountPwd);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_account;
    }

    @Override
    public PAddAccount newP() {
        return new PAddAccount();
    }


}
