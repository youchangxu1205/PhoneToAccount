package cn.xuchangyou.phonetoaccount.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.xuchangyou.phonetoaccount.R;

/**
 * Created by xuchangyou on 2017/12/17.
 */

public class SimplePaddingItemDecoration extends RecyclerView.ItemDecoration {


    private int dividerHeight;

    public SimplePaddingItemDecoration(Context context) {
        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }
}
