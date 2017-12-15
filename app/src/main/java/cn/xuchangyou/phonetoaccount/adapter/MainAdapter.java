package cn.xuchangyou.phonetoaccount.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter;
import cn.droidlover.xdroidmvp.kit.KnifeKit;
import cn.xuchangyou.phonetoaccount.R;
import cn.xuchangyou.phonetoaccount.entity.Account;

/**
 * Created by Administrator on 2017/12/15.
 */

public class MainAdapter extends SimpleRecAdapter<Account, MainAdapter.ViewHolder> {
    private List<Account> accountList;

    public MainAdapter(Context context) {
        super(context);
    }

    public MainAdapter(Context context, List<Account> accountList) {
        super(context);
        this.accountList = accountList;
        if (accountList == null) {
            this.accountList = new ArrayList<>();
        }
    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_account;
    }

    public Account getItem(int position){
        return accountList.get(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Account account = getItem(position);
        holder.accountNameTv.setText(account.getAccountName());
        holder.accountTypeTv.setText(account.getAccountType());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_account_name)
        TextView accountNameTv;
        @BindView(R.id.tv_account_type)
        TextView accountTypeTv;

        public ViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(this, itemView);
        }
    }
}
