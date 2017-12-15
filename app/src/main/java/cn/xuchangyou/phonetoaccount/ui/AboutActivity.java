package cn.xuchangyou.phonetoaccount.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.xuchangyou.phonetoaccount.R;

/**
 * Created by Administrator on 2017/12/15.
 */

public class AboutActivity extends XActivity {
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
        return R.layout.activity_about;
    }

    @Override
    public Object newP() {
        return null;
    }
}
