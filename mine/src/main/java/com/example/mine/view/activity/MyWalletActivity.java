package com.example.mine.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mine.R;
import com.example.mine.view.fragment.mywallet.BingDingFragment;

public class MyWalletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);

        BingDingFragment bingDingFragment = new BingDingFragment();

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .add(R.id.myWalletFrame,bingDingFragment)
                .commit();


    }
}
