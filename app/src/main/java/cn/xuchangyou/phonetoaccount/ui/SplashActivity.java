package cn.xuchangyou.phonetoaccount.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.router.Router;
import cn.xuchangyou.phonetoaccount.R;
import cn.xuchangyou.phonetoaccount.present.PBaseData;

/**
 * Created by Administrator on 2017/12/15.
 */

public class SplashActivity extends XActivity<PBaseData> {
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.tv_progress)
    TextView progressTv;

    @Override
    public void initData(Bundle savedInstanceState) {
        getP().initAccountTypeData();
    }

    /**
     * progressBar改变
     */
    public void progressBarChange() {
        progressBar.setVisibility(View.VISIBLE);
        progressTv.setVisibility(View.VISIBLE);
        //开启一个线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //得到progeressBar的最大长度
                int progressBarMax = progressBar.getMax();
                try {
                    //progressBar当前的长度没有达到他的最长度,让循环一直进行
                    while (progressBarMax != progressBar.getProgress()) {
                        //拿到一个每次前进的进度值,因为是要10s完成,所以分为10份
                        int stepProgress = progressBarMax / 10;
                        //progressBar当前的进度值
                        int currentProgress = progressBar.getProgress();
                        //让progressBar进度为每次前进最大值的十分之一
                        progressBar.setProgress(currentProgress + stepProgress);
                        //前进一次,睡眠一秒
                        Thread.sleep(1000);
                    }

                    toMainActivity();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        //开启线程
        thread.start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public PBaseData newP() {
        return new PBaseData();
    }

    public void toMainActivity() {

        Router.newIntent(this)
                .to(MainActivity.class)
                .launch();
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getP().onDestroy();
    }
}
