package cn.xuchangyou.phonetoaccount.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.router.Router;
import cn.xuchangyou.phonetoaccount.R;
import cn.xuchangyou.phonetoaccount.adapter.MainAdapter;
import cn.xuchangyou.phonetoaccount.entity.Account;
import cn.xuchangyou.phonetoaccount.present.PMain;

public class MainActivity extends XActivity<PMain> {
    @BindView(R.id.navigation)
    NavigationView navigationView;
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.about:
                        Router.newIntent(MainActivity.this)
                                .to(AboutActivity.class)
                                .launch();
                        break;
                }
                return true;
            }
        });
        getP().loadData();

    }

    public void initRec(List<Account> accountList){
        MainAdapter mainAdapter = new MainAdapter(this,accountList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mainAdapter);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public PMain newP() {
        return new PMain();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.about:
                Router.newIntent(this)
                        .to(AboutActivity.class)
                        .launch();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
