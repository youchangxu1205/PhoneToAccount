package cn.xuchangyou.phonetoaccount.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.xuchangyou.phonetoaccount.R;
import cn.xuchangyou.phonetoaccount.view.FingerPrinterView;
import rx.Subscriber;
import rx.Subscription;
import zwh.com.lib.FPerException;
import zwh.com.lib.RxFingerPrinter;

/**
 * Created by Administrator on 2017/12/13.
 */

public class FingerActivity extends XActivity {
    private FingerPrinterView fingerPrinterView;
    private int fingerErrorNum = 0;
    private RxFingerPrinter rxfingerPrinter;


    @Override
    public void initData(Bundle savedInstanceState) {

        fingerPrinterView = (FingerPrinterView) findViewById(R.id.fpv);
        fingerPrinterView.setOnStateChangedListener(new FingerPrinterView.OnStateChangedListener() {
            @Override
            public void onChange(int state) {
                if (state == FingerPrinterView.STATE_CORRECT_PWD) {
                    fingerErrorNum = 0;
                    Toast.makeText(FingerActivity.this, "指纹识别成功", Toast.LENGTH_SHORT).show();
                }
                if (state == FingerPrinterView.STATE_WRONG_PWD) {
                    Toast.makeText(FingerActivity.this, "指纹识别失败，还剩" + (5 - fingerErrorNum) + "次机会",
                            Toast.LENGTH_SHORT).show();
                    fingerPrinterView.setState(FingerPrinterView.STATE_NO_SCANING);
                }
            }
        });
        rxfingerPrinter = new RxFingerPrinter(this);
        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fingerErrorNum = 0;
                rxfingerPrinter.unSubscribe(this);
                Subscription subscription = rxfingerPrinter.begin().subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        if (fingerPrinterView.getState() == FingerPrinterView.STATE_SCANING) {
                            return;
                        } else if (fingerPrinterView.getState() == FingerPrinterView.STATE_CORRECT_PWD
                                || fingerPrinterView.getState() == FingerPrinterView.STATE_WRONG_PWD) {
                            fingerPrinterView.setState(FingerPrinterView.STATE_NO_SCANING);
                        } else {
                            fingerPrinterView.setState(FingerPrinterView.STATE_SCANING);
                        }
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof FPerException) {
                            Toast.makeText(FingerActivity.this, ((FPerException) e).getDisplayMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (aBoolean) {
                            fingerPrinterView.setState(FingerPrinterView.STATE_CORRECT_PWD);
                            finish();
                        } else {
                            fingerErrorNum++;
                            fingerPrinterView.setState(FingerPrinterView.STATE_WRONG_PWD);
                        }
                    }
                });
                rxfingerPrinter.addSubscription(this, subscription);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_finger;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rxfingerPrinter.unSubscribe(this);

    }
}
