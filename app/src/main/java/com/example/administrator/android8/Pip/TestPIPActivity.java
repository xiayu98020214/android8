package com.example.administrator.android8.Pip;

import android.annotation.TargetApi;
import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Rational;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/12/21.
 */

public class TestPIPActivity extends AppCompatActivity {
    private static final String TAG = "TestPIPActivity";
    private PictureInPictureParams.Builder mPictureInPictureParamsBuilder;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout content = new FrameLayout(this);
        setContentView(content, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mPictureInPictureParamsBuilder = new PictureInPictureParams.Builder();

            final TextView textView = new TextView(this);
            textView.setText("test PIP");
            textView.setTextSize(20);
            FrameLayout.LayoutParams fl = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            fl.gravity = Gravity.CENTER;
            textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {//主要操作
                    Rational aspectRatio = new Rational(10, 10);
                    mPictureInPictureParamsBuilder.setAspectRatio(aspectRatio).build();
                    enterPictureInPictureMode(mPictureInPictureParamsBuilder.build());
                }
            });
            content.addView(textView, fl);

        } else {
            TextView descTv = new TextView(this);
            descTv.setText("当前版本不支持...");
            descTv.setTextSize(20);
            FrameLayout.LayoutParams Tvfl = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            Tvfl.gravity = Gravity.CENTER;
            content.addView(descTv, Tvfl);
        }

    }


    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        Log.d(TAG, String.valueOf(isInPictureInPictureMode));
    }
}
