package com.example.lottietabviewdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chason.lottieview.LottieTabView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.tab_view_main)
    LottieTabView mLottieMainTab;
    @BindView(R.id.tab_view_deal)
    LottieTabView mLottieDealTab;
    @BindView(R.id.main_add_btn)
    ImageView mainAddBtn;
    @BindView(R.id.tab_view_msg)
    LottieTabView mLottieMsgTab;
    @BindView(R.id.tab_view_mine)
    LottieTabView mLottieMineTab;
    @BindView(R.id.tab_layout)
    LinearLayout tabLayout;
    @BindView(R.id.main_bg)
    LinearLayout mainBg;

    private Fragment fragment1, fragment2, fragment3, fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLottieTabView();
    }

    private void initLottieTabView() {
        mLottieMainTab.selected();
        mLottieMsgTab.showMsg(10);
        displayFragment(0);
    }

    @OnClick({R.id.tab_view_main, R.id.tab_view_msg, R.id.tab_view_deal, R.id.tab_view_mine, R.id.main_add_btn})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.tab_view_main:
                displayFragment(0);
                mLottieMainTab.selected();
                mLottieMsgTab.unSelected();
                mLottieDealTab.unSelected();
                mLottieMineTab.unSelected();
                break;
            case R.id.tab_view_msg:
                displayFragment(1);
                mLottieMsgTab.selected();
                mLottieDealTab.unSelected();
                mLottieMineTab.unSelected();
                mLottieMainTab.unSelected();
                break;
            case R.id.tab_view_deal:
                displayFragment(2);
                mLottieDealTab.selected();
                mLottieMsgTab.unSelected();
                mLottieMineTab.unSelected();
                mLottieMainTab.unSelected();
                break;
            case R.id.tab_view_mine:
                displayFragment(3);
                mLottieMineTab.selected();
                mLottieMsgTab.unSelected();
                mLottieDealTab.unSelected();
                mLottieMainTab.unSelected();
                break;
            case R.id.main_add_btn:
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void displayFragment(int position) {
        hideFragment();
        switch (position) {
            case 0:
                if (fragment1 == null) {
                    fragment1 = MainFragment.newInstance(null, null);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_main, fragment1).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(fragment1).commit();
                }
                break;
            case 1:
                if (fragment2 == null) {
                    fragment2 = MsgFragment.newInstance(null, null);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_main, fragment2).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(fragment2).commit();
                }
                break;
            case 2:
                if (fragment3 == null) {
                    fragment3 = DealFragment.newInstance(null, null);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_main, fragment3).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(fragment3).commit();
                }
                break;
            case 3:
                if (fragment4 == null) {
                    fragment4 = MineFragment.newInstance(null, null);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_main, fragment4).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().show(fragment4).commit();
                }
                break;
        }
    }

    private void hideFragment() {
        if (fragment1 != null) {
            getSupportFragmentManager().beginTransaction().hide(fragment1).commit();
        }

        if (fragment2 != null) {
            getSupportFragmentManager().beginTransaction().hide(fragment2).commit();
        }

        if (fragment3 != null) {
            getSupportFragmentManager().beginTransaction().hide(fragment3).commit();
        }

        if (fragment4 != null) {
            getSupportFragmentManager().beginTransaction().hide(fragment4).commit();
        }

    }
}